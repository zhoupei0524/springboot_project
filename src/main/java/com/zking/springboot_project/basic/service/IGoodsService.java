package com.zking.springboot_project.basic.service;


import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.basic.model.Goods;

import java.util.List;
import java.util.Map;

public interface IGoodsService {

    List<Map<String,Object>> queryGoodsPage(Goods goods, PageBean pageBean);

    int insert(Goods goods);

    int deleteByPrimaryKey(Goods goods);

    int updateGoodsById(Goods goods);

    /**
     * 根据供应商id查询商品
     */
    List<Goods> queryGoodsid(Goods goods);

    /**
     * 根据商品name查询单价
     */
    List<Goods> queryGoodsbyname(Goods goods);

    List<Goods> querylist();

    List<Goods> queryGood();


}