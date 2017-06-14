package com.eleme.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * orderdts pojo
 * Created by Administrator on 2017/6/14 0014.
 */
public class Orderdts implements Serializable {
    // Fields
    private Integer odid;
    private Meal meal;
    private Orders orders;
    private Double mealPrice;
    private Integer mealCount;

    // Constructors
    public Orderdts() {
    }

    public Orderdts(Meal meal, Orders orders, Double mealPrice,
                    Integer mealCount) {
        this.meal = meal;
        this.orders = orders;
        this.mealPrice = mealPrice;
        this.mealCount = mealCount;
    }

    public Integer getOdid() {
        return this.odid;
    }

    public void setOdid(Integer odid) {
        this.odid = odid;
    }

    public Meal getMeal() {
        return this.meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Orders getOrders() {
        return this.orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Double getMealPrice() {
        return this.mealPrice;
    }

    public void setMealPrice(Double mealPrice) {
        this.mealPrice = mealPrice;
    }

    public Integer getMealCount() {
        return this.mealCount;
    }

    public void setMealCount(Integer mealCount) {
        this.mealCount = mealCount;
    }
}
