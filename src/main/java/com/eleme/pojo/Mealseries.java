package com.eleme.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 菜品种类pojo
 * Created by Administrator on 2017/6/14 0014.
 */
public class Mealseries implements Serializable {
    // Fields
    private Integer seriesId;
    private String seriesName;
    private Set meals = new HashSet(0);

    public Mealseries() {
    }

    public Mealseries(String seriesName, Set meals) {
        this.seriesName = seriesName;
        this.meals = meals;
    }

    public Integer getSeriesId() {
        return this.seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public String getSeriesName() {
        return this.seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public Set getMeals() {
        return this.meals;
    }

    public void setMeals(Set meals) {
        this.meals = meals;
    }
}
