package com.zking.springboot_project.basic.mapper;

import com.zking.springboot_project.basic.model.Store;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface StoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);

    List<Map<String,Object>> queryStorePage(Store store);

    Store selectByname(Store store);

    List<Store> querylist(Store store);


}