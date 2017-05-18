package com.vector.blog.service.impl;

import com.vector.blog.common.Status;
import com.vector.blog.mapper.TaxonomyMapper;
import com.vector.blog.model.Taxonomy;
import com.vector.blog.service.TaxonomyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by vector on 2017/4/22.
 */
@Service(value = "TaxonomyService")
public class ITaxonomyService implements TaxonomyService {
    @Resource
    TaxonomyMapper taxonomyMapper;
    public int addTax(Taxonomy taxonomy) {
        return taxonomyMapper.insertSelective(taxonomy);
    }

    public List<Taxonomy> getAllTag() {
        return taxonomyMapper.getAllTag();
    }

    public List<Taxonomy> getAllCategory() {
        return taxonomyMapper.getAllCategory();
    }

    public int delById(int taxId) {
        return taxonomyMapper.deleteByPrimaryKey(taxId);
    }

    public int selectTaxId() {
        return taxonomyMapper.selectLastTaxId();
    }

    public int selectTagIdByTitle(String tagTitle) {
        return taxonomyMapper.selectTagIdByTitle(tagTitle);
    }

    public int upContentCount(int taxId) {
        try{
            taxonomyMapper.upContentCount(taxId);
            return Status.SUCCESS;
        }catch (Exception e){
            return Status.ERROR;
        }
    }

    public List<Taxonomy> getTagsByArticleId(int articleId) {
        try{
            List<Taxonomy> taxonomies = taxonomyMapper.getTagsByArticleId(articleId);
            return taxonomies;
        }catch (Exception e){
            return null;
        }
    }

    public List<Taxonomy> getCategoriesByArticleId(int articleId) {
        try{
            List<Taxonomy> taxonomies = taxonomyMapper.getCategoriesByArticleId(articleId);
            return taxonomies;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
