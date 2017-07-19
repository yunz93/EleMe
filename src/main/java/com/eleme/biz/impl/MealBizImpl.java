package com.eleme.biz.impl;

import com.eleme.biz.MealBiz;
import com.eleme.dao.MealDAO;
import com.eleme.pojo.Meal;
import com.eleme.pojo.Pager;

import java.util.List;

/**
 * meal biz implementation class
 * Created by Administrator on 2017/6/16 0016.
 */
public class MealBizImpl implements MealBiz {
    MealDAO mealDAO;

    public void setMealDAO(MealDAO mealDAO) {
        this.mealDAO = mealDAO;
    }

    @Override
    public List getAllMeal(int page) {
        return mealDAO.getAllMeal(page);
    }

    @Override
    public Pager getPagerOfMeal() {
        // get count of all meal
        int count = mealDAO.getCountOfAllMeal();
        // define object by using pager
        Pager pager = new Pager();
        // set perPageRows, rowCount
        pager.setPerPageRows(6);
        pager.setRowCount(count);

        return pager;
    }

    @Override
    public List getMealByCondition(Meal condition, int page) {
        return mealDAO.getMealByCondition(condition, page);
    }

    @Override
    public Pager getPagerOfMeal(Meal condition) {
        int count = mealDAO.getCountOfMeal(condition);
        Pager pager = new Pager();
        pager.setPerPageRows(6);
        pager.setRowCount(count);

        return pager;
    }

    @Override
    public Meal getMealByMealId(int mealId) {
        return mealDAO.getMealByMealId(mealId);
    }

    //添加餐品
    @Override
    public void addMeal(Meal meal) {
        mealDAO.addMeal(meal);
    }

    //删除指定编号菜品
    @Override
    public void deleteMeal(int mealId) {
        Meal meal=mealDAO.getMealByMealId(mealId);
        mealDAO.deleteMeal(meal);
    }

    //修改餐品
    @Override
    public void updateMeal(Meal meal) {
        mealDAO.updateMeal(meal);
    }
}
