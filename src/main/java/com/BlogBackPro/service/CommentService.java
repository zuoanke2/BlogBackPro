package com.BlogBackPro.service;

import com.BlogBackPro.model.CommentBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    String addComment(int authorId, int blogId, String comment);

    String modifyComment(int commentId, String comment);

    String deleteComment(int commentId);

    List<CommentBean> queryCommendListByUserId(int userId);
}
