package com.vector.blog;

import com.vector.blog.common.QueryBase;
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
        view.addObject("blogTitle", "vblog");
        //macro-head.ftl
//        view.addObject("year", "2017");
//        view.addObject("staticServePath", "");
        view.addObject("skinDirName", "next");
//        view.addObject("miniPostfix", "");
//        view.addObject("staticResourceVersion", "");
        view.addObject("serverPath", Utils.getServerPath(request));


        //header.ftl

        //搜索
        view.addObject("searchLabel", "搜索");
        view.addObject("serverHost", "localhost");

        //页面
        view.addObject("dynamicLabel", "动态");
        view.addObject("allTagsLabel", "标签");
        view.addObject("archiveLabel", "存档");

        //添加页面
//        HashMap<String, Object> page = new HashMap<String, Object>();
//        page.put("pagePermalink", "http:127.0.0.1");
//        page.put("pageOpenTarget", "");
//        page.put("pageTitle", "test");
//        LinkedList<HashMap> pageNavigations = new LinkedList<HashMap>();
//        pageNavigations.add(page);
//        view.addObject("pageNavigations", pageNavigations);


        QueryBase queryBase = new QueryBase();
        try{
             articleService.getByPage(queryBase);
//             System.out.println(queryBase.getResults().size());
             view.addObject("queryBase", queryBase);
        }catch (Exception e){
            return null;
        }

        //article-list.ftl
        view.addObject("postTimeLabel", "发表于");
        view.addObject("cmtLabel", "条评论");
        view.addObject("readLabel", "继续阅读");

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
        view.addObject("em00Label", "微笑");
        view.addObject("em01Label", "大笑");
        view.addObject("em02Label", "高兴");
        view.addObject("em03Label", "悲伤");
        view.addObject("em04Label", "哭泣");
        view.addObject("em05Label", "无语");
        view.addObject("em06Label", "烦躁");
        view.addObject("em07Label", "生气");
        view.addObject("em08Label", "我瞅");
        view.addObject("em09Label", "惊讶");
        view.addObject("em10Label", "酷");
        view.addObject("em11Label", "顽皮");
        view.addObject("em12Label", "爱心");
        view.addObject("em13Label", "心碎");
        view.addObject("em14Label", "魔鬼");




        view.addObject("onlineVisitor1Label", "在线人数");
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
        view.addObject("article", article);

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
        view.addObject("commentNameLabel", "姓名");
        view.addObject("commentEmailLabel", "邮箱");
        view.addObject("commentURLLabel", "URL");
        view.addObject("em00Label", "微笑");
        view.addObject("em01Label", "大笑");
        view.addObject("em02Label", "高兴");
        view.addObject("em03Label", "悲伤");
        view.addObject("em04Label", "哭泣");
        view.addObject("em05Label", "无语");
        view.addObject("em06Label", "烦躁");
        view.addObject("em07Label", "生气");
        view.addObject("em08Label", "我瞅");
        view.addObject("em09Label", "惊讶");
        view.addObject("em10Label", "酷");
        view.addObject("em11Label", "顽皮");
        view.addObject("em12Label", "爱心");
        view.addObject("em13Label", "心碎");
        view.addObject("em14Label", "魔鬼");
        view.addObject("captchaLabel", "验证码");
        view.addObject("submmitCommentLabel", "提交评论");
        view.addObject("nameTooLongLabel", "姓名只能为 2 到 20 个字符");
        view.addObject("mailCannotEmptyLabel", "邮箱不能为空");
        view.addObject("mailInvalidLabel", "邮箱格式不正确");
        view.addObject("commentContentCannotEmptyLabel", "评论内容只能为2到500个字符");
        view.addObject("captchaCannotEmptyLabel", "验证码不能为空");
        view.addObject("loadingLabel", "载入中....");
        view.addObject("blogHost", Utils.getServerPath(request));
        view.addObject("replyLabel", "回复");
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
