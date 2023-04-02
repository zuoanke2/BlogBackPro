package com.BlogBackPro.service.impl;

import com.BlogBackPro.mapper.UserMapper;
import com.BlogBackPro.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean verifyUserName(String userName) {
        if (userName.equals(userMapper.verifyUserName(userName))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void newUser(String userName, String passWord) {
        userMapper.newUser(userName, passWord);
    }
}
