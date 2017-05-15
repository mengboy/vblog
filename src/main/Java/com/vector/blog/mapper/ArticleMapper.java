package com.vector.blog.mapper;

import com.vector.blog.common.QueryBase;
import com.vector.blog.model.Article;
import com.vector.blog.model.Taxonomy;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    int selectLastArticleId();

    List<Article> selectArticleByPage(QueryBase queryBase);

    int getPageConut();

    int getDraftCount();

    int getDelCount();

    int getNormalCount();

    int upArticleDraft(int articleId);

    int upArticleTrash(int articleId);

    Article selectPreOneById(int artilceId);

    Article selectNextOneById(int artilceId);
}