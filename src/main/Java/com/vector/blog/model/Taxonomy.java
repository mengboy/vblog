package com.vector.blog.model;

public class Taxonomy {
    private Integer taxId;

    private String taxTitle;

    private String taxText;

    private String taxSlug;

    private String taxType;

    private String taxContentModule;

    private Integer taxContentCount;

    private Integer taxParentId;


    public Taxonomy(String taxTitle, String taxText, String taxSlug, String taxType, String taxContentModule, Integer taxParentId) {
        this.taxTitle = taxTitle;
        this.taxText = taxText;
        this.taxSlug = taxSlug;
        this.taxType = taxType;
        this.taxContentModule = taxContentModule;
        this.taxParentId = taxParentId;
    }


    public Taxonomy(String taxTitle, String taxText, String taxSlug, String taxType, String taxContentModule) {
        this.taxTitle = taxTitle;
        this.taxText = taxText;
        this.taxSlug = taxSlug;
        this.taxType = taxType;
        this.taxContentModule = taxContentModule;

    }



    public Taxonomy(String taxTitle, String taxSlug, String taxType, String taxContentModule) {
        this.taxTitle = taxTitle;
        this.taxSlug = taxSlug;
        this.taxType = taxType;
        this.taxContentModule = taxContentModule;
    }

    public Taxonomy() {
    }

    public Integer getTaxId() {
        return taxId;
    }

    public void setTaxId(Integer taxId) {
        this.taxId = taxId;
    }

    public String getTaxTitle() {
        return taxTitle;
    }

    public void setTaxTitle(String taxTitle) {
        this.taxTitle = taxTitle == null ? null : taxTitle.trim();
    }

    public String getTaxText() {
        return taxText;
    }

    public void setTaxText(String taxText) {
        this.taxText = taxText == null ? null : taxText.trim();
    }

    public String getTaxSlug() {
        return taxSlug;
    }

    public void setTaxSlug(String taxSlug) {
        this.taxSlug = taxSlug == null ? null : taxSlug.trim();
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType == null ? null : taxType.trim();
    }

    public String getTaxContentModule() {
        return taxContentModule;
    }

    public void setTaxContentModule(String taxContentModule) {
        this.taxContentModule = taxContentModule == null ? null : taxContentModule.trim();
    }

    public Integer getTaxContentCount() {
        return taxContentCount;
    }

    public void setTaxContentCount(Integer taxContentCount) {
        this.taxContentCount = taxContentCount;
    }

    public Integer getTaxParentId() {
        return taxParentId;
    }

    public void setTaxParentId(Integer taxParentId) {
        this.taxParentId = taxParentId;
    }
}