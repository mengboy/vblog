package com.vector.blog.model;

public class ContentTax {
    private Integer id;

    private Integer articleId;

    private Integer taxId;


    public ContentTax() {
    }

    public ContentTax(Integer articleId, Integer taxId) {
        this.articleId = articleId;
        this.taxId = taxId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getTaxId() {
        return taxId;
    }

    public void setTaxId(Integer taxId) {
        this.taxId = taxId;
    }
}