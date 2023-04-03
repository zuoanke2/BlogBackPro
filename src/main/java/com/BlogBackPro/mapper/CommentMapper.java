package com.BlogBackPro.mapper;

import com.BlogBackPro.model.CommentBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @className CommentMapper
 * @author Anke Zuo
 * @description DAO of comment service
 * @updateTime 2/9/23 02:19
 * @version 1.0
 */
@Mapper
public interface CommentMapper {
    List<CommentBean> queryCommendListByBlogId(int blogId);

    void addComment(int authorId, int blogId, String comment);

    void modifyComment(int commentId, String comment);

    void deleteComment(int commentId);

    List<CommentBean> queryCommendListByUserId(int userId);

    int queryCommentAuthor(int commentId);
}
