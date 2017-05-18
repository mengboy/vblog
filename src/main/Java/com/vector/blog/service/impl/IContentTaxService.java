package com.vector.blog.service.impl;

import com.vector.blog.common.Status;
import com.vector.blog.mapper.ContentTaxMapper;
import com.vector.blog.model.ContentTax;
import com.vector.blog.service.ContentTaxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by vector on 2017/4/25.
 */
@Service("ContentTaxService")
public class IContentTaxService implements ContentTaxService {

    @Resource
    ContentTaxMapper contentTaxMapper;

    public int insert(ContentTax contentTax) {
        return contentTaxMapper.insert(contentTax);
    }

    public int delByarticleId(int articleId) {
        try {
            contentTaxMapper.delByarticleId(articleId);
            return Status.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Status.ERROR;
        }
    }
}
