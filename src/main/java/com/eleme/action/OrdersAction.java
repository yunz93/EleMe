package com.eleme.action;

import com.eleme.biz.OrderDtsBiz;
import com.eleme.biz.OrdersBiz;
import com.eleme.pojo.CartItemBean;
import com.eleme.pojo.Orderdts;
import com.eleme.pojo.Orders;
import com.eleme.pojo.Users;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.*;

/**
 * 订单操作
 * Created by Administrator on 2017/7/18 0018.
 */
public class OrdersAction extends ActionSupport implements RequestAware, SessionAware {
    OrderDtsBiz orderDtsBiz;
    OrdersBiz ordersBiz;
    int oid;

    public void setOrderDtsBiz(OrderDtsBiz orderDtsBiz) {
        this.orderDtsBiz = orderDtsBiz;
    }

    public void setOrdersBiz(OrdersBiz ordersBiz) {
        this.ordersBiz = ordersBiz;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    // 处理生成订单请求
    public String addOrders() throws Exception {
        Orders orders = new Orders();
        orders.setOrderState("未处理");
        orders.setOrderTime(new Date());
        Users user = (Users)session.get("user");
        orders.setUsers(user);
        orders.setOrderPrice((Double)session.get("sumPrice"));
        Map cart = (HashMap)session.get("cart");
        Iterator iter = cart.keySet().iterator();

        while (iter.hasNext()) {
            Object key = iter.next();
            CartItemBean cartItem = (CartItemBean)cart.get(key);
            Orderdts orderdts = new Orderdts();
            orderdts.setMeal(cartItem.getMeal());
            orderdts.setMealCount(cartItem.getQuantity());
            orderdts.setMealPrice(cartItem.getMeal().getMealPrice());
            orderdts.setOrders(orders);
            orderDtsBiz.addOrderDts(orderdts);
        }
        session.remove("cart");
        return "show";
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

    // 获取指定用户的订单列表
    public String toMyOrders() throws Exception {
        Users user = (Users)session.get("user");
        List myOrdersList = ordersBiz.getOrdersByUserId(user.getId());
        request.put("myOrdersList", myOrdersList);
        return "myorders";
    }

    // 根据订单主表编号获取订单明细列表
    public String toOrdersDetails() throws Exception {
        List ordersDtsList = orderDtsBiz.getOrderDtsByOid(oid);
        request.put("ordersDtsList", ordersDtsList);
        return "toOrdersDetails";
    }

    // 删除指定编号的订单
    public String deleteOrders() throws Exception {
        ordersBiz.deleteOrdersByOid(oid);
        return "toMyOrders";
    }
}
