package com.eleme.dao.impl;

import com.eleme.dao.OrdersDAO;
import com.eleme.pojo.Orders;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18 0018.
 */
public class OrdersDAOImpl implements OrdersDAO {
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // 获取指定用户的订单列表
    @Override
    public List getOrdersByUserId(int userId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria c = session.createCriteria(Orders.class);
        c.add(Restrictions.eq("users.id", userId));
        return c.list();
    }

    // 根据订单编号加载订单对象
    @Override
    public Orders getOrdersByOid(int oid) {
        Session session = sessionFactory.getCurrentSession();
        return (Orders)session.get(Orders.class, oid);
    }

    // 删除订单对象
    @Override
    public void deleteOrders(Orders orders) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(orders);
    }
}
