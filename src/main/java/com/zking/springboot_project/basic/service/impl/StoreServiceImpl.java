package com.zking.springboot_project.basic.service.impl;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.basic.mapper.StoreMapper;
import com.zking.springboot_project.basic.model.Store;
import com.zking.springboot_project.basic.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StoreServiceImpl implements IStoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public List<Map<String, Object>> queryStorePage(Store store, PageBean pageBean) {
        return storeMapper.queryStorePage(store);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return storeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Store record) {
        Store store = storeMapper.selectByname(record);
        int a=0;
        if(store==null){//没有一样的或者是本身
            storeMapper.insert(record);
            a=1;
        }
        return a;
    }

    @Override
    public int updateStore(Store record) {
        Store store = storeMapper.selectByname(record);
        boolean updateto=false;
        if(store!=null){
            if(store.getId()==record.getId()&&store.getName().equals(record.getName())){
                updateto=true;
            }
        }
        int a=0;
        if(store==null||updateto){
            storeMapper.updateByPrimaryKeySelective(record);
            a=1;
        }
        return a;
    }

    @Override
    public List<Store> querylist(Store store) {
        return storeMapper.querylist(store);
    }
}
