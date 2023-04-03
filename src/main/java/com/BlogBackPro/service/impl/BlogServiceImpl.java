package com.BlogBackPro.service.impl;

import com.BlogBackPro.mapper.BlogMapper;
import com.BlogBackPro.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogMapper blogMapper;

    @Override
    public String newBlog(String title, String content, int authorId) {
        blogMapper.newBlog(title, content, authorId);
        return "new blog created!";
    }

    @Override
    public String modifyBlog(String title, String content, int blogId) {
        blogMapper.modifyBlog(title, content, blogId);
        return "blog has been modified!";
    }
}
