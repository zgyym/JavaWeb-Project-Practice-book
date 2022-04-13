package com.book.service.impl;

import com.book.dao.CartItemDAO;
import com.book.dao.OrderDAO;
import com.book.dao.OrderItemDAO;
import com.book.pojo.CartItem;
import com.book.pojo.OrderBean;
import com.book.pojo.OrderItem;
import com.book.pojo.User;
import com.book.service.OrderService;

import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    private CartItemDAO cartItemDAO;

    @Override
    public void addORderBean(OrderBean orderBean) {
        //1) 订单表添加一条记录
        orderDAO.addOrderBean(orderBean);//运行到此处后，orderBean的id属性就有值了
        //2) 订单详情表添加若干条条记录
        //orderBean中的orderItemList是空的，此处我们应该根据用户的购物车中的购物车项去转换成一个一个的订单项
        User currUser = orderBean.getOrderUser();
        Map<Integer, CartItem> cartItemMap = currUser.getCart().getCartItemMap();
        for(CartItem cartItem : cartItemMap.values()){
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setBuyCount(cartItem.getBuyCount());
            orderItem.setOrderBean(orderBean);
            orderItemDAO.addOrderItem(orderItem);
        }
        //3) 购物车项表中需要删除对应的若干条条记录


        for(CartItem cartItem : cartItemMap.values()){
            cartItemDAO.delCartItem(cartItem);
        }
    }
}
