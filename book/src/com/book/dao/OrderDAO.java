package com.book.dao;

import com.book.pojo.OrderBean;
import com.book.pojo.User;

import java.util.List;

public interface OrderDAO {
    //添加订单
    void addOrderBean(OrderBean orderBean);
    //获取之风用户的订单列表
    List<OrderBean> getOrderList(User user);
    Integer getOrderTotalBookCount(OrderBean orderBean);
}
