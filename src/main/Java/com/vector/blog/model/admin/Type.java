package com.vector.blog.model.admin;

/**
 * Created by vector on 2017/4/20.
 */
public class Type {
    private String title;
    private String name;

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    private String formType;

    public Type(String title, String name, String formType) {
        this.title = title;
        this.name = name;
        this.formType = formType;
    }



    public Type() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
