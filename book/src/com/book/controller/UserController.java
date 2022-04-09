package com.book.controller;

import com.book.pojo.User;
import com.book.service.UserService;

public class UserController {

    private UserService userService;

    public String login(String uname,String pwd){

        User user = userService.login(uname, pwd);
        return "index";
    }
}
