package com.vector.blog.service;

import com.vector.blog.model.ContentTax;

/**
 * Created by vector on 2017/4/25.
 */
public interface ContentTaxService {
    public int insert(ContentTax contentTax);

    public int delByarticleId(int articleId);
}
