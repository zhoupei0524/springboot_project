package com.zking.springboot_project.pur.service;

import com.zking.springboot_project.pur.model.Shopcart;

import java.util.List;
import java.util.Map;

public interface IShopcartService {
    /**
     * 根据id删除购物车数据
     * @param cartid
     * @return
     */
    int deleteByPrimaryKey(Integer cartid);

    /**
     * 增加购物车
     * @param record
     * @return
     */
    int insert(Shopcart record);

    /**
     * 查询购物车
     * @return
     */
    List<Map<String,Object>> queryCartLst();

    /**
     * 根据商品id查询购物车
     * @param id
     * @return
     */
    Shopcart querygoodid(Integer id);

    /**
     * 根据商品id修改
     * @param shopcart
     * @return
     */
    int updategoodid(Shopcart shopcart);


}