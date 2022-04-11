package com.book.service;

import com.book.pojo.Cart;
import com.book.pojo.CartItem;
import com.book.pojo.User;

import java.util.List;

public interface CartItemService {
    //新增购物车项
    void addCartItem(CartItem cartItem);
    //修改购物车项
    void updateCartItem(CartItem cartItem);
    void addOrUpdateCartItem(CartItem cartItem, Cart cart);
    //获取指定用户的购物车
    Cart getCart(User user);
    //获取指定用户的购物车项，包括Book的所有信息
    List<CartItem> getCartItemList(User user);
}
