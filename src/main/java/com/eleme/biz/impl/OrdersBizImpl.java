package com.eleme.biz.impl;

import com.eleme.biz.OrdersBiz;
import com.eleme.dao.OrdersDAO;
import com.eleme.pojo.Orders;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18 0018.
 */
public class OrdersBizImpl implements OrdersBiz {
    OrdersDAO ordersDAO;

    public void setOrdersDAO(OrdersDAO ordersDAO) {
        this.ordersDAO = ordersDAO;
    }

    @Override
    public List getOrdersByUserId(int userId) {
        return ordersDAO.getOrdersByUserId(userId);
    }

    @Override
    public void deleteOrdersByOid(int oid) {
        Orders orders = ordersDAO.getOrdersByOid(oid);
        ordersDAO.deleteOrders(orders);
    }
}
