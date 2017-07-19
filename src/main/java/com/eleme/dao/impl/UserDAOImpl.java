package com.eleme.dao.impl;

import com.eleme.dao.UserDAO;
import com.eleme.pojo.Admin;
import com.eleme.pojo.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import java.util.List;

/**
 * User DAO Impl
 * Created by Administrator on 2017/7/9 0009.
 */
public class UserDAOImpl implements UserDAO {
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // 用户登录验证
    @Override
    public List search(Users condition) {
        List list = null;
        Session session = sessionFactory.getCurrentSession();
        Criteria c = session.createCriteria(Users.class);
        // 使用 Example 工具类创建示例对象
        Example example = Example.create(condition);
        // 为 Criteria 对象指定示例对象 example 作为查询条件
        c.add(example);
        // 执行查询
        list = c.list();
        return list;
    }

    @Override
    public List search(Admin condition) {
        List list = null;
        Session session = sessionFactory.getCurrentSession();
        Criteria c = session.createCriteria(Admin.class);
        // 使用 Example 工具类创建示例对象
        Example example = Example.create(condition);
        // 为 Criteria 对象指定示例对象 example 作为查询条件
        c.add(example);
        // 执行查询
        list = c.list();
        return list;
    }

    // 添加用户
    @Override
    public void addUsers(Users users) {
        Session session=sessionFactory.getCurrentSession();
        session.save(users);
    }

    // 修改用户信息
    @Override
    public void modifyUsers(Users users) {
        Session session=sessionFactory.getCurrentSession();
        session.update(users);
    }
}
