package com.book.dao;

import com.book.pojo.CartItem;
import com.book.pojo.User;

import java.util.List;

public interface CartItemDAO {
    //新增购物车项
    void addCartItem(CartItem cartItem);
    //修改购物车项
    void updateCartItem(CartItem cartItem);
    //获取指定用户的所有购物车项
    List<CartItem> getCartItemList(User user);
    //删除指定购物车项
    void delCartItem(CartItem cartItem);
}
