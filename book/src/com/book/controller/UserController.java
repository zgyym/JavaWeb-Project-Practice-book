package com.book.controller;

import com.book.pojo.Cart;
import com.book.pojo.User;
import com.book.service.CartItemService;
import com.book.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

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

    /*public String regist(String uname, String pwd, String email, String verifyCode, HttpSession session, HttpServletResponse response) throws IOException {
        Object verifyCodeObj = session.getAttribute("KAPTCHA_SESSION_KEY");
        if(verifyCodeObj == null || !verifyCode.equals(verifyCodeObj)){
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script language='javascript'>alert('验证码不正确！');window.location.href='page.do?operate=page&page=user/regist';</script>");
            return null;
        }else{
            if(verifyCode.equals(verifyCodeObj)) {//可写可不写
                User user = new User(uname, pwd, email);
                userService.regist(user);
                return "user/login";
            }
        }
        return "user/login";
    }
*/

    public String regist(String uname, String pwd, String email, String verifyCode, HttpSession session, HttpServletResponse response) throws IOException {
        Object verifyCodeObj = session.getAttribute("KAPTCHA_SESSION_KEY");
        if(verifyCodeObj == null){  //verifyCodeObj为空，注册失败
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script language='javascript'>alert('验证码不正确！');window.location.href='page.do?operate=page&page=user/regist';</script>");
            return null;
        }else{
            if(!verifyCode.equals(verifyCodeObj)) {     //验证码不一致，注册失败
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<script language='javascript'>alert('验证码不正确！');window.location.href='page.do?operate=page&page=user/regist';</script>");
                return null;
            }else {         //注册成功
                User user = new User(uname, pwd, email);
                userService.regist(user);
                return "user/login";
            }
        }
    }
}
