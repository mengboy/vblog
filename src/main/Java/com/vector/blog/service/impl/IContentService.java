package com.vector.blog.service.impl;

import com.vector.blog.mapper.ContentTaxMapper;
import com.vector.blog.model.ContentTax;
import com.vector.blog.service.ContentTaxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by vector on 2017/4/25.
 */
@Service("ContentTaxService")
public class IContentService implements ContentTaxService {

    @Resource
    ContentTaxMapper contentTaxMapper;

    public int insert(ContentTax contentTax) {
        return contentTaxMapper.insert(contentTax);
    }
}
