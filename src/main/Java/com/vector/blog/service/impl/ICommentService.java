package com.vector.blog.service.impl;

import com.vector.blog.common.Status;
import com.vector.blog.mapper.ArticleMapper;
import com.vector.blog.mapper.CommentMapper;
import com.vector.blog.model.Comment;
import com.vector.blog.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vector on 2017/5/7.
 */

@Service("CommentService")
public class ICommentService implements CommentService{
    @Resource
    CommentMapper commentMapper;

    public List<Comment> getCommentByArticleId(int articleId) {
        try{
            List<Comment> comments = new LinkedList<Comment>();
            comments = commentMapper.getCommentsByArticleId(articleId);
            return comments;
        }catch (Exception e){
            return null;
        }
    }

    public Comment getCommentByParentId(int parentId) {
        try {
            return commentMapper.selectByPrimaryKey(parentId);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public int addComment(Comment comment) {
        try {
            commentMapper.insertSelective(comment);
            return Status.SUCCESS;
        }catch (Exception e){
            return Status.ERROR;
        }
    }

    public int getCommentCountByArticleId(int articleId) {
        return commentMapper.getCommentCountByArticleId(articleId);
    }
}
