package com.zking.springboot_project.pur.mapper;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.pur.model.Orders;
import com.zking.springboot_project.pur.vo.OrdersVo;
import com.zking.springboot_project.vo.Ordervo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrdersMapper {

    /*
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
    int insert(Orders orders);

    /**
     * 查询订单
     * @param
     * @return
     */
    List<Map<String,Object>> queryOrderLst(OrdersVo ordervo);

    //销售订单查询
    List<Map<String,Object>> querysalelist(OrdersVo ordervo);

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
    int updatByideput(Orders record);

    //根据年份查询这一年12季度 销售数额
    List<Map<String,Object>> queryOrdersList(@Param("dd") String ss);

}