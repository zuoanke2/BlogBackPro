package com.BlogBackPro.controller;

import com.BlogBackPro.mapper.UserMapper;
import com.BlogBackPro.model.CommentBean;
import com.BlogBackPro.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CommentController {
    @Resource
    UserMapper userMapper;

    @Autowired
    private CommentService commentService;

    @PostMapping("/comment/add")
    public String addComment(@RequestBody CommentBean commentBean) {
        String userName = userMapper.queryUserNameById(commentBean.getAuthorId());
        if (commentBean.getToken().equals(userMapper.getUserToken(userName))) {
            return commentService.addComment(commentBean.getAuthorId(), commentBean.getBlogId(), commentBean.getComment());
        } else {
            return "invalid user!";
        }
    }
}
