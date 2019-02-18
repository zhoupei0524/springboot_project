package com.zking.springboot_project.basic.service;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.basic.model.Goodstype;

import java.util.List;

public interface IGoodsTypeService {
    //分页查询
    List<Goodstype> queryListPage(Goodstype goodstype, PageBean pageBean);

    //查询不分页
    List<Goodstype> queryList(Goodstype goodstype);

    //增加商品类型
    int insert(Goodstype record);

    //修改商品类型
    int updateByPrimaryKey(Goodstype record);

    //删除商品类型
    int deleteByPrimaryKey(Integer id);

}
