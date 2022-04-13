package com.book.dao.impl;

import com.book.dao.OrderDAO;
import com.book.pojo.OrderBean;
import com.myssm.basedao.BaseDAO;

public class OrderDAOImpl extends BaseDAO<OrderBean> implements OrderDAO {
    @Override
    public void addOrderBean(OrderBean orderBean) {
        int orderBeanId = super.executeUpdate("insert into t_order values(0,?,?,?,?,?)",orderBean.getOrderNo(),orderBean.getOrderDate(),orderBean.getOrderUser().getId(),orderBean.getOrderMoney(),orderBean.getOrderStatus());
        orderBean.setId(orderBeanId);
        //如果是插入操作的话,会返回插入后的主键值，此处接受该主键值后设置到orderBean对象
    }
}
