package com.zking.springboot_project.depot.service.impl;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.depot.mapper.StoreoperMapper;
import com.zking.springboot_project.depot.service.IStoreoperService;
import com.zking.springboot_project.depot.vo.StoreoperVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StoreoperServiceImpl implements IStoreoperService {

    @Autowired
    private StoreoperMapper storeoperMapper;

    @Override
    public List<Map<String, Object>> queryStoreoperMapPage(StoreoperVo storeoperVo, PageBean pageBean) {
        return storeoperMapper.queryStoreoperMapPage(storeoperVo);
    }
}
