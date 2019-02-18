package com.zking.springboot_project.basic.mapper;


import com.zking.springboot_project.basic.model.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodsMapper {
    //分页根据条件查询所有商品
    List<Map<String, Object>> queryGoodsPage(Goods goods);

    Goods querySingGood(String record);

    //增加商品
    int insert(Goods goods);

    //根据ID删除商品
    int deleteByPrimaryKey(Goods goods);

    //根据ID修改商品类型
    int updateGoodsById(Goods goods);

    //根据供应商id查询商品
    List<Goods> queryGoodsid(Goods goods);

    //根据商品id查询单价
    List<Goods> queryGoodsbyname(Goods goods);

    //下拉框
    List<Goods> querylist();

    /**
     * 根据商品id查询商品
     */
    Goods queryGoodsbynames(Goods goods);

    /**
     * 查询所有商品
     * @return
     */
    List<Goods> queryGood();
}