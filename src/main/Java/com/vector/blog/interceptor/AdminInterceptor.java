package com.vector.blog.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by vector on 2017/5/17.
 */
public class AdminInterceptor implements HandlerInterceptor{

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if(httpServletRequest.getServletPath().startsWith("/admin/login_page") || httpServletRequest.getServletPath().startsWith("/admin/userLogin")){
            return true;
        }

        if(httpServletRequest.getSession().getAttribute("user") != null){
            return true;
        }
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/admin/login_page");
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
