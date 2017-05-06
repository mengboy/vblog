package com.vector.blog.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by vector on 2017/4/17.
 */
public class Utils {
    public static String getServerPath(HttpServletRequest request){
        StringBuffer Url = request.getRequestURL();
        String Uri = request.getRequestURI();
        return Url.substring(0, Url.indexOf(Uri));
    }
}
