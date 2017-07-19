package com.eleme.biz;

import com.eleme.pojo.Admin;
import com.eleme.pojo.Users;

import java.util.List;

/**
 * User Biz interface
 * Created by Administrator on 2017/7/9 0009.
 */
public interface UserBiz {
    // 用户登录验证
    public List login(Users condition);

    // 管理员登录验证
    public List login(Admin condition);

    // 添加用户
    public void addUsers(Users users);

    // 修改用户信息
    public void modifyUsers(Users users);
}
