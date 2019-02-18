package com.zking.springboot_project.depot.service;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.depot.model.Inventory;
import com.zking.springboot_project.depot.vo.InventoryVo;

import java.util.List;
import java.util.Map;

public interface IInventoryService {
    List<Map<String,Object>> queryInventoryMapPage(InventoryVo inventory, PageBean pageBean);

    int insert(Inventory record);

    int updateCheck(Inventory record);

}
