package com.vector.blog.controller.admin;

import com.vector.blog.common.Response;
import com.vector.blog.common.Status;
import com.vector.blog.model.Content;
import com.vector.blog.model.Menu;
import com.vector.blog.model.Taxonomy;
import com.vector.blog.model.admin.Admin;
import com.vector.blog.model.admin.Module;
import com.vector.blog.model.admin.Type;
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
 * Created by vector on 2017/4/21.
 */
@Controller
@RequestMapping("/admin")
public class TaxonomyController {

    @Resource
    MenuService menuService;

    @Resource
    TaxonomyService taxonomyService;






    @RequestMapping("/taxonomy/category")
    public ModelAndView adminCategory(HttpServletResponse response, HttpServletRequest request, @RequestParam("id") String id){
        ModelAndView view = new ModelAndView("taxonomy/index_tax");

        view.addObject("CPATH", Utils.getServerPath(request));
        view.addObject("ucode", "29837148937489");

        Admin admin = new Admin("vector", "admin");
        view.addObject("USER", admin);

        //菜单
        List<Menu> menus;
        menus = menuService.getTopLevelMenu();
        menus = menuService.getSecondLevel(menus);
        view.addObject("menulists", menus);

        //分类
        List<Taxonomy> taxonomies = new LinkedList<Taxonomy>();
        taxonomies = taxonomyService.getAllCategory();
        System.out.println(taxonomies.size());
        view.addObject("taxonomys", taxonomies);

        //页面
        view.addObject("include", "_index_include.html");

        Module module = new Module( "撰写文章");
        module.setName("article");
        view.addObject("module", module);
        view.addObject("urlSuffix", "标题");
        Content content = new Content("http:localhost:8080/c/", "", "title");
        view.addObject("content", content);
        view.addObject("slugDisplay", true);
        view.addObject("topLevelId", id);

        Type type = new Type("分类", "分类", "select");
        view.addObject("type", type);
        Taxonomy taxonomy = new Taxonomy();
        taxonomy.setTaxType("category");
        view.addObject("taxonomy", taxonomy);
        return view;
    }


    @RequestMapping("/taxonomy/tag")
    public ModelAndView adminTag(HttpServletResponse response, HttpServletRequest request, @RequestParam("id") String id){
        ModelAndView view = new ModelAndView("taxonomy/index_tax");

        view.addObject("CPATH", Utils.getServerPath(request));
        view.addObject("ucode", "29837148937489");
        Admin admin = new Admin("vector", "admin");
        view.addObject("USER", admin);

        List<Menu> menus;
        menus = menuService.getTopLevelMenu();
        menus = menuService.getSecondLevel(menus);
        view.addObject("menulists", menus);


        List<Taxonomy> taxonomies = new LinkedList<Taxonomy>();
        taxonomies = taxonomyService.getAllTag();
        System.out.println(taxonomies.size());
        view.addObject("taxonomys", taxonomies);

        view.addObject("include", "_index_include.html");
        Module module = new Module( "撰写文章");
        module.setName("article");
        view.addObject("module", module);
        view.addObject("urlSuffix", "标题");
        Content content = new Content("http:localhost:8080/c/", "", "title");
        view.addObject("content", content);
        view.addObject("slugDisplay", true);
        view.addObject("topLevelId", id);
        Type type = new Type("标签", "标签", "");
        view.addObject("type", type);
        view.addObject("taxType", "tag");
        Taxonomy taxonomy = new Taxonomy();
        taxonomy.setTaxType("tag");
        view.addObject("taxonomy", taxonomy);
        return view;
    }

    /**
     * 添加新分类或者标签
     * @param id
     * @param c
     * @param taxonomyType
     * @param taxonomyTitle
     * @param taxonomySlug
     * @param taxonomyParent_id
     * @param taxonomyText
     * @return
     */
    @RequestMapping("/taxonomy/save")
    @ResponseBody
    public Object adminTaxonomySave(@RequestParam("id") String id, @RequestParam("c") String c, @RequestParam("taxonomyType") String taxonomyType,
                                    @RequestParam("taxonomyTitle") String taxonomyTitle, @RequestParam("taxonomySlug") String taxonomySlug,
                                    @RequestParam(value = "taxonomyParent_id", required = false) String taxonomyParent_id,
                                    @RequestParam(value = "taxonomyText", required = false) String taxonomyText){

        try{
            if(taxonomyParent_id != null && taxonomyText != null){
                Taxonomy taxonomy = new Taxonomy(taxonomyTitle, taxonomyText, taxonomySlug, c, id, Integer.valueOf(taxonomyParent_id));
                taxonomyService.addTax(taxonomy);

            }else if (taxonomyParent_id == null && taxonomyText != null){

                Taxonomy taxonomy = new Taxonomy(taxonomyTitle, taxonomyText, taxonomySlug, c, id);
                taxonomyService.addTax(taxonomy);

            }else {

                Taxonomy taxonomy = new Taxonomy(taxonomyTitle, taxonomySlug, c, id);
                taxonomyService.addTax(taxonomy);

            }
        }catch (Exception e){
            return new Response(Status.ERROR);
        }

        return new Response(Status.SUCCESS);
    }

    @RequestMapping("/taxonomy/delete")
    @ResponseBody
    public Object adminDelTax(@RequestParam("id") String id){

        System.out.println(id);

        try{
            taxonomyService.delById(Integer.parseInt(id));
        }catch (Exception e){
            return new Response(Status.ERROR);
        }

        return new Response(Status.SUCCESS);
    }


}
