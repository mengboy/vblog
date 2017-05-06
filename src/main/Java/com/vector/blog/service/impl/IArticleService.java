package com.vector.blog.service.impl;

import com.vector.blog.common.QueryBase;
import com.vector.blog.common.Status;
import com.vector.blog.mapper.ArticleMapper;
import com.vector.blog.mapper.TaxonomyMapper;
import com.vector.blog.model.Article;
import com.vector.blog.model.Content;
import com.vector.blog.model.Taxonomy;
import com.vector.blog.service.ArticleService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vector on 2017/4/23.
 */
@Service("ArticleService")
public class IArticleService implements ArticleService{

    @Resource
    ArticleMapper articleMapper;

    @Resource
    TaxonomyMapper taxonomyMapper;


    public int addArticle(Article article) {
        return articleMapper.insertSelective(article);
    }

    public int delArticle(int articleId) {
        return 0;
    }

    public int updateArticle(Article article) {
        return 0;
    }



    public int upArticleStatus(String status) {
        return 0;
    }

    public List<Article> getAll() {
        return null;
    }

    /**
     * 分页查询
     * @param queryBase
     * @return
     */
    public int getByPage(QueryBase queryBase) {
        try{
            queryBase.setTotalRow((long) this.articleMapper.getPageConut());
            Map<String, Object> map = null;
            List<Map<String, Object>> mapLists = new ArrayList<Map<String, Object>>();

            for(Article article : this.articleMapper.selectArticleByPage(queryBase))
            {
                map = new HashMap<String, Object>();
                List<Taxonomy> tags = taxonomyMapper.getTagsByArticleId(article.getArticleId());
                List<Taxonomy> categories = taxonomyMapper.getCategoriesByArticleId(article.getArticleId());
                article.setTags(tags);
                article.setCategories(categories);
                map.put("article", article);
                mapLists.add(map);
            }
            queryBase.setResults(mapLists);
            return Status.SUCCESS;

        }catch (Exception e){
            e.printStackTrace();
            return Status.ERROR;
        }
    }

    /**
     * 查询最新插入文章id
     * @return
     */
    public int selectArticleId() {
        return articleMapper.selectLastArticleId();
    }

    /**
     * 草稿数量
     * @return
     */
    public int getDraftCount() {
        return articleMapper.getDraftCount();
    }

    /**
     * 已删除文章数量
     * @return
     */
    public int getDelCount() {
        return articleMapper.getDelCount();
    }

    /**
     * 已发布文章数量
     * @return
     */
    public int getNormalCount() {
        return articleMapper.getNormalCount();
    }

    /**
     * 分页查询获取文章数量
     * @return
     */
    public int getPageConut() {
        return articleMapper.getPageConut();
    }

    public int upArticleDraft(int articleId) {
        try{
            articleMapper.upArticleDraft(articleId);
            return Status.SUCCESS;
        }catch (Exception e){
            return Status.ERROR;
        }
    }

    public int upArticleTrash(int articleId) {
        try{
            articleMapper.upArticleTrash(articleId);
            return Status.SUCCESS;
        }catch (Exception e){
            return Status.ERROR;
        }
    }

    public Article selectByPrimaryKey(Integer articleId) {
        return articleMapper.selectByPrimaryKey(articleId);
    }

}
