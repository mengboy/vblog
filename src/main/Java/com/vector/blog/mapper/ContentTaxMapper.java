package com.vector.blog.mapper;

import com.vector.blog.model.ContentTax;

public interface ContentTaxMapper {
    int insert(ContentTax record);

    int insertSelective(ContentTax record);

    int delByarticleId(int articleId);
}