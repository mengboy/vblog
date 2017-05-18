package com.vector.blog.service;

import com.vector.blog.model.Taxonomy;

import java.util.List;

/**
 * Created by vector on 2017/4/22.
 */
public interface TaxonomyService {
    public int addTax(Taxonomy taxonomy);

    public List<Taxonomy> getAllTag();

    public List<Taxonomy> getAllCategory();

    public int delById(int taxId);

    public int selectTaxId();

    public int selectTagIdByTitle(String tagTitle);

    public int upContentCount(int taxId);

    public List<Taxonomy> getTagsByArticleId(int articleId);

    public List<Taxonomy> getCategoriesByArticleId(int articleId);
}
