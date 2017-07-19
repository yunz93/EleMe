package com.eleme.dao.impl;

import com.eleme.dao.OrderDtsDAO;
import com.eleme.pojo.Orderdts;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * 订单明细表DAO
 * Created by Administrator on 2017/7/18 0018.
 */
public class OrderDtsDAOImpl implements OrderDtsDAO {
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // 生成订单明细表
    @Override
    public void addOrderDts(Orderdts dts) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(dts);
    }

    // 根据订单主表编号获取订单明细列表
    @Override
    public List getOrderDtsByOid(int oid) {
        Session session = sessionFactory.getCurrentSession();
        Criteria c = session.createCriteria(Orderdts.class);
        c.add(Restrictions.eq("orders.oid", oid));
        return c.list();
    }
}
