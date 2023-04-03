package com.BlogBackPro.controller;

import com.BlogBackPro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.BlogBackPro.model.UserVO;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/new")
    public String newUser(@RequestBody UserVO userVO) {
        return userService.newUser(userVO.getUserName(), userVO.getPassWord());
    }

    @PostMapping("/user/login")
    public String login(@RequestBody UserVO userVO) {
        return userService.login(userVO.getUserName(), userVO.getPassWord());
    }

    @PostMapping("/user/logout")
    public String logout(@RequestBody UserVO userVO) {
        return userService.logout(userVO.getUserName(), userVO.getToken());
    }
}
