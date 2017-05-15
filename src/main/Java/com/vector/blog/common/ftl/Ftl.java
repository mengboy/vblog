package com.vector.blog.common.ftl;

import com.vector.blog.utils.Utils;

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
        //添加页面
//        HashMap<String, Object> page = new HashMap<String, Object>();
//        page.put("pagePermalink", "http:127.0.0.1");
//        page.put("pageOpenTarget", "");
//        page.put("pageTitle", "test");
//        LinkedList<HashMap> pageNavigations = new LinkedList<HashMap>();
//        pageNavigations.add(page);
//        view.addObject("pageNavigations", pageNavigations);
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




        public static Map getCommentFtlMap(){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("commentNameLabel", "姓名");
            map.put("commentEmailLabel", "邮箱");
            map.put("commentURLLabel", "URL");
            map.put("em00Label", "微笑");
            map.put("em01Label", "大笑");
            map.put("em02Label", "高兴");
            map.put("em03Label", "悲伤");
            map.put("em04Label", "哭泣");
            map.put("em05Label", "无语");
            map.put("em06Label", "烦躁");
            map.put("em07Label", "生气");
            map.put("em08Label", "我瞅");
            map.put("em09Label", "惊讶");
            map.put("em10Label", "酷");
            map.put("em11Label", "顽皮");
            map.put("em12Label", "爱心");
            map.put("em13Label", "心碎");
            map.put("em14Label", "魔鬼");
            map.put("captchaLabel", "验证码");
            map.put("submmitCommentLabel", "提交评论");
            map.put("nameTooLongLabel", "姓名只能为 2 到 20 个字符");
            map.put("mailCannotEmptyLabel", "邮箱不能为空");
            map.put("mailInvalidLabel", "邮箱格式不正确");
            map.put("commentContentCannotEmptyLabel", "评论内容只能为2到500个字符");
            map.put("captchaCannotEmptyLabel", "验证码不能为空");
            map.put("loadingLabel", "载入中....");
            map.put("replyLabel", "回复");
            return map;
        }


        public static Map getFooterFtlMap(){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("em00Label", "微笑");
            map.put("em01Label", "大笑");
            map.put("em02Label", "高兴");
            map.put("em03Label", "悲伤");
            map.put("em04Label", "哭泣");
            map.put("em05Label", "无语");
            map.put("em06Label", "烦躁");
            map.put("em07Label", "生气");
            map.put("em08Label", "我瞅");
            map.put("em09Label", "惊讶");
            map.put("em10Label", "酷");
            map.put("em11Label", "顽皮");
            map.put("em12Label", "爱心");
            map.put("em13Label", "心碎");
            map.put("em14Label", "魔鬼");
            map.put("onlineVisitor1Label", "在线人数");
            return map;

        }

}
