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

    // 获取指定页显示的订单列表
    public List getAllOrders(int page);

    // 统计所有的订单数量
    public Integer getCountOfAllOrders();

    // 获取满足条件、指定页显示的订单列表
    public List getOrdersByCondition(Orders condition, int page);

    // 统计满足条件的订单总数
    public Integer getCountOfOrders(Orders condition);

    //更新订单对象
    public void updateOrders(Orders orders);
}
