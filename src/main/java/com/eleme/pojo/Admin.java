package com.eleme.pojo;

import java.io.Serializable;

/**
 * 管理员pojo类
 * Created by Administrator on 2017/6/14 0014.
 */
public class Admin implements Serializable {
    private int id;
    private String loginName;
    private String loginPwd;

    public Admin() {
    }

    public Admin(String loginName, String loginPwd) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

}
