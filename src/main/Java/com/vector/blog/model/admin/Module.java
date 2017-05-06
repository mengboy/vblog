package com.vector.blog.model.admin;

import java.util.List;

/**
 * Created by vector on 2017/4/17.
 */
public class Module {
    private String name;
    private String title;
    private int findNotDeleteContentCount;
    private int findDraftContentCount;
    private int findDeleteContentCount;
    private String styles;
    private String addTitle;
    private List<TaxonomyType> taxonomyTypes;

    public Module(String name, String title, int findNotDeleteContentCount, int findDraftContentCount, int findDeleteContentCount) {
        this.name = name;
        this.title = title;
        this.findNotDeleteContentCount = findNotDeleteContentCount;
        this.findDraftContentCount = findDraftContentCount;
        this.findDeleteContentCount = findDeleteContentCount;
    }

    public Module(String addTitle) {
        this.addTitle = addTitle;
//        this.styles = style;
    }

    public List<TaxonomyType> getTaxonomyTypes() {
        return taxonomyTypes;
    }

    public void setTaxonomyTypes(List<TaxonomyType> taxonomyTypes) {
        this.taxonomyTypes = taxonomyTypes;
    }

    public String getStyle() {
        return styles;
    }

    public void setStyle(String style) {
        this.styles = style;
    }

    public Module() {
    }

    public String getStyles() {
        return styles;
    }

    public void setStyles(String styles) {
        this.styles = styles;
    }

    public String getAddTitle() {
        return addTitle;
    }

    public void setAddTitle(String addTitle) {
        this.addTitle = addTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFindNotDeleteContentCount() {
        return findNotDeleteContentCount;
    }

    public void setFindNotDeleteContentCount(int findNotDeleteContentCount) {
        this.findNotDeleteContentCount = findNotDeleteContentCount;
    }

    public int getFindDraftContentCount() {
        return findDraftContentCount;
    }

    public void setFindDraftContentCount(int findDraftContentCount) {
        this.findDraftContentCount = findDraftContentCount;
    }

    public int getFindDeleteContentCount() {
        return findDeleteContentCount;
    }

    public void setFindDeleteContentCount(int findDeleteContentCount) {
        this.findDeleteContentCount = findDeleteContentCount;
    }
}

