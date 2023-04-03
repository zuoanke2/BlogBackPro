package com.BlogBackPro.controller;

import com.BlogBackPro.mapper.CommentMapper;
import com.BlogBackPro.mapper.UserMapper;
import com.BlogBackPro.model.BlogBean;
import com.BlogBackPro.model.CommentBean;
import com.BlogBackPro.model.CommentBeanSimple;
import com.BlogBackPro.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Resource
    private UserMapper userMapper;
    @Resource
    private CommentMapper commentMapper;

    @PostMapping("/blog/new")
    public String newBlog(@RequestBody BlogBean blogBean) {
        String userName = userMapper.queryUserNameById(blogBean.getAuthorId());
        if (blogBean.getToken().equals(userMapper.getUserToken(userName))) {
            return blogService.newBlog(blogBean.getTitle(), blogBean.getContent(), blogBean.getAuthorId());
        } else {
            return "invalid user!";
        }
    }

    @PostMapping("/blog/modify")
    public String modifyBlog(@RequestBody BlogBean blogBean) {
        String userName = userMapper.queryUserNameById(blogBean.getAuthorId());
        if (blogBean.getToken().equals(userMapper.getUserToken(userName))) {
            return blogService.modifyBlog(blogBean.getTitle(), blogBean.getContent(), blogBean.getBlogId());
        } else {
            return "invalid user!";
        }
    }

    @PostMapping("/blog/delete")
    public String deleteBlog(@RequestBody BlogBean blogBean) {
        String userName = userMapper.queryUserNameById(blogBean.getAuthorId());
        if (blogBean.getToken().equals(userMapper.getUserToken(userName))) {
            return blogService.deleteBlog(blogBean.getBlogId());
        } else {
            return "invalid user!";
        }
    }

    @PostMapping("/blog/all")
    public List<BlogBean> queryAllBlogs(@RequestBody BlogBean blogBean) {
        String userName = userMapper.queryUserNameById(blogBean.getAuthorId());
        if (blogBean.getToken().equals(userMapper.getUserToken(userName))) {
            return blogService.queryAllBlogs();
        } else {
            return null;
        }
    }

    @PostMapping("/blog/my")
    public List<BlogBean> queryMyBlogs(@RequestBody BlogBean blogBean) {
        String userName = userMapper.queryUserNameById(blogBean.getAuthorId());
        if (blogBean.getToken().equals(userMapper.getUserToken(userName))) {
            return blogService.queryBlogsByUserId(blogBean.getAuthorId());
        } else {
            return null;
        }
    }

    @PostMapping("/blog/single")
    public BlogBean queryBlogByBlogId(@RequestBody BlogBean blogBean) {
        String userName = userMapper.queryUserNameById(blogBean.getAuthorId());
        if (blogBean.getToken().equals(userMapper.getUserToken(userName))) {
            BlogBean res = blogService.queryBlogByBlogId(blogBean.getBlogId());
            List<CommentBean> commentBeanList = commentMapper.queryCommendListByBlogId(blogBean.getBlogId());
            List<CommentBeanSimple> commentBeanSimpleList = new ArrayList<>();
            for (CommentBean commentBean : commentBeanList) {
                CommentBeanSimple commentBeanSimple = new CommentBeanSimple();
                commentBeanSimple.setComment(commentBean.getComment());
                commentBeanSimple.setAuthorName(userMapper.queryUserNameById(commentBean.getAuthorId()));
                commentBeanSimpleList.add(commentBeanSimple);
            }
            res.setAuthorName(userName);
            res.setCommentList(commentBeanSimpleList);
            return res;
        } else {
            return null;
        }
    }
}
