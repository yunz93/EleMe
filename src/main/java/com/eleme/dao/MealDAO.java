package com.eleme.dao;

import com.eleme.pojo.Meal;

import java.util.List;

/**
 * 菜品数据访问接口
 * Created by Administrator on 2017/6/15 0015.
 */
public interface MealDAO {
    // 获取制定页显示的菜品列表
    public List getAllMeal(int page);

    // 统计所有菜品总数
    public Integer getCountOfAllMeal();

    // 根据查询条件,获取指定页显示的餐品列表
    public List getMealByCondition (Meal condition, int page);

    // 统计符合查询条件的餐品总数
    public Integer getCountOfMeal (Meal condition);

    //获取指定菜系和指定页显示的餐品列表
    public List getMealBySeries(int mealSeries,int page);


    //根据编号加载菜品
    public Meal getMealByMealId(int mealId);

    //添加餐品
    public void addMeal(Meal meal);

    //删除餐品
    public void deleteMeal(Meal meal);

    //修改餐品对象
    public void updateMeal(Meal meal);
}
