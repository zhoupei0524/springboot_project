package com.zking.springboot_project.depot.mapper;

import com.zking.springboot_project.depot.model.Storeoper;
import com.zking.springboot_project.depot.vo.StoreoperVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StoreoperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Storeoper record);

    int insertSelective(Storeoper record);

    Storeoper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Storeoper record);

    int updateByPrimaryKey(Storeoper record);

    List<Map<String,Object>> queryStoreoperMapPage(StoreoperVo storeoperVo);
}