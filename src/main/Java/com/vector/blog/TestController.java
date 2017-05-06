package com.vector.blog;

import com.vector.blog.model.admin.Admin;
import com.vector.blog.model.Article;
import com.vector.blog.model.Link;
import com.vector.blog.model.Statistic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by vector on 2017/4/16.
 */
@Controller
public class TestController {

    @RequestMapping(value = "/test")
    public ModelAndView testView(HttpServletRequest request, HttpServletResponse response){
        ModelAndView view = new ModelAndView("index");
        //index.ftl
        view.addObject("blogTitle", "vblog");
        //macro-head.ftl
        view.addObject("year", "2017");
        view.addObject("staticServePath", "");
        view.addObject("skinDirName", "next");
        view.addObject("miniPostfix", "");
        view.addObject("staticResourceVersion", "");
        view.addObject("servePath", "");
        //header.ftl
        view.addObject("dynamicLabel", "动态");
        view.addObject("allTagsLabel", "标签");
        view.addObject("archiveLabel", "存档");
        view.addObject("searchLabel", "搜索");
        view.addObject("serverHost", "localhost");
        HashMap<String, Object> page = new HashMap<String, Object>();
        page.put("pagePermalink", "http:127.0.0.1");
        page.put("pageOpenTarget", "");
        page.put("pageTitle", "test");
        LinkedList<HashMap> pageNavigations = new LinkedList<HashMap>();
        pageNavigations.add(page);
//        view.addObject("pageNavigations", pageNavigations);

        //article-list.ftl
        view.addObject("postTimeLabel", "发表于");
        view.addObject("cmtLabel", "条评论");
        view.addObject("readLabel", "继续阅读");
        view.addObject("paginationPageCount", 7);
        int[] paginationPageNums = {1, 2, 3, 4, 5, 6, 7};
        view.addObject("paginationPageNums", paginationPageNums);
        view.addObject("path", "page");
        view.addObject("paginationPreviousPageNum", 1);
        view.addObject("paginationCurrentPageNum", 2);
        view.addObject("paginationNextPageNum", 3);

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
        view.addObject("onlineVisitor1Label", "在线人数");
        view.addObject("onlineVisitorCnt", 5);
        view.addObject("footerContent", "footerContent");
        view.addObject("version", "1.0");
        return view;
    }
}
