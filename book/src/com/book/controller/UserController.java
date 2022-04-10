package com.book.controller;

import com.book.pojo.User;
import com.book.service.UserService;

import javax.servlet.http.HttpSession;

public class UserController {

    private UserService userService;

    public String login(String uname, String pwd, HttpSession session) {

        User user = userService.login(uname, pwd);
        if(user != null){
            session.setAttribute("currUser",user);
            return "redirect:book.do?operate=index";
        }
        return "user/login";
    }
}
