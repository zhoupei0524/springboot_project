package com.zking.springboot_project.pur.service;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.pur.model.Returnorderdetail;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
public interface IReturnorderdetailService {

    /**
     * 根据订单ID查询订单项
     * @return
     */
    List<Map<String,Object>> querybackByidPage(Returnorderdetail returnorderdetail, PageBean pageBean);

    /**
     * 增加退货订单项
     * @param record
     * @return
     */
    int insert(Returnorderdetail record);

    /**
     * 商品入库
     * @param record
     * @return
     */
    int updateByPrimaryKey(Returnorderdetail record);

    /**
     * 采购退货商品出库
     * @param record
     * @return
     */
    int updatebackout(Returnorderdetail record);
}