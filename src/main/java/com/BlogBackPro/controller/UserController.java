package com.BlogBackPro.controller;

import com.BlogBackPro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.BlogBackPro.model.UserBean;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/new")
    public String newUser(@RequestBody UserBean userBean) {
        return userService.newUser(userBean.getUserName(), userBean.getPassWord());
    }

    @PostMapping("/user/login")
    public String login(@RequestBody UserBean userBean) {
        return userService.login(userBean.getUserName(), userBean.getPassWord());
    }

    @PostMapping("/user/logout")
    public String logout(@RequestBody UserBean userBean) {
        return userService.logout(userBean.getUserName(), userBean.getToken());
    }

    @PostMapping("/user/delete")
    public String deleteUser(@RequestBody UserBean userBean) {
        return userService.deleteUser(userBean.getUserId(), userBean.getToken());
    }
}
