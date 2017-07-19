package com.eleme.action;

import com.eleme.biz.MealBiz;
import com.eleme.biz.MealSeriesBiz;
import com.eleme.pojo.CartItemBean;
import com.eleme.pojo.Meal;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.HashMap;
import java.util.Map;

/**
 * 购物车 action
 * Created by Administrator on 2017/7/9 0009.
 */
public class CartAction extends ActionSupport implements SessionAware {
    private Integer mealId;

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    MealBiz mealBiz;

    public void setMealBiz(MealBiz mealBiz) {
        this.mealBiz = mealBiz;
    }

    MealSeriesBiz mealSeriesBiz;

    public void setMealSeriesBiz(MealSeriesBiz mealSeriesBiz) {
        this.mealSeriesBiz = mealSeriesBiz;
    }

    Map<String, Object> session;

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    // 将餐品添加到购物车
    public String addToShopcart() throws Exception {
        Map cart = (Map)session.get("cart");
        Meal meal = mealBiz.getMealByMealId(mealId);
        // 如果不存在购物车，创建购物车
        if (cart == null) {
            cart = new HashMap();
            session.put("cart", cart);
        }
        // 如果存在购物车，判断餐品是否在购物车中
        CartItemBean cartItem = (CartItemBean)cart.get(meal.getMealId());
        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        } else {
            cart.put(meal.getMealId(), new CartItemBean(meal, 1));
        }

        return "shopCart";
    }

    // 更改购物车中餐品的数量
    public String updateSelectedQuantity() throws Exception {
        Map cart = (Map)session.get("cart");
        CartItemBean cartItem = (CartItemBean)cart.get(mealId);
        cartItem.setQuantity(quantity);
        return "shopCart";
    }

    // 删除购物车中的餐品
    public String deleteSelectedOrders() throws Exception {
        Map cart = (Map)session.get("cart");
        cart.remove(mealId);
        return "shopCart";
    }

    // 清空购物车
    public String clearCart() throws Exception {
        Map cart = (Map)session.get("cart");
        cart.clear();
        return "shopCart";
    }
}
