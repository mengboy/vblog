package com.vector.blog.mapper;

import com.vector.blog.model.Taxonomy;

import java.util.List;

public interface TaxonomyMapper {
    int deleteByPrimaryKey(Integer taxId);

    int insert(Taxonomy record);

    int insertSelective(Taxonomy record);

    Taxonomy selectByPrimaryKey(Integer taxId);

    int updateByPrimaryKeySelective(Taxonomy record);

    int updateByPrimaryKey(Taxonomy record);

    List<Taxonomy> getAllTag();

    List<Taxonomy> getAllCategory();

    int selectLastTaxId();

    int selectTagIdByTitle(String tagTitle);

    List<Taxonomy> getTagsByArticleId(int articleId);

    List<Taxonomy> getCategoriesByArticleId(int articleId);

    int upContentCount(int taxId);
}