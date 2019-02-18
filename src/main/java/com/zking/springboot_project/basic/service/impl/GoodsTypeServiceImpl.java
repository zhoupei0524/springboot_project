package com.zking.springboot_project.basic.service.impl;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.basic.mapper.GoodstypeMapper;
import com.zking.springboot_project.basic.model.Goodstype;
import com.zking.springboot_project.basic.service.IGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeServiceImpl implements IGoodsTypeService {

    @Autowired
    private GoodstypeMapper goodstypeMapper;

    @Override
    public List<Goodstype> queryListPage(Goodstype goodstype, PageBean pageBean) {
        return goodstypeMapper.queryListPage(goodstype);
    }
    @Override
    public List<Goodstype> queryList(Goodstype goodstype){
        return goodstypeMapper.queryListPage(goodstype);
    }

    @Override
    public int insert(Goodstype record) {
        Goodstype goodstype =  goodstypeMapper.querySing(record.getName());
        int a=0;
        if(goodstype==null){
            goodstypeMapper.insert(record);
            a=1;
        }
        return a;
    }

    @Override
    public int updateByPrimaryKey(Goodstype record) {
        Goodstype goodstype = goodstypeMapper.querySing(record.getName());
        boolean updateto=false;

        if(goodstype!=null){
            if(goodstype.getId()==record.getId()&&goodstype.getName().equals(record.getName())){
                updateto=true;
            }
        }
        int a=0;
        if(goodstype==null||updateto){
            goodstypeMapper.updateByPrimaryKey(record);
            a=1;
        }
        return  a;

    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return goodstypeMapper.deleteByPrimaryKey(id);
    }
}
