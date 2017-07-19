package com.eleme.dao;

import com.eleme.pojo.Orders;

import java.util.List;

/**
 * Order DAO
 * Created by Administrator on 2017/7/18 0018.
 */
public interface OrdersDAO {
    // 获取指定用户的订单列表
    public List getOrdersByUserId(int userId);

    // 根据订单编号加载订单对象
    public Orders getOrdersByOid(int oid);

    // 删除订单对象
    public void deleteOrders(Orders orders);
}
