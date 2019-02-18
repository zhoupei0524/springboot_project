package com.zking.springboot_project.depot.mapper;

import com.zking.springboot_project.depot.model.Inventory;
import com.zking.springboot_project.depot.vo.InventoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface InventoryMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Inventory record);

    int insertSelective(Inventory record);

    Inventory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Inventory record);

    int updateCheck(Inventory record);


    List<Map<String,Object>> queryInventoryMapPage(InventoryVo inventory);


    int addInventory(Inventory inventory);







}