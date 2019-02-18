package com.zking.springboot_project.basic.mapper;

import com.zking.springboot_project.basic.model.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface SupplierMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByNameKey(String name);

    int updateSupplierByID(Supplier record);

    int updateByPrimaryKey(Supplier record);

    //供应商查询 type=1
    List<Supplier> querySupplierPage(Supplier record);

    int deleteSupplierByID(Integer id);

    /**
     * 查询所有供应商
     * @return
     */
    List<Supplier> querySupplierlst(Supplier record);

    /**
     * 查询所有客户
     * @return
     */
    List<Supplier> querySupplierclient();










}