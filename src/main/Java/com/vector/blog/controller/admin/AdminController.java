package com.vector.blog.controller.admin;

import com.vector.blog.model.*;
import com.vector.blog.model.Taxonomy;
import com.vector.blog.model.admin.*;
import com.vector.blog.service.MenuService;
import com.vector.blog.service.TaxonomyService;
import com.vector.blog.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vector on 2017/4/17.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Resource(name = "MenuService")
    MenuService menuService;

    @Resource
    TaxonomyService taxonomyService;

    //private static List<Menu> menus;


    /**
     * 登录界面
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/login")
    public ModelAndView adminLogin(HttpServletResponse response, HttpServletRequest request){
        ModelAndView view = new ModelAndView();
        view.addObject("CPATH", Utils.getServerPath(request));
        view.setViewName("login");
        return view;
    }


    @RequestMapping(value = "/index")
    public ModelAndView adminIndex(HttpServletRequest request, HttpServletResponse response){
        ModelAndView view = new ModelAndView("admin-index");

        view.addObject("CPATH", Utils.getServerPath(request));
        view.addObject("ucode", "29837148937489");
        Admin admin = new Admin("vector", "admin");
        view.addObject("USER", admin);
        List<Menu> menus;
        menus = menuService.getTopLevelMenu();
        menus = menuService.getSecondLevel(menus);
        view.addObject("menulists", menus);
//        view.addObject("include", "manage-index.ftl");
        return view;
    }







    @RequestMapping("/comment")
    public ModelAndView adminComment(HttpServletResponse response, HttpServletRequest request, @RequestParam("id") String id){
        ModelAndView view = new ModelAndView("comment/index_comment");

        view.addObject("CPATH", Utils.getServerPath(request));
        view.addObject("ucode", "29837148937489");
        Admin admin = new Admin("vector", "admin");
        view.addObject("USER", admin);

        List<Menu> menus;
        menus = menuService.getTopLevelMenu();
        menus = menuService.getSecondLevel(menus);
        view.addObject("menulists", menus);

//        view.addObject("include", "comment/index.html");
        Module module = new Module( "撰写文章");
        module.setName("article");
        view.addObject("module", module);
        view.addObject("urlSuffix", "标题");
        Content content = new Content("http:localhost:8080/c/", "", "title");
        view.addObject("content", content);
        view.addObject("slugDisplay", true);
        view.addObject("topLevelId", id);
        return view;
    }
}
