package com.eleme.biz;

import com.eleme.pojo.Meal;
import com.eleme.pojo.Pager;

import java.util.List;

/**
 * Meal biz interface
 * Created by Administrator on 2017/6/16 0016.
 */
public interface MealBiz {
    // obtain meal list display in specified page
    public List getAllMeal(int page);

    // obtain
    public Pager getPagerOfMeal();

    // obtain meal list display in specified page by condition
    public List getMealByCondition(Meal condition, int page);

    // 统计符合查询条件的餐品数量,初始化分页类Pager对象，设置perPageRows和rowCount属性
    public Pager getPagerOfMeal(Meal condition);

    // 获取指定菜系和指定页显示的餐品列表
    //public List getMealBySeries(int mealSeries,int page);

    //根据编号加载菜品
    public Meal getMealByMealId(int mealId);

    //添加餐品
    public void addMeal(Meal meal);

    //删除指定编号菜品
    public void deleteMeal(int mealId);

    //修改餐品
    public void updateMeal(Meal meal);
}
