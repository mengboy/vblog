package com.vector.blog.common.ftl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vector on 2017/5/13.
 */
public class Ftl {
    public static Map getIndexFtlMap(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("blogTitle", "vblog");
        map.put("skinDirName", "next");
        return map;
    }

    public static Map getHeaderFtlMap(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("searchLabel", "搜索");
        map.put("serverHost", "localhost");
        map.put("dynamicLabel", "动态");
        map.put("allTagsLabel", "标签");
        map.put("archiveLabel", "存档");
        return map;
    }

    public static Map getArticlelistFtlMap(){
        Map<String, Object> map = new HashMap<String, Object>();
        //article-list.ftl
        map.put("postTimeLabel", "发表于");
        map.put("cmtLabel", "继续阅读");
        map.put("postTimeLabel", "发表于");
        map.put("viewsLabel", "热度");
        map.put("readLabel", "继续阅读");
//        view.addObject("topArticleLabel", "test");
//        view.addObject("updatedLabel", "test");
        return map;
    }

    public static Map getSideFtlMap(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("noticeBoard", "noticeBoard");
        map.put("blogSubtitle", "Java开源博客");
        map.put("articleLabel", "文章");
        map.put("viewLabel", "浏览");
        map.put("commentLabel", "评论");
        map.put("adminLabel", "adminLabel");
        map.put("logoutLabel", "退出");
        map.put("loginLabel", "登录");
        map.put("registerLabel", "注册");
        return map;
    }


}
