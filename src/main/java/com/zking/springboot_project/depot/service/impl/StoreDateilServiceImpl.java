package com.zking.springboot_project.depot.service.impl;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.depot.mapper.StoredetailMapper;
import com.zking.springboot_project.depot.model.Storedetail;
import com.zking.springboot_project.depot.service.IStoreDateilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StoreDateilServiceImpl implements IStoreDateilService {

    @Autowired
    private StoredetailMapper storedetailMapper;

    @Override
    public List<Map<String, Object>> queryStoredetaillistmapPage(Storedetail storedetail, PageBean pageBean) {
        return storedetailMapper.queryStoredetaillistmapPage(storedetail);
    }

    @Override
    public List<Map<String, Object>> queryStoredetaillistmap(Storedetail storedetail) {
        return storedetailMapper.queryStoredetaillistmapPage(storedetail);
    }
    @Override
    public int insert(Storedetail record) {
        return storedetailMapper.insert(record);
    }

    @Override
    public Storedetail selectBygoodsid(Integer id) {
        return storedetailMapper.selectBygoodsid(id);
    }

    @Override
    public int updateByPrimaryKey(Storedetail storedetail) {
        return storedetailMapper.updateByPrimaryKey(storedetail);
    }
}
