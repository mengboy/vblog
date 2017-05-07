package com.vector.blog.model;

import java.util.Date;
import java.util.List;

public class Article {
    private Integer articleId;

    private String articleTitle;

    private String articleSummary;

    private Integer articleMarkdown;

    private String articleModule;

    private Integer userId;

    private String articleAuthor;

    private Integer articleView;

    private Date articleCreated;

    private Date articleModified;

    private String articleKeywords;

    private String articleDesc;

    private String articleStatus;

    private String articleText;

    private String articleFlag;

    private int commentCount;

    private List<Taxonomy> categories;

    private List<Taxonomy> articleTags;



    public List<Taxonomy> getCategories() {
        return categories;
    }

    public void setCategories(List<Taxonomy> categories) {
        this.categories = categories;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }


    public String getArticleFlag() {
        return articleFlag;
    }

    public void setArticleFlag(String articleFlag) {
        this.articleFlag = articleFlag;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary == null ? null : articleSummary.trim();
    }

    public Integer getArticleMarkdown() {
        return articleMarkdown;
    }

    public void setArticleMarkdown(Integer articleMarkdown) {
        this.articleMarkdown = articleMarkdown;
    }

    public String getArticleModule() {
        return articleModule;
    }

    public void setArticleModule(String articleModule) {
        this.articleModule = articleModule == null ? null : articleModule.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor == null ? null : articleAuthor.trim();
    }

    public Integer getArticleView() {
        return articleView;
    }

    public void setArticleView(Integer articleView) {
        this.articleView = articleView;
    }

    public Date getArticleCreated() {
        return articleCreated;
    }

    public void setArticleCreated(Date articleCreated) {
        this.articleCreated = articleCreated;
    }

    public Date getArticleModified() {
        return articleModified;
    }

    public void setArticleModified(Date articleModified) {
        this.articleModified = articleModified;
    }

    public String getArticleKeywords() {
        return articleKeywords;
    }

    public void setArticleKeywords(String articleKeywords) {
        this.articleKeywords = articleKeywords == null ? null : articleKeywords.trim();
    }

    public String getArticleDesc() {
        return articleDesc;
    }

    public void setArticleDesc(String articleDesc) {
        this.articleDesc = articleDesc == null ? null : articleDesc.trim();
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText == null ? null : articleText.trim();
    }

    public List<Taxonomy> getArticleTags() {
        return articleTags;
    }

    public void setArticleTags(List<Taxonomy> articleTags) {
        this.articleTags = articleTags;
    }
}