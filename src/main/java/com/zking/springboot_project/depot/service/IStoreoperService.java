package com.zking.springboot_project.depot.service;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.depot.vo.StoreoperVo;

import java.util.List;
import java.util.Map;


public interface IStoreoperService {

    List<Map<String,Object>> queryStoreoperMapPage(StoreoperVo storeoperVo, PageBean pageBean);

}
