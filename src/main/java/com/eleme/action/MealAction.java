package com.eleme.action;

import com.eleme.biz.MealBiz;
import com.eleme.biz.MealSeriesBiz;
import com.eleme.pojo.Meal;
import com.eleme.pojo.Pager;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;

import java.util.List;
import java.util.Map;

/**
 * meal action
 * Created by Administrator on 2017/6/16 0016.
 */
public class MealAction extends ActionSupport implements RequestAware{
    private Meal meal;

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    MealBiz mealBiz;

    public void setMealBiz(MealBiz mealBiz) {
        this.mealBiz = mealBiz;
    }

    MealSeriesBiz mealSeriesBiz;

    public void setMealSeriesBiz(MealSeriesBiz mealSeriesBiz) {
        this.mealSeriesBiz = mealSeriesBiz;
    }

    // Paging entity class
    Pager pager;

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    Map<String, Object> request;

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    // Obtain meal items that meet the conditon and in specified page
    // then return index.jsp
    public String toShowMeal() throws Exception {
        int curPage = 1;
        if (pager != null)
            // obtain page to be display
            curPage = pager.getCurPage();
        List mealList = null;

        if (meal != null) {
            // meal is not null ,means condition exists
            mealList = mealBiz.getMealByCondition(meal, curPage);
            pager = mealBiz.getPagerOfMeal(meal);

            if ((meal.getMealseries() != null)
                    && (meal.getMealseries().getSeriesId() != null)) {
                request.put("seriesId", new Integer(meal.getMealseries().getSeriesId()));
            }
            if ((meal.getMealName() != null) && !(meal.getMealName().equals("")))
                request.put("mealName", meal.getMealName());
        } else {
            // meal is not null, means no condition
            // now obtain meal list by page num
            mealList = mealBiz.getAllMeal(curPage);
            pager = mealBiz.getPagerOfMeal();
        }

        pager.setCurPage(curPage);
        request.put("mealList", mealList);
        List mealSeriesList = mealSeriesBiz.getMealSeries();
        request.put("mealSeriesList", mealSeriesList);
        return "toShowMeal";
    }


}
