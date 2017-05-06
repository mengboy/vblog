package com.vector.blog.service;

import com.vector.blog.common.QueryBase;
import com.vector.blog.model.Article;
import com.vector.blog.model.Content;
import com.vector.blog.model.Taxonomy;

import java.util.List;

/**
 * Created by vector on 2017/4/23.
 */
public interface ArticleService {

    public int addArticle(Article article);

    public int delArticle(int articleId);

    public int updateArticle(Article article);

    public int upArticleStatus(String status);

    public List<Article> getAll();

    public int getByPage(QueryBase queryBase);

    public int selectArticleId();

    public int getDraftCount();

    public int getDelCount();

    public int getNormalCount();

    public int getPageConut();

    public int upArticleDraft(int articleId);

    public int upArticleTrash(int articleId);

}
