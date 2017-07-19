package com.eleme.dao;

import com.eleme.pojo.Orderdts;

import java.util.List;

/**
 * 订单子表（明细）DAO INTERFACE
 * Created by Administrator on 2017/7/18 0018.
 */
public interface OrderDtsDAO {
    // 生成订单明细表
    public void addOrderDts(Orderdts dts);

    // 根据订单主表编号获取订单明细列表
    public List getOrderDtsByOid(int oid);
}
