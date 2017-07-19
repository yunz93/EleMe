package com.eleme.dao.impl;

import com.eleme.dao.MealSeriesDAO;
import com.eleme.pojo.Mealseries;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * MealSeries DAO Implementation class
 * Created by Administrator on 2017/6/16 0016.
 */
public class MealSeriesDAOImpl implements MealSeriesDAO {
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List getMealSeries() {
        Session session = sessionFactory.getCurrentSession();
        Criteria c = session.createCriteria(Mealseries.class);
        return c.list();
    }
}
