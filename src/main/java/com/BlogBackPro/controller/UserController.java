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
        if (!userService.verifyUserName(userVO.getUserName())) {
            userService.newUser(userVO.getUserName(), userVO.getPassWord());
            return "added an new user!";
        } else {
            return "duplicate username!";
        }
    }
}
