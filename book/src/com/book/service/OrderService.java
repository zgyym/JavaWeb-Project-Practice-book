package com.book.service;

import com.book.pojo.OrderBean;
import com.book.pojo.User;

import java.util.List;

public interface OrderService {
    //添加订单
    void addOrderBean(OrderBean orderBean);
    //获取指定用户的订单列表
    List<OrderBean> getOrderList(User user);
}
