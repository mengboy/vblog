package com.vector.blog;

import com.vector.blog.common.QueryBase;
import com.vector.blog.common.ftl.Ftl;
import com.vector.blog.model.*;
import com.vector.blog.model.admin.Admin;
import com.vector.blog.service.ArticleService;
import com.vector.blog.service.CommentService;
import com.vector.blog.service.TaxonomyService;
import com.vector.blog.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vector on 2017/4/16.
 */
@Controller
public class TestController {

    @Resource
    ArticleService articleService;

    @Resource
    CommentService commentService;

    @Resource
    TaxonomyService taxonomyService;

    @RequestMapping(value = "/test")
    public ModelAndView testView(HttpServletRequest request, HttpServletResponse response){
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


        view.addObject("topArticleLabel", "test");
        view.addObject("updatedLabel", "test");



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



    @RequestMapping(value = "/article/show")
    public ModelAndView articleShow(HttpServletRequest request, HttpServletResponse response, @RequestParam("articleId") String articleId){
        ModelAndView view = new ModelAndView("article");
        //index.ftl
        view.addObject("blogTitle", "vblog");

        //macro-head.ftl
        view.addObject("skinDirName", "next");
        view.addObject("servePath", Utils.getServerPath(request));
        //header.ftl
        view.addObject("dynamicLabel", "动态");
        view.addObject("allTagsLabel", "标签");
        view.addObject("archiveLabel", "存档");
        view.addObject("searchLabel", "搜索");
        view.addObject("serverHost", "localhost");


        //article.ftl
        view.addObject("postTimeLabel", "发表于");
        view.addObject("cmtLabel", "条评论");
        view.addObject("readLabel", "继续阅读");
        view.addObject("serverPath", Utils.getServerPath(request));
        Article article = articleService.selectByPrimaryKey(Integer.valueOf(articleId));
        List<Taxonomy> taxonomies = taxonomyService.getTagsByArticleId(Integer.valueOf(articleId));
        article.setArticleTags(taxonomies);


        //comment.ftl
        List<Comment> comments = commentService.getCommentByArticleId(Integer.valueOf(articleId));
        for(Comment comment : comments){
            if(comment.getParentId() != null && comment.getParentId() > 0){
                System.out.println(commentService.getCommentByParentId(comment.getParentId()));
                comment.setParentComment(commentService.getCommentByParentId(comment.getParentId()));
                System.out.println(comment.getParentComment().getCommentId());
            }
        }
        view.addObject("articleComments", comments);
        article.setCommentCount(comments.size());

        view.addObject("article", article);

        Article preArticle = articleService.selectPreOneById(Integer.valueOf(articleId));
        Article nextArticle = articleService.selectNextOneById(Integer.valueOf(articleId));

//        System.out.print("id" + nextArticle.getArticleId());

        if(preArticle != null){
            view.addObject("previousArticleId", preArticle.getArticleId());
            view.addObject("previousArticleTitle", preArticle.getArticleTitle());
        }

        if(nextArticle != null){
            view.addObject("nextArticlePermaId", nextArticle.getArticleId());
            view.addObject("nextArticleTitle", nextArticle.getArticleTitle());
        }


        view.addAllObjects(Ftl.getCommentFtlMap());
        view.addObject("blogHost", Utils.getServerPath(request));

//        view.addObject("plugins", "'../../plugins/fancybox/plugin.ftl' ");



//        Article article = new Article("test", "test", false, false, new Date(), 3, 2, "测试");

        LinkedList<Article> articles = new LinkedList<Article>();
//        articles.add(article);

        view.addObject("topArticleLabel", "test");
        view.addObject("updatedLabel", "test");
        view.addObject("articles", articles);
        view.addObject("viewsLabel", "热度");

        //side.ftl
        view.addObject("userName", "vector");
        view.addObject("noticeBoard", "noticeBoard");
        view.addObject("blogSubtitle", "Java开源博客");
        view.addObject("articleLabel", "文章");
        view.addObject("viewLabel", "浏览");
        view.addObject("commentLabel", "评论");
        view.addObject("isLoggedIn", false);
        view.addObject("adminLabel", "adminLabel");
        view.addObject("logoutLabel", "退出");
        view.addObject("logoutURL", "http:127.0.0.1");
        view.addObject("loginURL", "http:127.0.0.1");
        view.addObject("loginLabel", "登录");
        view.addObject("registerLabel", "registerLabel");
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
        view.addObject("plugins", "true");
        view.addObject("onlineVisitor1Label", "在线人数");
        view.addObject("onlineVisitorCnt", 5);
        view.addObject("footerContent", "footerContent");
        view.addObject("version", "1.0");
        return view;
    }
}
