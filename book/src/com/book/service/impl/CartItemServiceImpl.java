package com.book.service.impl;

import com.book.dao.BookDAO;
import com.book.dao.CartItemDAO;
import com.book.pojo.Book;
import com.book.pojo.Cart;
import com.book.pojo.CartItem;
import com.book.pojo.User;
import com.book.service.BookService;
import com.book.service.CartItemService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartItemServiceImpl implements CartItemService {

    private CartItemDAO cartItemDAO;
    private BookService bookService;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDAO.addCartItem(cartItem);
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        cartItemDAO.updateCartItem(cartItem);
    }

    @Override
    public void addOrUpdateCartItem(CartItem cartItem, Cart cart) {
        //如果当前用户的购物车中已经存在这个图书了，那么将改图书数量加1
        //如果购物车中不存在，在购物成中新增一个这本图书cartItem，数量是1
        if(cart != null){
            //判断当前用户的购物车中是否有这本书的cartItem   没有->add   有->update
            Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
            if(cartItemMap == null){
                cartItemMap = new HashMap<>();
            }
            if(cartItemMap.containsKey(cartItem.getBook().getId())){
                CartItem cartItemTemp = cartItemMap.get(cartItem.getBook().getId());
                cartItemTemp.setBuyCount(cartItemTemp.getBuyCount() + 1);
                updateCartItem(cartItemTemp);
            }else{
                addCartItem(cartItem);
            }
        }else{
            addCartItem(cartItem);
        }
    }

    @Override
    public Cart getCart(User user) {
        List<CartItem> cartItemList =getCartItemList(user);
        Map<Integer,CartItem> cartItemMap = new HashMap<>();
        for(CartItem cartItem : cartItemList){
            cartItemMap.put(cartItem.getBook().getId(),cartItem);
        }
        Cart cart = new Cart();
        cart.setCartItemMap(cartItemMap);
        return cart;
    }

    @Override
    public List<CartItem> getCartItemList(User user) {
        List<CartItem> cartItemList = cartItemDAO.getCartItemList(user);
        for(CartItem cartItem : cartItemList){
            Book book = bookService.getBookById(cartItem.getBook().getId());
            cartItem.setBook(book);
        }
        return cartItemList;
    }

}
