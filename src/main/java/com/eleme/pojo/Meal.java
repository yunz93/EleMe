package com.eleme.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Meal pojo
 * Created by Administrator on 2017/6/14 0014.
 */
public class Meal implements Serializable {
    private Integer mealId;
    private Mealseries mealseries;
    private String mealName;
    private String mealSummarize;
    private String mealDescription;
    private Double mealPrice;
    private String mealImage;
    private Set orderdtses = new HashSet(0);

    // Constructors
    public Meal() {
    }

    public Meal(Mealseries mealseries, String mealName, String mealSummarize,
                String mealDescription, Double mealPrice, String mealImage,
                Set orderdtses) {
        this.mealseries = mealseries;
        this.mealName = mealName;
        this.mealSummarize = mealSummarize;
        this.mealDescription = mealDescription;
        this.mealPrice = mealPrice;
        this.mealImage = mealImage;
        this.orderdtses = orderdtses;
    }

    public Integer getMealId() {
        return this.mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public Mealseries getMealseries() {
        return this.mealseries;
    }

    public void setMealseries(Mealseries mealseries) {
        this.mealseries = mealseries;
    }

    public String getMealName() {
        return this.mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealSummarize() {
        return this.mealSummarize;
    }

    public void setMealSummarize(String mealSummarize) {
        this.mealSummarize = mealSummarize;
    }

    public String getMealDescription() {
        return this.mealDescription;
    }

    public void setMealDescription(String mealDescription) {
        this.mealDescription = mealDescription;
    }

    public Double getMealPrice() {
        return this.mealPrice;
    }

    public void setMealPrice(Double mealPrice) {
        this.mealPrice = mealPrice;
    }

    public String getMealImage() {
        return this.mealImage;
    }

    public void setMealImage(String mealImage) {
        this.mealImage = mealImage;
    }

    public Set getOrderdtses() {
        return this.orderdtses;
    }

    public void setOrderdtses(Set orderdtses) {
        this.orderdtses = orderdtses;
    }

}
