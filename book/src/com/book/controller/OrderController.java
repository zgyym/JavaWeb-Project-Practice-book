package com.book.controller;

import com.book.pojo.OrderBean;
import com.book.pojo.User;
import com.book.service.OrderService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

public class OrderController {
    private OrderService orderService;

    //结账
    public String checkout(HttpSession session){
        OrderBean orderBean = new OrderBean();

        Date now = new Date();
        int year = now.getYear();
        int month = now.getMonth() ;
        int day = now.getDate();
        int hour = now.getHours();
        int min = now.getMinutes() ;
        int sec = now.getSeconds() ;
        orderBean.setOrderNo(UUID.randomUUID().toString()+"_"+year+month+day+hour+min+sec);

        orderBean.setOrderDate(now);

        User user = (User) session.getAttribute("currUser");
        orderBean.setOrderUser(user);

        orderBean.setOrderMoney(user.getCart().getTotalMoney());

        orderBean.setOrderStatus(0);

        orderService.addORderBean(orderBean);

        return "index";

    }
}
