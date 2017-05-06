package com.vector.blog.model.admin;

/**
 * Created by vector on 2017/4/20.
 */
public class TaxonomyType {
    private String formType;
    private String title;
    private String name;

    public TaxonomyType(String formType, String title, String name) {
        this.formType = formType;
        this.title = title;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaxonomyType() {
    }

    public TaxonomyType(String formType, String title) {
        this.formType = formType;
        this.title = title;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

