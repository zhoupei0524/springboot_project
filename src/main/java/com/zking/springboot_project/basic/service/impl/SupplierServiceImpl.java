package com.zking.springboot_project.basic.service.impl;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.basic.mapper.SupplierMapper;
import com.zking.springboot_project.basic.model.Supplier;
import com.zking.springboot_project.basic.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements ISupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public List<Supplier> querySupplierPage(Supplier record, PageBean pageBean) {
        return supplierMapper.querySupplierPage(record);
    }

    @Override
    public int updateSupplierByID(Supplier record) {
        Supplier supplier = supplierMapper.selectByNameKey(record.getName());
        boolean updateto=false;
        if(supplier!=null){
            if(supplier.getId()==record.getId()&&supplier.getName().equals(record.getName())){
                updateto=true;
            }
        }
        int a=0;
        if(supplier==null||updateto){//没有一样的或者是本身
            supplierMapper.updateSupplierByID(record);
            a=1;
        }
        return a;
    }

    @Override
    public int deleteSupplierByID(Integer id) {
        return supplierMapper.deleteSupplierByID(id);
    }

    @Override
    public int insert(Supplier record) {
        Supplier supplier = supplierMapper.selectByNameKey(record.getName());
        int a=0;
        if(supplier==null){
            supplierMapper.insert(record);
            a=1;
        }
        return a;
    }

    @Override
    public List<Supplier> querySupplier(Supplier record) {
        return supplierMapper.querySupplierPage(record);
    }


    @Override
    public List<Supplier> querySupplierlst(Supplier record) {
        return supplierMapper.querySupplierlst(record);
    }

    @Override
    public List<Supplier> querySupplierclient() {
        return supplierMapper.querySupplierclient();
    }
}
