package com.BlogBackPro.service.impl;

import com.BlogBackPro.mapper.CommentMapper;
import com.BlogBackPro.model.CommentBean;
import com.BlogBackPro.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    CommentMapper commentMapper;

    @Override
    public String addComment(int authorId, int blogId, String comment) {
        commentMapper.addComment(authorId, blogId, comment);
        return "comment added!";
    }

    @Override
    public String modifyComment(int commentId, String comment) {
        commentMapper.modifyComment(commentId, comment);
        return "comment modified!";
    }

    @Override
    public String deleteComment(int commentId) {
        commentMapper.deleteComment(commentId);
        return "comment deleted!";
    }

    @Override
    public List<CommentBean> queryCommendListByUserId(int userId) {
        return commentMapper.queryCommendListByUserId(userId);
    }
}
