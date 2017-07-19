package com.eleme.biz.impl;

import com.eleme.biz.UserBiz;
import com.eleme.dao.UserDAO;
import com.eleme.pojo.Admin;
import com.eleme.pojo.Users;

import java.util.List;

/**
 * Created by Administrator on 2017/7/9 0009.
 */
public class UserBizImpl implements UserBiz {
    UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List login(Users condition) {
        return userDAO.search(condition);
    }

    @Override
    public List login(Admin condition) {
        return userDAO.search(condition);
    }

    @Override
    public void addUsers(Users users) {
        userDAO.addUsers(users);
    }

    @Override
    public void modifyUsers(Users users) {
        userDAO.modifyUsers(users);
    }
}
