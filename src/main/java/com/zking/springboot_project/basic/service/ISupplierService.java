package com.zking.springboot_project.basic.service;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.basic.model.Supplier;

import java.util.List;

public interface ISupplierService {

    List<Supplier> querySupplierPage(Supplier record, PageBean pageBean);

    int updateSupplierByID(Supplier record);

    int deleteSupplierByID(Integer id);

    int insert(Supplier record);

    List<Supplier> querySupplier(Supplier record);

    /**
     * 查询所有供应商
     * @return
     */
    List<Supplier> querySupplierlst(Supplier record);

    List<Supplier> querySupplierclient();

}
