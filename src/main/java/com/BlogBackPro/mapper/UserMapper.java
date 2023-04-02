package com.BlogBackPro.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @className UserMapper
 * @author Anke Zuo
 * @description DAO of user service
 * @updateTime 2/9/23 02:20
 * @version 1.0
 */
@Mapper
public interface UserMapper {
    String verifyUserName(String userName);

    void newUser(String userName, String passWord);
}
