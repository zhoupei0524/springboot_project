package com.zking.springboot_project.basic.mapper;

import com.zking.springboot_project.basic.model.Goodstype;
import com.zking.springboot_project.basic.service.impl.GoodsTypeServiceImpl;
import lombok.ToString;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface GoodstypeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Goodstype record);

    int insertSelective(Goodstype record);

    Goodstype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goodstype record);

    int updateByPrimaryKey(Goodstype record);

    List<Goodstype> queryListPage(Goodstype goodstype);

    Goodstype querySing(String name);


}