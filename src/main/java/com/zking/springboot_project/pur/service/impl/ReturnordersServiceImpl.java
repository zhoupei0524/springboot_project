package com.zking.springboot_project.pur.service.impl;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.depot.mapper.StoredetailMapper;
import com.zking.springboot_project.depot.model.Storedetail;
import com.zking.springboot_project.pur.mapper.ReturnorderdetailMapper;
import com.zking.springboot_project.pur.mapper.ReturnordersMapper;
import com.zking.springboot_project.pur.mapper.ShopcartMapper;
import com.zking.springboot_project.pur.model.Returnorderdetail;
import com.zking.springboot_project.pur.model.Rreturnorders;
import com.zking.springboot_project.pur.model.Shopcart;
import com.zking.springboot_project.pur.service.IReturnordersService;
import com.zking.springboot_project.vo.Ordervoreturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Service
public class ReturnordersServiceImpl implements IReturnordersService {

    @Autowired
    private ReturnordersMapper returnordersMapper;
    @Autowired
    private ReturnorderdetailMapper returnorderdetailMapper;
    @Autowired
    private ShopcartMapper shopcartMapper;
    @Autowired
    private StoredetailMapper storedetailMapper;

    Date date = new Date();
    Timestamp timestamp = new Timestamp(date.getTime());

    //增加退货订单
    @Override
    public int insert(String s,String supplierid,String userid) {
        int a= (int) ((Math.random()*9+1)*100000000);//运单号
        int b= (int) ((Math.random()*9+1)*100000);    //订单id

        //1.点提交订单时 获取购物车里的商品
        List<Map<String, Object>> cartlst = shopcartMapper.queryCartLst();

        //2.增加订单项
        Returnorderdetail returnorderdetail;
        Storedetail storedetail;
        Float sum=0f;   //总金额
        for (Map<String, Object> map : cartlst) {
            returnorderdetail=new Returnorderdetail();
            sum +=(Float) map.get("subtotal");

            returnorderdetail.setGoodsid((Integer) map.get("goodid"));
            returnorderdetail.setGoodsname((String) map.get("goodname"));
            returnorderdetail.setPrice((Float)map.get("unitprice"));
            returnorderdetail.setNum((Integer) map.get("num"));
            returnorderdetail.setMoney((Float) map.get("subtotal"));
            returnorderdetail.setStart("1");
            returnorderdetail.setOrdersid(b);
            returnorderdetailMapper.insert(returnorderdetail);
            shopcartMapper.deleteByPrimaryKey((Integer) map.get("cartid"));
        }
        //3.增加订单
        Rreturnorders rreturnorders=new Rreturnorders();
        rreturnorders.setId(b);
        rreturnorders.setWaybillsn(a);
        rreturnorders.setCreatetime(timestamp);
        rreturnorders.setCreater(Integer.parseInt(userid));
        if("1".equals(s)){
            rreturnorders.setType("1");    //订单类型-退货采购
        }else{
            rreturnorders.setType("2");    //订单类型-退货销售
        }
        rreturnorders.setSupplierid(Integer.parseInt(supplierid));
        rreturnorders.setState("1");
        rreturnorders.setTotalmoney(sum);
        return returnordersMapper.insert(rreturnorders);
    }

    @Override
    public List<Map<String, Object>> queryOrderLstPage(Ordervoreturn ordervoreturn, PageBean pageBean) {
        return returnordersMapper.queryOrderLstPage(ordervoreturn);
    }

    //审核
    @Override
    public int updatecheck(Rreturnorders record,String userid) {
        record.setChecker(Integer.parseInt(userid));    //审核人id 获取当前用户
        record.setChecktime(timestamp);   //当前时间
        record.setState("2");
        return returnordersMapper.updatecheck(record);
    }

    //入库
    @Override
    public int updateender(Rreturnorders record,String userid) {
        //1查询订单项状态
        int a=0;
        Returnorderdetail orderitem=new Returnorderdetail();
        orderitem.setOrdersid(record.getId());
        List<Map<String, Object>> queryitembyid = returnorderdetailMapper.querybackByid(orderitem);  //根据订单id获取订单项
        Object start=null;
        for (Map<String, Object> map : queryitembyid) {
            start=map.get("start");
        }
        if (start.equals("2")){
            a=1;
            record.setEnder(Integer.parseInt(userid));         //入库id 获取当前用户
            record.setEndtime(timestamp);   //当前时间
            record.setState("3");
            return returnordersMapper.updateender(record);
        }
        return a;
    }

    //采购查询所有
    @Override
    public List<Map<String, Object>> querypurOrderPage(Ordervoreturn ordervo,PageBean pageBean) {
        return returnordersMapper.querypurOrderPage(ordervo);
    }

    //采购退货订单出库
    @Override
    public int updatByideout(Rreturnorders record) {
        //1查询订单项状态
        int a=0;
        Returnorderdetail orderitem=new Returnorderdetail();
        orderitem.setOrdersid(record.getId());
        List<Map<String, Object>> queryitembyid = returnorderdetailMapper.querybackByid(orderitem);  //根据订单id获取订单项
        Object start=null;
        for (Map<String, Object> map : queryitembyid) {
            start=map.get("start");
        }
        if (start.equals("2")){
            a=1;
            record.setEndtime(timestamp);   //当前时间
            record.setState("3");
            return returnordersMapper.updatByideout(record);
        }
        return a;

    }
}
