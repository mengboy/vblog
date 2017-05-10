package com.vector.blog.controller.view;

import com.vector.blog.common.Response;
import com.vector.blog.model.Comment;
import com.vector.blog.model.User;
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

        view.addObject("blogTitle", "vblog");

        view.addObject("title", "首页");
        view.addObject("servePath", Utils.getServerPath(request));

        view.addObject("dynamicLabel", "动态");
        view.addObject("allTagsLabel", "标签");
        view.addObject("archiveLabel", "存档");
        view.addObject("searchLabel", "搜索");

        view.addObject("dynamicLabel", "动态");
        view.addObject("allTagsLabel", "标签");
        view.addObject("archiveLabel", "存档");
        view.addObject("searchLabel", "搜索");
        view.addObject("serverHost", "localhost");

        view.addObject("postTimeLabel", "发表于");
        view.addObject("cmtLabel", "条评论");
        view.addObject("readLabel", "继续阅读");


        return null;
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
