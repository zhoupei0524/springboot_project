package com.zking.springboot_project.pur.mapper;

import com.zking.springboot_project.pur.model.Orderitem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderitemMapper {

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
     * 订单项入库
     * @param record
     * @return
     */
    int updateByPrimaryKey(Orderitem record);

    /**
     * 根据订单ID查询订单项
     * @param orderitem
     * @return
     */
    List<Map<String, Object>> queryitembyid(Orderitem orderitem);


}