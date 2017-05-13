package com.vector.blog.service;

import com.vector.blog.model.Comment;

import java.util.List;

/**
 * Created by vector on 2017/5/7.
 */
public interface CommentService {
    List<Comment> getCommentByArticleId(int articleId);

    Comment getCommentByParentId(int parentId);

    public int addComment(Comment comment);

    public int getCommentCountByArticleId(int articleId);
}
