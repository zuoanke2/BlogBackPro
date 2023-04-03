package com.BlogBackPro.service.impl;

import com.BlogBackPro.mapper.UserMapper;
import com.BlogBackPro.service.UserService;
import org.springframework.stereotype.Service;
import java.util.Random;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0; i<length; i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    @Override
    public String newUser(String userName, String passWord) {
        if (!userName.equals(userMapper.verifyUserName(userName))) {
            userMapper.newUser(userName, passWord);
            return "added an new user!";
        } else {
            return "duplicate username!";
        }
    }

    @Override
    public String login(String userName, String passWord) {
        if (!userName.equals(userMapper.verifyUserName(userName))) {
            return "this user hasn't registered yet!";
        } else {
            if (!passWord.equals(userMapper.verifyPassWord(userName))) {
                return "invalid password!";
            } else {
                String token = getRandomString(8);
                userMapper.newToken(userName, token);
                return token;
            }
        }
    }

    public String logout(String userName, String userToken) {
        if (userToken.equals(userMapper.getUserToken(userName))) {
            userMapper.cleanToken(userName);
            return "successfully logged out!";
        } else {
            return "invalid user!";
        }
    }

    public String deleteUser(int deleteUserId, String adminToken) {
        if (adminToken.equals(userMapper.getUserToken("admin"))) {
            userMapper.deleteUser(deleteUserId);
            return "an user was deleted!";
        } else {
            return "invalid user!";
        }
    }
}
