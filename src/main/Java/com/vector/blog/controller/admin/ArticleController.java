package com.vector.blog.controller.admin;

import com.vector.blog.common.QueryBase;
import com.vector.blog.common.Response;
import com.vector.blog.common.Status;
import com.vector.blog.model.Article;
import com.vector.blog.model.ContentTax;
import com.vector.blog.model.Menu;
import com.vector.blog.model.Taxonomy;
import com.vector.blog.model.admin.Admin;
import com.vector.blog.model.admin.Module;
import com.vector.blog.model.admin.TaxonomyType;
import com.vector.blog.service.ArticleService;
import com.vector.blog.service.ContentTaxService;
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
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vector on 2017/4/22.
 */
@Controller
@RequestMapping("/admin")
public class ArticleController {

    @Resource
    ArticleService articleService;
    @Resource
    TaxonomyService taxonomyService;
    @Resource
    ContentTaxService contentTaxService;
    @Resource(name = "MenuService")
    MenuService menuService;


    /**
     * 添加文章
     * @param contentModule
     * @param contentStatus
     * @param title
     * @param text
     * @param flag
     * @param category
     * @param tag
     * @return
     */
    @RequestMapping("/article/save")
    @ResponseBody
    public Object adminSaveArctile(@RequestParam(value = "content.module", required = false) String contentModule, @RequestParam("content.status") String contentStatus,
                                   @RequestParam("content.title") String title, @RequestParam("content.text") String text, @RequestParam(value = "content.flag", required = false) String flag,
                                   @RequestParam(value = "_category", required = false) String category, @RequestParam(value = "_tag", required = false) String tag,
                                   @RequestParam(value = "content.comment_status", required = false) String articleCommentEnable,
                                   @RequestParam(value = "content.id", required = false) String contentId){

        int markdownEnable = 1;

        Article article = new Article();

        article.setArticleModule(contentModule);
        article.setArticleTitle(title);
        article.setArticleStatus(contentStatus);

        if(articleCommentEnable != null && articleCommentEnable.length() > 0){
            article.setArticleCommentEnable(articleCommentEnable);
        }

        String[] tags = null;
        if(tag != null && tag.trim().length() != 0){
            tags = tag.trim().split(",");
        }

        String[] categorys = null;
        if(category != null && category.trim().length() != 0){
            categorys = category.split(",");
        }


        //获取正文
        String tText = text;
        Pattern pText = Pattern.compile("<body>([\\s\\S]*?)</body>");
        Matcher mText = pText.matcher(tText);
        if(mText.find()){
            markdownEnable = 0;
            text = mText.group().replaceAll("body", "div");

            article.setArticleText(text);
        }

        //获取摘要
        Pattern pSummary = Pattern.compile("<p>(.*?)</p>");
        Matcher mSummary = pSummary.matcher(text);
        if(mSummary.find()){
            article.setArticleSummary(mSummary.group());
        }

        article.setArticleMarkdown(markdownEnable);

        article.setArticleCreated(new Date());
        System.out.println(article.getArticleCreated());

        int artilceId;

        try{
            //修改文章
            if(contentId != null && contentId.trim().length() > 0){
                article.setArticleId(Integer.valueOf(contentId));
                System.out.println(article.getArticleText());
                articleService.updateArticle(article);
                contentTaxService.delByarticleId(Integer.valueOf(contentId));
                artilceId = Integer.valueOf(contentId);
            }else {
                //添加新文章
                articleService.addArticle(article);
                artilceId = articleService.selectArticleId();
            }

            for(String acategoy : categorys){
                ContentTax contentTax = new ContentTax(artilceId, Integer.valueOf(acategoy));
                contentTaxService.insert(contentTax);
                System.out.println(acategoy);
            }
            for(String atag : tags){
                int tId;
                try{
                    tId = taxonomyService.selectTagIdByTitle(atag);
                    ContentTax contentTax = new ContentTax(artilceId, tId);
                    contentTaxService.insert(contentTax);
                    taxonomyService.upContentCount(tId);
                }catch (Exception e){
                    Taxonomy taxonomy = new Taxonomy(atag, "", "tag", "article");
                    taxonomyService.addTax(taxonomy);
                    tId = taxonomyService.selectTagIdByTitle(atag);
                    ContentTax contentTax = new ContentTax(artilceId, tId);
                    contentTaxService.insert(contentTax);
                    taxonomyService.upContentCount(tId);
                }
            }

        }catch (Exception e){
            return new Response(Status.ERROR);
        }

        return new Response(Status.SUCCESS, artilceId);
    }

    @RequestMapping(value = "/article/article_page")
    public @ResponseBody Object getAllEmployeeByDepart(@RequestParam long pageSize, @RequestParam long requestPage){
        QueryBase queryBase = new QueryBase();
        queryBase.setPageSize(pageSize);
        queryBase.setCurrentPage(requestPage);
        int status = this.articleService.getByPage(queryBase);
        System.out.println("status" + status);
        System.out.println(queryBase.getResults().size());
        return new Response(status, queryBase);
    }

    /**
     * 列出所有文章
     * @param request
     * @return
     */
    @RequestMapping(value = "/content/list_article")
    public ModelAndView adminAllArticle(HttpServletRequest request, @RequestParam("id") String id, @RequestParam long requestPage){
        ModelAndView view = new ModelAndView("content/index_content");
        view.addObject("CPATH", Utils.getServerPath(request));
        view.addObject("ucode", "29837148937489");
        Admin admin = new Admin("vector", "admin");
        view.addObject("USER", admin);

        List<Menu> menus;
        menus = menuService.getTopLevelMenu();
        menus = menuService.getSecondLevel(menus);
        view.addObject("menulists", menus);

        view.addObject("include", "_index_include.html");
        view.addObject("topLevelId", id);

        try{
            int count = articleService.getPageConut();
            view.addObject("count", count);
            int normal_count = articleService.getNormalCount();
            view.addObject("normal_count", normal_count);
            int draft_count = articleService.getDraftCount();
            view.addObject("draft_count", draft_count);
            int delete_count = articleService.getDelCount();
            view.addObject("delete_count", delete_count);

            //获取全部文章
            QueryBase queryBase = new QueryBase();
            queryBase.setCurrentPage(requestPage);
            this.articleService.getByPage(queryBase);
            view.addObject("queryBase", queryBase);

            //获取全部分类
            List<Taxonomy> categories = taxonomyService.getAllCategory();
            view.addObject("categories", categories);

            return view;
        }catch (Exception e){
            return null;
        }
    }


    /**
     * 撰写新文章
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/content/edit_article")
    public ModelAndView adminEditArticle(HttpServletResponse response, HttpServletRequest request, @RequestParam("id") String id,
                                         @RequestParam(value = "articleid", required = false) String articleid){
        ModelAndView view = new ModelAndView("content/edit_content");
        view.addObject("CPATH", Utils.getServerPath(request));

        List<Menu> menus;
        menus = menuService.getTopLevelMenu();
        menus = menuService.getSecondLevel(menus);
        view.addObject("menulists", menus);

        view.addObject("include", "_edit_include.html");
        Module module = new Module( "撰写文章");

        List<TaxonomyType> taxonomyTypes = new LinkedList<TaxonomyType>();
        TaxonomyType taxonomyCategory = new TaxonomyType("select", "分类");
        TaxonomyType taxonomyTag = new TaxonomyType("", "标签", "tag");
        taxonomyTypes.add(taxonomyCategory);
        taxonomyTypes.add(taxonomyTag);
        module.setTaxonomyTypes(taxonomyTypes);
        view.addObject("module", module);
        List<Taxonomy> taxonomies = taxonomyService.getAllCategory();
        view.addObject("taxonomies", taxonomies);

        if(articleid != null && articleid.length() > 0){
            Article article = articleService.selectByPrimaryKey(Integer.valueOf(articleid));
            article.setArticleTags(taxonomyService.getTagsByArticleId(Integer.valueOf(articleid)));
            article.setCategories(taxonomyService.getCategoriesByArticleId(Integer.valueOf(articleid)));
            view.addObject("article", article);
        }



        view.addObject("topLevelId", id);
        view.addObject("edit", true);
        view.addObject("editor", "tinymce");
        view.addObject("changeEditor", "markdown");
        return view;
    }

    /**
     * 改变编辑器
     * @param response
     * @param request
     * @param id
     * @param editor
     * @param changeEditor
     * @return
     */
    @RequestMapping(value = "/content/changeEditor")
    public ModelAndView adminEditArticleMarkdon(HttpServletResponse response, HttpServletRequest request, @RequestParam("id") String id, @RequestParam(value = "editor") String editor, @RequestParam(value = "changeEditor") String changeEditor){
        ModelAndView view = new ModelAndView("content/edit_content");

        view.addObject("CPATH", Utils.getServerPath(request));
        view.addObject("ucode", "29837148937489");
        Admin admin = new Admin("vector", "admin");
        view.addObject("USER", admin);

        List<Menu> menus;
        menus = menuService.getTopLevelMenu();
        menus = menuService.getSecondLevel(menus);
        view.addObject("menulists", menus);


        List<Taxonomy> taxonomies = taxonomyService.getAllCategory();
        view.addObject("taxonomies", taxonomies);

        view.addObject("include", "_edit_include.html");
        Module module = new Module( "撰写文章");
        List<TaxonomyType> taxonomyTypes = new LinkedList<TaxonomyType>();
        TaxonomyType taxonomyCategory = new TaxonomyType("select", "分类");
        TaxonomyType taxonomyTag = new TaxonomyType("", "标签", "tag");
        taxonomyTypes.add(taxonomyCategory);
        taxonomyTypes.add(taxonomyTag);
        module.setTaxonomyTypes(taxonomyTypes);
        view.addObject("module", module);
        view.addObject("urlSuffix", "标题");

        view.addObject("topLevelId", id);
        view.addObject("edit", true);
        view.addObject("editor", changeEditor);
        view.addObject("changeEditor", editor);
        return view;
    }

    /**
     * 垃圾箱
     * @param request
     * @param articleId
     * @return
     */
    @RequestMapping("/content/trash")
    @ResponseBody
    public Object adminUpArticleTrash(HttpServletRequest request, @RequestParam("articleId") String articleId){
        try{
            articleService.upArticleTrash(Integer.valueOf(articleId));
            return new Response(Status.SUCCESS);
        }catch (Exception e){
            return new Response(Status.ERROR);
        }
    }


    /**
     * 草稿箱
     * @param request
     * @param articleId
     * @return
     */
    @RequestMapping("/content/draft")
    @ResponseBody
    public Object adminUpArticleDraft(HttpServletRequest request, @RequestParam("articleId") String articleId){
        try{
            articleService.upArticleDraft(Integer.valueOf(articleId));
            return new Response(Status.SUCCESS);
        }catch (Exception e){
            return new Response(Status.ERROR);
        }
    }

    /**
     * 删除文章
     * @param request
     * @param articleId
     * @return
     */
    @RequestMapping("/content/del")
    @ResponseBody
    public Object adminArticleDel(HttpServletRequest request, @RequestParam("articleId") String articleId){
        try{
            articleService.delArticle(Integer.valueOf(articleId));
            return new Response(Status.SUCCESS);
        }catch (Exception e){
            return new Response(Status.ERROR);
        }
    }



}



