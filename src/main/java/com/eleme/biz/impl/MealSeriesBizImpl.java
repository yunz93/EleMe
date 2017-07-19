package com.eleme.biz.impl;

import com.eleme.biz.MealSeriesBiz;
import com.eleme.dao.MealSeriesDAO;

import java.util.List;

/**
 * mealseries biz impl
 * Created by Administrator on 2017/6/16 0016.
 */
public class MealSeriesBizImpl implements MealSeriesBiz{
    MealSeriesDAO mealSeriesDAO;

    public void setMealSeriesDAO(MealSeriesDAO mealSeriesDAO) {
        this.mealSeriesDAO = mealSeriesDAO;
    }

    @Override
    public List getMealSeries() {
        return mealSeriesDAO.getMealSeries();
    }
}
