package com.vector.blog.model;

/**
 * Created by vector on 2017/4/18.
 */
public class Content {
    private String slug;
    private String text;
    private String title;

    public Content(String slug, String text, String title) {
        this.slug = slug;
        this.text = text;
        this.title = title;
    }

    public Content() {
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
