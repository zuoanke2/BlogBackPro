package com.BlogBackPro.service;

import com.BlogBackPro.model.BlogBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService {
    String newBlog(String title, String content, int authorId);

    String modifyBlog(String title, String content, int blogId);

    String deleteBlog(int blogId);

    List<BlogBean> queryAllBlogs();

    List<BlogBean> queryBlogsByUserId(int authorId);
}
