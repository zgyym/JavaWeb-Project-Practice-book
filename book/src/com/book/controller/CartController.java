package com.book.controller;

import com.book.pojo.Book;
import com.book.pojo.Cart;
import com.book.pojo.CartItem;
import com.book.pojo.User;
import com.book.service.CartItemService;
import com.google.gson.Gson;

import javax.servlet.http.HttpSession;

public class CartController {

    private CartItemService cartItemService ;

    //加载当前用户的购物车信息
    public String index(HttpSession session){
        User user =(User)session.getAttribute("currUser");
        Cart cart = cartItemService.getCart(user);
        user.setCart(cart);
        session.setAttribute("currUser",user);
        return "cart/cart";
    }

    public String addCart(Integer bookId , HttpSession session){
        User user = (User)session.getAttribute("currUser");
        CartItem cartItem = new CartItem(new Book(bookId),1,user);
        //将指定的图书添加到当前用户的购物车中
        cartItemService.addOrUpdateCartItem(cartItem,user.getCart());

        return "redirect:cart.do";
    }

    public String editCart(Integer cartItemId,Integer buyCount){
        cartItemService.updateCartItem(new CartItem(cartItemId,buyCount));
        return "";
    }

    public String cartInfo(HttpSession session){
        User user =(User)session.getAttribute("currUser");
        Cart cart = cartItemService.getCart(user);
        Gson gson = new Gson();
        String cartJsonStr = gson.toJson(cart);
        return "json:" + cartJsonStr;
    }
}
