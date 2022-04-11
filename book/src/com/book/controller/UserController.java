package com.book.controller;

import com.book.pojo.Cart;
import com.book.pojo.User;
import com.book.service.CartItemService;
import com.book.service.UserService;

import javax.servlet.http.HttpSession;

public class UserController {

    private UserService userService;
    private CartItemService cartItemService;

    public String login(String uname, String pwd, HttpSession session) {

        User user = userService.login(uname, pwd);
        if(user != null){
            Cart cart = cartItemService.getCart(user);
            user.setCart(cart);
            session.setAttribute("currUser",user);
            return "redirect:book.do?operate=index";
        }
        return "user/login";
    }
}
