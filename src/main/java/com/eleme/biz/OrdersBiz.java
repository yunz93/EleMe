package com.eleme.biz;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18 0018.
 */
public interface OrdersBiz {
    public List getOrdersByUserId(int userId);

    // 删除指定编号的订单
    public void deleteOrdersByOid(int oid);
}
