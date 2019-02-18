package com.zking.springboot_project.pur.service.impl;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.pur.mapper.OrderitemMapper;
import com.zking.springboot_project.pur.mapper.OrdersMapper;
import com.zking.springboot_project.pur.mapper.ShopcartMapper;
import com.zking.springboot_project.pur.model.Orderitem;
import com.zking.springboot_project.pur.model.Orders;
import com.zking.springboot_project.pur.service.IOrdersService;
import com.zking.springboot_project.pur.vo.OrdersVo;
import com.zking.springboot_project.vo.Ordervo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private ShopcartMapper shopcartMapper;
    @Autowired
    private OrderitemMapper orderitemMapper;

    Date date = new Date();
    Timestamp timestamp = new Timestamp(date.getTime());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return ordersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(String supplierid,String s,String hh) {
         int a= (int) ((Math.random()*9+1)*100000000);//运单号
         int b= (int) ((Math.random()*9+1)*100000);    //订单id

        //1.点提交订单时 获取购物车里的商品
        List<Map<String, Object>> cartlst = shopcartMapper.queryCartLst();

        //2.增加订单项
            Orderitem orderitem;
            Float sum=0f;   //总金额
            for (Map<String, Object> map : cartlst) {
                orderitem=new Orderitem();
                sum +=(Float) map.get("subtotal");

                orderitem.setGoodsid((Integer) map.get("goodid"));
                orderitem.setGoodsname((String) map.get("goodname"));
                orderitem.setPrice((Float)map.get("unitprice"));
                orderitem.setNum((Integer) map.get("num"));
                orderitem.setMoney((Float) map.get("subtotal"));
//                orderitem.setStoreid();
                orderitem.setState("1");
                orderitem.setOrderid(b);
                orderitemMapper.insert(orderitem);
                shopcartMapper.deleteByPrimaryKey((Integer) map.get("cartid"));
            }
            //3.增加订单
            Orders orders=new Orders();
            orders.setId(b);
            orders.setWaybills(a);
            orders.setCreatetime(timestamp);
            orders.setCreater(Integer.parseInt(hh));   //当前登录人id
            if("1".equals(s)){
                orders.setType("1");    //订单类型-采购
            }else{
                orders.setType("2");    //订单类型-销售
            }
            orders.setSupplierid(Integer.parseInt(supplierid));
            orders.setState("1");
            orders.setTotalmoney(sum);
        return ordersMapper.insert(orders);
    }

    @Override
    public List<Map<String, Object>> queryOrderLstPage(OrdersVo ordervo, PageBean pageBean) {
        return ordersMapper.queryOrderLst(ordervo);
    }

    @Override
    public List<Map<String, Object>> querysalelistPage(OrdersVo ordervo,PageBean pageBean) {
        return ordersMapper.querysalelist(ordervo);
    }

    //订单审核
    @Override
    public int updateByPrimaryKey(Orders record) {
        return ordersMapper.updateByPrimaryKey(record);
    }

    //订单确认
    @Override
    public int updateByorderid(Orders record) {
        return ordersMapper.updateByorderid(record);
    }

    //订单入库
    @Override
    public int updatByideput(Orders record,Integer ss) {

      //1查询订单项状态
        int a=0;
        Orderitem orderitem=new Orderitem();
        orderitem.setOrderid(record.getId());
        List<Map<String, Object>> queryitembyid = orderitemMapper.queryitembyid(orderitem);  //根据订单id获取订单项状态
        Object state=null;
        for (Map<String, Object> map : queryitembyid) {
            state=map.get("state");
        }
        if (state.equals("2")){
            a=1;
            record.setEnder(ss);       //入库id 获取当前用户
            record.setEndtime(timestamp);   //当前时间
            record.setState("4");
            return ordersMapper.updatByideput(record);
        }
        return a;
    }

    @Override
    public List<Map<String, Object>> queryOrdersList(String date,PageBean pageBean) {
        return ordersMapper.queryOrdersList(date);
    }
}
