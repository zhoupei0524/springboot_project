package com.zking.springboot_project.basic.service.impl;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.basic.mapper.StorewarningMapper;
import com.zking.springboot_project.basic.model.Storewarning;
import com.zking.springboot_project.basic.service.IStorewarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorewarningServiceImpl implements IStorewarningService {

    @Autowired
    private StorewarningMapper storewarningMapper;

    @Override
    public int insert(Storewarning record) {
        return storewarningMapper.insert(record);
    }


    @Override
    public List<Storewarning> queryStorewarningListPage(Storewarning storewarning, PageBean pageBean) {
        return storewarningMapper.queryStorewarningListPage(storewarning);
    }
}
