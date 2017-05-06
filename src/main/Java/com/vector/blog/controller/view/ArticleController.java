package com.vector.blog.controller.view;

import com.vector.blog.service.ArticleService;
import com.vector.blog.utils.Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by vector on 2017/4/30.
 */
@RequestMapping("/view")
public class ArticleController {

    @Resource
    ArticleService articleService;

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
}
