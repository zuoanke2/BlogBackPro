package com.BlogBackPro.service;

import org.springframework.stereotype.Service;

@Service
public interface BlogService {
    String newBlog(String title, String content, int authorId);

    String modifyBlog(String title, String content, int blogId);
}
