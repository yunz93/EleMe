package com.eleme.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * order pojo
 * Created by Administrator on 2017/6/14 0014.
 */
public class Orders {
    // Fields
    private Integer oid;
    private Users users;
    private Date orderTime;
    private String orderState;
    private Double orderPrice;
    private Set orderdtses = new HashSet(0);

    // Constructors
    public Orders() {
    }

    public Orders(Users users, Date orderTime, String orderState,
                  Set orderdtses, Double orderPrice) {
        this.users = users;
        this.orderTime = orderTime;
        this.orderState = orderState;
        this.orderdtses = orderdtses;
        this.orderPrice = orderPrice;
    }

    public Integer getOid() {
        return this.oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Date getOrderTime() {
        return this.orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderState() {
        return this.orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Set getOrderdtses() {
        return this.orderdtses;
    }

    public void setOrderdtses(Set orderdtses) {
        this.orderdtses = orderdtses;
    }
}
