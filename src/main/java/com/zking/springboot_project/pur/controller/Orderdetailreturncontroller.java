package com.zking.springboot_project.pur.controller;


import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.pur.model.Returnorderdetail;
import com.zking.springboot_project.pur.service.IReturnorderdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.*;

@Controller
@RequestMapping("/Orderitemback")
public class Orderdetailreturncontroller {

    @Autowired
    private IReturnorderdetailService returnorderdetailService;

    Date date = new Date();
    Timestamp timestamp = new Timestamp(date.getTime());

    @RequestMapping("/queryOrderitembackPage")
    @ResponseBody
    public Map<String, Object> queryOrderitembackPage(HttpServletRequest req, Returnorderdetail returnorderdetail, PageBean pageBean) {
        pageBean.setRows(5);
        List<Map<String, Object>> ordersPage = returnorderdetailService.querybackByidPage(returnorderdetail,pageBean);
        List<Object> list = new ArrayList<>();
        for (Map<String, Object> stringObjectMap : ordersPage) {
            list.add(stringObjectMap);
            System.out.println();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageBean.getTotal());
        map.put("data", list);
        return map;
    }

    //销售退货 商品入库
    @RequestMapping("/updatbackput")
    @ResponseBody
    public Map<String, Object> updatbackput(@RequestParam String id,@RequestParam String storeid,@RequestParam String goodsid,@RequestParam String num) {
        Returnorderdetail orderitem=new Returnorderdetail();
        orderitem.setId(Integer.parseInt(id));
        orderitem.setStoreid(Integer.parseInt(storeid));
        orderitem.setGoodsid(Integer.parseInt(goodsid));
        orderitem.setNum(Integer.parseInt(num));
        System.out.println("-----"+orderitem);
        int i = returnorderdetailService.updateByPrimaryKey(orderitem);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "商品入库成功");
        return map;
    }


    //采购退货订单出库
    @RequestMapping("/updatebackout")
    @ResponseBody
    public Map<String, Object> updatebackout(@RequestParam String id,@RequestParam String storeid,@RequestParam String goodsid,@RequestParam String num) {
        Returnorderdetail orderitem=new Returnorderdetail();
        orderitem.setId(Integer.parseInt(id));
        orderitem.setStoreid(Integer.parseInt(storeid));
        orderitem.setGoodsid(Integer.parseInt(goodsid));
        orderitem.setNum(Integer.parseInt(num));
        int i = returnorderdetailService.updatebackout(orderitem);
        Map<String, Object> map = new HashMap<>();
        if(i==1){
            map.put("msg", "商品出库成功");
        }else{
            map.put("msg", "商品出库失败,请查看库存是否足够！");
        }
        return map;
    }

}
