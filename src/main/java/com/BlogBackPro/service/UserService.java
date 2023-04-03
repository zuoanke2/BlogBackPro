package com.BlogBackPro.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String newUser(String userName, String passWord);

    String login(String userName, String passWord);

    String logout(String userName, String userToken);

    String deleteUser(int deleteUserId, String adminToken);
}
