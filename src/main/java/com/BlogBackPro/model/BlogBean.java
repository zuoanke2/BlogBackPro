package com.BlogBackPro.model;

import java.util.List;

public class BlogBean {
    private int blogId;
    private String title;
    private int authorId;
    private String authorName;
    private String content;
    private String token;

    private List<CommentBeanSimple> commentList;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<CommentBeanSimple> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentBeanSimple> commentList) {
        this.commentList = commentList;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
