package com.zking.springboot_project.depot.service.impl;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.depot.mapper.InventoryMapper;
import com.zking.springboot_project.depot.model.Inventory;
import com.zking.springboot_project.depot.service.IInventoryService;
import com.zking.springboot_project.depot.vo.InventoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InventoryServiceImpl implements IInventoryService {

    @Autowired
    private InventoryMapper inventoryMapper;

    @Override
    public List<Map<String, Object>> queryInventoryMapPage(InventoryVo inventory, PageBean pageBean) {
        return inventoryMapper.queryInventoryMapPage(inventory);
    }

    @Override
    public int insert(Inventory record) {
        return inventoryMapper.insert(record);
    }

    @Override
    public int updateCheck(Inventory record) {
        return inventoryMapper.updateCheck(record);
    }
}
