package com.BlogBackPro.controller;

import com.BlogBackPro.mapper.UserMapper;
import com.BlogBackPro.model.BlogBean;
import com.BlogBackPro.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Resource
    private UserMapper userMapper;

    @PostMapping("/blog/new")
    public String newBlog(@RequestBody BlogBean blogBean) {
        String userName = userMapper.queryUserNameById(blogBean.getAuthorId());
        if (blogBean.getToken().equals(userMapper.getUserToken(userName))) {
            return blogService.newBlog(blogBean.getTitle(), blogBean.getContent(), blogBean.getAuthorId());
        } else {
            return "invalid user!";
        }
    }
}
