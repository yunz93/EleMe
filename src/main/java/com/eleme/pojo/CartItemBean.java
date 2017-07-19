package com.eleme.pojo;

import java.io.Serializable;

/**
 * 购物车 pojo
 * Created by Administrator on 2017/7/9 0009.
 */
public class CartItemBean implements Serializable {
    private Meal meal;
    private int quantity;

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quntity) {
        this.quantity = quntity;
    }

    public CartItemBean(Meal meal, int quntity) {
        this.meal = meal;
        this.quantity = quntity;
    }
}
