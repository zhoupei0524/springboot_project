package com.zking.springboot_project.basic.mapper;

import com.zking.springboot_project.basic.model.Storewarning;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface StorewarningMapper {
    int deleteByPrimaryKey(Integer id);

    /**
     * 增加库存预警
     * @param record
     * @return
     */
    int insert(Storewarning record);

    int insertSelective(Storewarning record);

    Storewarning selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Storewarning record);

    int updateByPrimaryKey(Storewarning record);


    List<Storewarning> queryStorewarningListPage(Storewarning storewarning);
}