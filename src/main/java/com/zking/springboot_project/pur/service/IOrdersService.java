package com.zking.springboot_project.pur.service;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.pur.model.Orders;
import com.zking.springboot_project.pur.vo.OrdersVo;
import com.zking.springboot_project.vo.Ordervo;

import java.util.List;
import java.util.Map;

public interface IOrdersService {

    /**
     * 删除订单
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 增加订单
     * @param
     * @return
     */
    int insert(String supplierid, String s, String hh);

    /**
     * 查询订单
     * @param
     * @return
     */
    List<Map<String,Object>> queryOrderLstPage(OrdersVo ordervo, PageBean pageBean);
    //销售订单查询
    List<Map<String,Object>> querysalelistPage(OrdersVo ordervo, PageBean pageBean);

    /**
     * 订单审核
     * @param record
     * @return
     */
    int updateByPrimaryKey(Orders record);

    /**
     * 订单确认
     * @param record
     * @return
     */
    int updateByorderid(Orders record);

    /**
     * 订单入库
     * @param record
     * @return
     */
    int updatByideput(Orders record, Integer ss);

    //根据年份查询这一年12季度 销售数额
    List<Map<String,Object>> queryOrdersList(String date, PageBean pageBean);

}