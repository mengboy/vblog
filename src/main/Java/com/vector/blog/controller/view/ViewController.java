package com.vector.blog.controller.view;

import com.vector.blog.common.QueryBase;
import com.vector.blog.common.Response;
import com.vector.blog.common.ftl.Ftl;
import com.vector.blog.model.Comment;
import com.vector.blog.model.Link;
import com.vector.blog.model.Statistic;
import com.vector.blog.model.User;
import com.vector.blog.model.admin.Admin;
import com.vector.blog.service.ArticleService;
import com.vector.blog.service.CommentService;
import com.vector.blog.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;

/**
 * Created by vector on 2017/4/30.
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    @Resource
    ArticleService articleService;

    @Resource
    CommentService commentService;


    @RequestMapping("/index")
    public ModelAndView viewIndex(HttpServletRequest request){
        ModelAndView view = new ModelAndView("index");
        //index.ftl
        view.addAllObjects(Ftl.getIndexFtlMap());
        view.addObject("serverPath", Utils.getServerPath(request));

        //header.ftl
        view.addAllObjects(Ftl.getHeaderFtlMap());
        QueryBase queryBase = new QueryBase();

        try{
            articleService.getByPage(queryBase);
            view.addObject("queryBase", queryBase);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        //article-list.ftl
        view.addAllObjects(Ftl.getArticlelistFtlMap());

        //分页
        Long paginationPageCount = queryBase.getTotalPage();
        Long paginationCurrentPageNum = queryBase.getCurrentPage();
        LinkedList<Long> paginationPageNums = new LinkedList<Long>();
        for(Long i = 0l, j = paginationCurrentPageNum; j <= paginationPageCount && i< 6; i++, j++){
            paginationPageNums.add(j);
        }
        view.addObject("paginationPageCount", paginationPageCount);
        view.addObject("paginationPageNums", paginationPageNums);
        view.addObject("path", "page");
        view.addObject("paginationPreviousPageNum", paginationCurrentPageNum > 1 ? paginationCurrentPageNum - 1 : paginationCurrentPageNum);
        view.addObject("paginationCurrentPageNum", paginationCurrentPageNum);
        view.addObject("paginationNextPageNum", paginationCurrentPageNum <  paginationPageCount ? paginationCurrentPageNum + 1: paginationCurrentPageNum);


        //side.ftl
        view.addObject("userName", "vector");
        view.addAllObjects(Ftl.getSideFtlMap());

        Admin admin = new Admin();
        admin.setUserAvatar("/images/favicon.png");
        view.addObject("adminUser", admin);

        Statistic statistic = new Statistic(1, 1, 1);
        view.addObject("statistic", statistic);
        Link link = new Link("test", "test", "test");
        LinkedList<Link> links = new LinkedList<Link>();
        links.add(link);
        view.addObject("links", links);

        //footer.ftl
        view.addAllObjects(Ftl.getFooterFtlMap());
        view.addObject("onlineVisitorCnt", 5);
        view.addObject("footerContent", "footerContent");
        view.addObject("version", "1.0");
        return view;
    }

    @RequestMapping("/addComment")
    @ResponseBody
    public Object addComment(HttpServletRequest request, HttpSession session, @RequestParam("commentName") String commentName,
                             @RequestParam("commentEmail") String commentEmail, @RequestParam(value = "commentURL", required = false) String CommentURL,
                             @RequestParam("commentContent") String commentContent, @RequestParam("kaptcha") String kaptcha,
                             @RequestParam(value = "parentId", required = false) String parentId, @RequestParam("articleId") String articleId){
        Comment comment = new Comment();
        comment.setCommentAuthor(commentName);
        comment.setCommentEmail(commentEmail);
        comment.setCommentText(commentContent);
        comment.setArticleId(Integer.valueOf(articleId));
        if(parentId != null && parentId.length() > 0){
            comment.setParentId(Integer.valueOf(parentId));
        }
        User user = (User) session.getAttribute("user");
        if(user != null){
            comment.setCommentAuthor(user.getUserName());
            comment.setCommentEmail(user.getUserEmail());
        }
        int status = commentService.addComment(comment);
        return new Response(status);
    }
}
