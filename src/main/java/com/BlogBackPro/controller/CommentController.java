package com.BlogBackPro.controller;

import com.BlogBackPro.mapper.BlogMapper;
import com.BlogBackPro.mapper.CommentMapper;
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
    @Resource
    CommentMapper commentMapper;
    @Resource
    BlogMapper blogMapper;

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

    @PostMapping("/comment/modify")
    public String modifyComment(@RequestBody CommentBean commentBean) {
        String userName = userMapper.queryUserNameById(commentBean.getAuthorId());
        if (commentBean.getToken().equals(userMapper.getUserToken(userName)) && (commentBean.getAuthorId() == commentMapper.queryCommentAuthor(commentBean.getCommentId()))) {
            return commentService.modifyComment(commentBean.getCommentId(), commentBean.getComment());
        } else {
            return "invalid user or not your comment!";
        }
    }

    @PostMapping("/comment/delete")
    public String deleteComment(@RequestBody CommentBean commentBean) {
        String userName = userMapper.queryUserNameById(commentBean.getAuthorId());
        if (commentBean.getToken().equals(userMapper.getUserToken(userName)) && ((commentBean.getAuthorId() == commentMapper.queryCommentAuthor(commentBean.getCommentId())) || (commentBean.getAuthorId() == blogMapper.queryAuthorByBlogId(commentBean.getBlogId())))) {
            return commentService.deleteComment(commentBean.getCommentId());
        } else {
            return "invalid user!";
        }
    }

    @PostMapping("/comment/my")
    public List<CommentBean> queryCommendListByUserId(@RequestBody CommentBean commentBean) {
        String userName = userMapper.queryUserNameById(commentBean.getAuthorId());
        if (commentBean.getToken().equals(userMapper.getUserToken(userName))) {
            List<CommentBean> res = commentService.queryCommendListByUserId(commentBean.getAuthorId());
            for (CommentBean commentBean1 : res) {
                commentBean1.setBlogTitle(blogMapper.queryTitleByBlogId(commentBean1.getBlogId()));
            }
            return res;
        } else {
            return null;
        }
    }
}
