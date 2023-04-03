package com.BlogBackPro.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    String verifyUserName(String userName);

    String verifyPassWord(String userName);

    String getUserToken(String userName);

    String queryUserNameById(int userId);

    void newUser(String userName, String passWord);

    void newToken(String userName, String token);

    void cleanToken(String userName);
}
