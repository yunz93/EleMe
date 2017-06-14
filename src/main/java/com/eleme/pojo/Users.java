package com.eleme.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户pojo类
 * Created by Administrator on 2017/6/14 0014.
 */
public class Users implements Serializable {
    private int id;
    private String loginName;
    private String loginPwd;
    private String trueName;
    private String email;
    private String phone;
    private String address;
    private Set orderses = new HashSet(0);

    public Users() {
    }

    /** full constructor */
    public Users(String loginName, String loginPwd, String trueName,
                 String email, String phone, String address, Set orderses) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.trueName = trueName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.orderses = orderses;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return this.loginName;
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

    public String getTrueName() {
        return this.trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set getOrderses() {
        return orderses;
    }

    public void setOrderses(Set orderses) {
        this.orderses = orderses;
    }
}
