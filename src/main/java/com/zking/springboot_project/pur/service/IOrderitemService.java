package com.zking.springboot_project.pur.service;

import com.zking.springboot_project.pur.model.Orderitem;
import com.zking.springboot_project.pur.model.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface IOrderitemService {

    /**
     * 删除订单项
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 增加订单项
     * @param record
     * @return
     */
    int insert(Orderitem record);

    Orderitem selectByPrimaryKey(Integer id);

    /**
     * 根据订单ID查询订单项
     * @param orderitem
     * @return
     */
     List<Map<String, Object>> queryitembyid(Orderitem orderitem);

    /**
     * 订单项入库
     * @param record
     * @return
     */
    int updateByPrimaryKey(Orderitem record);

    /**
     * 订单项出库
     * @param record
     * @return
     */
    int updateByitemid(Orderitem record);
}