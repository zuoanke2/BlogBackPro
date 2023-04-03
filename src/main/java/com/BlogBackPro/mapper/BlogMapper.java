package com.BlogBackPro.mapper;

import com.BlogBackPro.model.BlogBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {
    void newBlog(String title, String content, int authorId);

    void modifyBlog(String title, String content, int blogId);

    void deleteBlog(int blogId);

    List<BlogBean> queryAllBlogs();
}

