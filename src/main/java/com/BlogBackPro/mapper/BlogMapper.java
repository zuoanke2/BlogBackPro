package com.BlogBackPro.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogMapper {
    void newBlog(String title, String content, int authorId);

    void modifyBlog(String title, String content, int blogId);

    void deleteBlog(int blogId);
}

