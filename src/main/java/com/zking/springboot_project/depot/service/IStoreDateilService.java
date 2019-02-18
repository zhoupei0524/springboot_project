package com.zking.springboot_project.depot.service;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.depot.model.Storedetail;

import java.util.List;
import java.util.Map;

public interface IStoreDateilService {
    List<Map<String,Object>> queryStoredetaillistmapPage(Storedetail storedetail, PageBean pageBean);

    List<Map<String,Object>> queryStoredetaillistmap(Storedetail storedetail);

    /**
     * 增加库存
     * @param record
     * @return
     */
    int insert(Storedetail record);

    /**
     * 根据商品id查询库存
     * @param id
     * @return
     */
    Storedetail selectBygoodsid(Integer id);

    /**
     * 根据商品id修改数量
     * @param storedetail
     * @return
     */
    int updateByPrimaryKey(Storedetail storedetail);
}
