package com.vector.blog.model;

/**
 * Created by vector on 2017/4/16.
 */
public class Link {
    private String linkAddress;
    private String linkDescription;
    private String linkTitle;

    public Link(String linkAddress, String linkDescription, String linkTitle) {
        this.linkAddress = linkAddress;
        this.linkDescription = linkDescription;
        this.linkTitle = linkTitle;
    }

    public Link() {
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

    public String getLinkDescription() {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
    }

    public String getLinkTitle() {
        return linkTitle;
    }

    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
    }
}
