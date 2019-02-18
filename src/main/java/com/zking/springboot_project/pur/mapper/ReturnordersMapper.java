package com.zking.springboot_project.pur.mapper;

import com.zking.springboot_project.pur.model.Rreturnorders;
import com.zking.springboot_project.vo.Ordervoreturn;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReturnordersMapper {

    /**
     * 模糊查询并分页采购退货订单
     * @param
     * @return
     */
    List<Map<String,Object>> querypurOrderPage(Ordervoreturn ordervo);

    /**
     * 模糊查询并分页销售退货订单
     * @param
     * @return
     */
    List<Map<String,Object>> queryOrderLstPage(Ordervoreturn ordervo);

    /**
     * 增加退货订单
     * @param
     * @return
     */
    int insert(Rreturnorders rreturnorders);

    /*
     * 删除退货订单
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 采购、销售退货订单审核
     * @param record
     * @return
     */
    int updatecheck(Rreturnorders record);

    /**
     * 采购退货订单出库
     * @param record
     * @return
     */
    int updatByideout(Rreturnorders record);

    /**
     * 销售退货订单入库
     * @param record
     * @return
     */
    int updateender(Rreturnorders record);



}