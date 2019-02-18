package com.zking.springboot_project.pur.service.impl;

import com.zking.springboot_project.basic.mapper.StoreMapper;
import com.zking.springboot_project.basic.mapper.StorewarningMapper;
import com.zking.springboot_project.basic.model.Store;
import com.zking.springboot_project.basic.model.Storewarning;
import com.zking.springboot_project.depot.mapper.StoredetailMapper;
import com.zking.springboot_project.depot.mapper.StoreoperMapper;
import com.zking.springboot_project.depot.model.Storedetail;
import com.zking.springboot_project.depot.model.Storeoper;
import com.zking.springboot_project.pur.mapper.OrderitemMapper;
import com.zking.springboot_project.pur.model.Orderitem;
import com.zking.springboot_project.pur.service.IOrderitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderitemServiceImpl implements IOrderitemService {

    @Autowired
    private OrderitemMapper orderitemMapper;
    @Autowired
    private StoreMapper storeMapper;     //仓库
    @Autowired
    private StoredetailMapper storedetailMapper;   //库存
    @Autowired
    private StoreoperMapper storeoperMapper;    //库存变动记录
    @Autowired
    private StorewarningMapper storewarningMapper;    //库存预警

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return orderitemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Orderitem record) {
        return orderitemMapper.insert(record);
    }

    @Override
    public Orderitem selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Map<String, Object>> queryitembyid(Orderitem orderitem) {
        return orderitemMapper.queryitembyid(orderitem);
    }

    //商品入库
    @Override
    public int updateByPrimaryKey(Orderitem record) {
        System.out.println(789);
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Store store = storeMapper.selectByPrimaryKey(record.getStoreid());//根据仓库id获取empid库管员
        System.out.println(store);
        record.setEndtime(timestamp);       //入库时间
        record.setEnder(store.getEmpid());  //库管员id
        record.setState("2");               //订单项状态
        System.out.println(record);
        //2.增加库存
         //2-1.根据商品id在库存表里查询库存数量
        int num=0;
        Storedetail s = storedetailMapper.selectBygoodsid(record.getGoodsid());
        System.out.println(s);
        if(null!=s) {         //如果库存表里有这个商品
            System.out.println(123);
            num=s.getNum();    //获取原有库存数量
            num+=record.getNum();    //库存总数量
            s.setNum(num);
            storedetailMapper.updateByPrimaryKey(s);   //修改库存数量
        }else{        //库存表里没有这个商品
            System.out.println(456);
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
        storeoper.setType("1");
        storeoperMapper.insert(storeoper);
        return orderitemMapper.updateByPrimaryKey(record);
    }

    //销售商品出库
    @Override
    public int updateByitemid(Orderitem record) {
        int a=0;
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Store store = storeMapper.selectByPrimaryKey(record.getStoreid());   //根据仓库id获取empid库管员
        Storedetail s = storedetailMapper.selectBygoodsid(record.getGoodsid());   //根据商品id获取库存数量

        int num=0;
        if(null!=s&&s.getNum()>record.getNum()) {      //如果数量足够
            // 1 增加商品出库记录
            record.setEndtime(timestamp);           //出库时间
            record.setEnder(store.getEmpid());      //库管员id
            record.setState("2");
            orderitemMapper.updateByPrimaryKey(record);
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
