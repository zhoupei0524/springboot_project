package com.zking.springboot_project.basic.service;

import com.github.pagehelper.Page;
import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.basic.model.Storewarning;

import java.util.List;


public interface IStorewarningService {

    /**
     * 增加库存预警
     * @param record
     * @return
     */
    int insert(Storewarning record);


    List<Storewarning> queryStorewarningListPage(Storewarning storewarning, PageBean pageBean);

}