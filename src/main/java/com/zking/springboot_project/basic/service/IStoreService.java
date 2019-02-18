package com.zking.springboot_project.basic.service;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.basic.model.Store;

import java.util.List;
import java.util.Map;

public interface IStoreService {

    List<Map<String,Object>> queryStorePage(Store store, PageBean pageBean);

    int deleteByPrimaryKey(Integer id);

    int insert(Store record);

    int updateStore(Store record);

    List<Store> querylist(Store store);

}
