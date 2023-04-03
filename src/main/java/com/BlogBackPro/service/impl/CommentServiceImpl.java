package com.BlogBackPro.service.impl;

import com.BlogBackPro.mapper.CommentMapper;
import com.BlogBackPro.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    CommentMapper commentMapper;

    @Override
    public String addComment(int authorId, int blogId, String comment) {
        commentMapper.addComment(authorId, blogId, comment);
        return "comment added!";
    }
}