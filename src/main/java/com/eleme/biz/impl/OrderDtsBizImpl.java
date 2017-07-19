package com.eleme.biz.impl;

import com.eleme.biz.OrderDtsBiz;
import com.eleme.dao.OrderDtsDAO;
import com.eleme.pojo.Orderdts;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18 0018.
 */
public class OrderDtsBizImpl implements OrderDtsBiz {
    OrderDtsDAO orderDtsDAO;

    public void setOrderDtsDAO(OrderDtsDAO orderDtsDAO) {
        this.orderDtsDAO = orderDtsDAO;
    }

    @Override
    public void addOrderDts(Orderdts dts) {
        orderDtsDAO.addOrderDts(dts);
    }

    @Override
    public List getOrderDtsByOid(int oid) {
        return orderDtsDAO.getOrderDtsByOid(oid);
    }
}
