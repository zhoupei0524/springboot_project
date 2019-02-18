package com.zking.springboot_project.depot.mapper;

import com.zking.springboot_project.depot.model.Storedetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Mapper
public interface StoredetailMapper {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Storedetail record);

    Storedetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Storedetail record);

    List<Map<String,Object>> queryStoredetaillistmapPage(Storedetail storedetail);


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