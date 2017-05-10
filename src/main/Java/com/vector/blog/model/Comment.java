package com.vector.blog.model;

import java.util.Date;

public class Comment {
    private Integer commentId;

    private Integer articleId;

    private Integer parentId;

    private Integer userId;

    private String commentIp;

    private String commentAuthor;

    private Date commentCreated;

    private String commentEmail;

    private String commentStatus;

    private String commentText;

    private Comment parentComment;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCommentIp() {
        return commentIp;
    }

    public void setCommentIp(String commentIp) {
        this.commentIp = commentIp == null ? null : commentIp.trim();
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor == null ? null : commentAuthor.trim();
    }

    public Date getCommentCreated() {
        return commentCreated;
    }

    public void setCommentCreated(Date commentCreated) {
        this.commentCreated = commentCreated;
    }

    public String getCommentEmail() {
        return commentEmail;
    }

    public void setCommentEmail(String commentEmail) {
        this.commentEmail = commentEmail == null ? null : commentEmail.trim();
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus == null ? null : commentStatus.trim();
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText == null ? null : commentText.trim();
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }
}