package com.zking.springboot_project.pur.service.impl;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.basic.mapper.StoreMapper;
import com.zking.springboot_project.basic.mapper.StorewarningMapper;
import com.zking.springboot_project.basic.model.Store;
import com.zking.springboot_project.basic.model.Storewarning;
import com.zking.springboot_project.depot.mapper.StoredetailMapper;
import com.zking.springboot_project.depot.mapper.StoreoperMapper;
import com.zking.springboot_project.depot.model.Storedetail;
import com.zking.springboot_project.depot.model.Storeoper;
import com.zking.springboot_project.pur.mapper.ReturnorderdetailMapper;
import com.zking.springboot_project.pur.model.Returnorderdetail;
import com.zking.springboot_project.pur.service.IReturnorderdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Service
public class ReturnorderdetailServiceImpl implements IReturnorderdetailService {

    @Autowired
    private ReturnorderdetailMapper returnorderdetailMapper;
    @Autowired
    private StoreMapper storeMapper;     //仓库
    @Autowired
    private StoredetailMapper storedetailMapper;   //库存
    @Autowired
    private StoreoperMapper storeoperMapper;    //库存变动记录
    @Autowired
    private StorewarningMapper storewarningMapper;    //库存预警

    //根据订单id查询订单项
    @Override
    public List<Map<String, Object>> querybackByidPage(Returnorderdetail returnorderdetail, PageBean pageBean) {
        return returnorderdetailMapper.querybackByid(returnorderdetail);
    }

    @Override
    public int insert(Returnorderdetail record) {
        return returnorderdetailMapper.insert(record);
    }

    //商品退货入库
    @Override
    public int updateByPrimaryKey(Returnorderdetail record) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Store store = storeMapper.selectByPrimaryKey(record.getStoreid());//根据仓库id获取empid库管员
        record.setEndtime(timestamp);        //入库时间
        record.setEnder(store.getEmpid());   //库管员id 当前登录库管员
        record.setStart("2");               //订单项状态

        //2.增加库存
        //2-1.根据商品id在库存表里查询库存数量
        int num=0;
        Storedetail s = storedetailMapper.selectBygoodsid(record.getGoodsid());
        if(null!=s) {         //如果库存表里有这个商品
            num=s.getNum();    //获取原有库存数量
            num+=record.getNum();    //库存总数量
            s.setNum(num);
            storedetailMapper.updateByPrimaryKey(s);   //修改库存数量
        }else{        //库存表里没有这个商品
            Storedetail storedetail=new Storedetail();
            storedetail.setGoodid(record.getGoodsid());
            storedetail.setStoreid(record.getStoreid());
            storedetail.setNum(record.getNum());
            storedetailMapper.insert(s);     //增加一个库存
        }
        //3.增加一条库存变动记录
        Storeoper storeoper=new Storeoper();
        storeoper.setGoodsid(record.getGoodsid());
        storeoper.setEmpid(store.getEmpid());
        storeoper.setNum(record.getNum());
        storeoper.setOpertime(timestamp);
        storeoper.setStoreid(record.getStoreid());
        storeoper.setType("2");
        storeoperMapper.insert(storeoper);
        return returnorderdetailMapper.updateByPrimaryKey(record);
    }

    //  采购退货商品出库
    @Override
    public int updatebackout(Returnorderdetail record) {
        int a=0;
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Store store = storeMapper.selectByPrimaryKey(record.getStoreid());//根据仓库id获取empid库管员
        record.setEndtime(timestamp);        //入库时间
        record.setEnder(store.getEmpid());   //库管员id 当前登录库管员
        record.setStart("2");               //订单项状态

        //2.减少库存
        int num=0;
        //2-1.根据商品id在库存表里查询库存数量
        Storedetail s = storedetailMapper.selectBygoodsid(record.getGoodsid());
        if(null!=s&&s.getNum()>record.getNum()) {      //如果数量足够
            // 1 增加商品出库记录
            record.setEndtime(timestamp);           //出库时间
            record.setEnder(store.getEmpid());      //库管员id
            record.setStart("2");
            returnorderdetailMapper.updateByPrimaryKey(record);
            //2.减少库存
            num=s.getNum();           //获取原有库存数量
            num-=record.getNum();     //库存总数量
            s.setNum(num);
            storedetailMapper.updateByPrimaryKey(s);

            //3.增加一条库存变动记录
            Storeoper storeoper=new Storeoper();
            storeoper.setGoodsid(record.getGoodsid());
            storeoper.setEmpid(store.getEmpid());
            storeoper.setNum(record.getNum());
            storeoper.setOpertime(timestamp);
            storeoper.setStoreid(record.getStoreid());
            storeoper.setType("2");
            storeoperMapper.insert(storeoper);
            a=1;
        }else{      //数量不足
            //增加一条库存预警
            Storewarning storewarning=new Storewarning();
            storewarning.setGoodid(record.getGoodsid());
            storewarning.setGoodname(record.getGoodsname());
            storewarning.setNum(s.getNum());
            storewarning.setDropnum(record.getNum());
            storewarningMapper.insert(storewarning);
        }
        return a;
    }
}
