package com.book.pojo;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

public class Cart {
    private Map<Integer,CartItem> cartItemMap;                  //购物车中购物车项的集合，这个Map集合的key是Book的id
    private Double totalMoney;                                  //购物车的总金额
    private Integer totalCount;                                 //购物车中购物车项的数量
    private Integer totalBookCount;                             //购物车中所有图书的数量，不是购物车项的数量

    public Cart() {
    }

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Double getTotalMoney() {
        totalMoney = 0.0;
        if(cartItemMap != null && cartItemMap.size() > 0){
            Set<Map.Entry<Integer, CartItem>> entrySet = cartItemMap.entrySet();
            for(Map.Entry<Integer, CartItem> cartItemEntry : entrySet){
                CartItem cartItem = cartItemEntry.getValue();
                BigDecimal bigDecimalPrice = new BigDecimal("" + cartItem.getBook().getPrice());
                BigDecimal bigDecimalBuyCount = new BigDecimal("" + cartItem.getBuyCount());
                BigDecimal bigDecimalTotalMoney = bigDecimalPrice.multiply(bigDecimalBuyCount);
                Double temp = bigDecimalTotalMoney.doubleValue();
                totalMoney =totalMoney + temp;
            }
        }
        return totalMoney;
    }


    public Integer getTotalCount() {
        totalCount = 0;
        if(cartItemMap != null && cartItemMap.size() > 0){
            totalCount = cartItemMap.size();
        }
        return totalCount;
    }

    public Integer getTotalBookCount() {
        totalBookCount = 0;
        if(cartItemMap != null && cartItemMap.size() > 0){
            for(CartItem cartItem : cartItemMap.values()){
                totalBookCount = totalBookCount + cartItem.getBuyCount();
            }
        }
        return totalBookCount;
    }
}
