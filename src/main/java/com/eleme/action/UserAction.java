package com.eleme.action;

import com.eleme.biz.UserBiz;
import com.eleme.dao.UserDAO;
import com.eleme.pojo.Admin;
import com.eleme.pojo.Users;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

/**
 * UserAction
 * 处理用户和管理员登录
 * Created by Administrator on 2017/7/9 0009.
 */
public class UserAction extends ActionSupport implements RequestAware, SessionAware{
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String loginName;
    private String loginPwd;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    UserBiz userBiz;

    public void setUserBiz(UserBiz userBiz) {
        this.userBiz = userBiz;
    }

    // 登录验证
    public String validateLogin() throws Exception {
        List list;

        // 用户登录验证
        if ("userlogin".equals(type)) {
            Users condition = new Users();
            condition.setLoginName(loginName);
            condition.setLoginPwd(loginPwd);
            list = userBiz.login(condition);

            if (list.size() > 0) {
                session.put("user", list.get(0));
            }
        }

        // 管理员登录验证
        if ("adminlogin".equals(type)) {
            Admin condition = new Admin();
            condition.setLoginName(loginName);
            condition.setLoginPwd(loginPwd);
            list = userBiz.login(condition);

            if (list.size() > 0) {
                session.put("admin", list.get(0));
            }
        }
        return "toIndex";
    }

    //封装注册表单参数
    private  Users user;
    public Users getUser() {
        return user;
    }
    public void setUser(Users user) {
        this.user = user;
    }

    //用户注册
    public String register() throws Exception {
        userBiz.addUsers(user);
        return "toIndex";
    }

    //修改个人信息
    public String modifyUsers() throws Exception {
        userBiz.modifyUsers(user);
        return "toIndex";
    }

    //用户注销
    public String logOut() throws Exception {
        if("userlogout".equals(type)){
            session.remove("user");
        }
        if("adminlogout".equals(type)){
            session.remove("admin");
        }
        return "toIndex";
    }

    Map<String, Object> request;
    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    Map<String, Object> session;
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
