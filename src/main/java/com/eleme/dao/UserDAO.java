package com.eleme.dao;

import com.eleme.pojo.Admin;
import com.eleme.pojo.Users;

import java.util.List;

/**
 * 用户 DAO 接口
 * Created by Administrator on 2017/7/9 0009.
 */
public interface UserDAO {
    // 用户登录验证
    public List search(Users condition);

    // 管理员登录验证
    public List search(Admin condition);

    // 添加用户
    public void addUsers(Users users);

    // 修改用户信息
    public void modifyUsers(Users users);
}
