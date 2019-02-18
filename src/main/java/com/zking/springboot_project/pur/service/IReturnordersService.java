package com.zking.springboot_project.pur.service;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.pur.model.Rreturnorders;
import com.zking.springboot_project.vo.Ordervoreturn;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface IReturnordersService {

    /**
     * 模糊查询并分页采购退货订单
     * @param
     * @return
     */
    List<Map<String,Object>> querypurOrderPage(Ordervoreturn ordervo, PageBean pageBean);


    /**
     * 查询销售退货订单
     * @param
     * @return
     */
    List<Map<String,Object>> queryOrderLstPage(Ordervoreturn ordervo, PageBean pageBean);

    /**
     * 增加退货订单
     * @param
     * @return
     */
    int insert(String supplierid, String s, String userid);

    /**
     * 销售退货订单审核
     * @param record
     * @return
     */
    int updatecheck(Rreturnorders record, String userid);

    /**
     * 销售退货订单入库
     * @param record
     * @return
     */
    int updateender(Rreturnorders record, String userid);

    /**
     * 采购退货订单出库
     * @param record
     * @return
     */
    int updatByideout(Rreturnorders record);

}