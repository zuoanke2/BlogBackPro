package com.BlogBackPro.service;

import org.springframework.stereotype.Service;

/**
 * @className UserService
 * @author Anke Zuo
 * @description user relates service
 * @updateTime 2/9/23 02:10
 * @version 1.0
 */
@Service
public interface UserService {
    boolean verifyUserName(String userName);
    void newUser(String userName, String passWord);
}
