package com.zking.springboot_project.pur.controller;


import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.pur.model.Orderitem;
import com.zking.springboot_project.pur.service.IOrderitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Orderitem")
public class Orderitemcontroller {

    @Autowired
    private IOrderitemService orderitemService;

    //根据订单ID查询订单项 采购销售共用
    @RequestMapping("/queryOrderitembyid")
    @ResponseBody
    public Map<String, Object> queryOrderitembyid(HttpServletRequest req, Orderitem orderitem,
                                          @RequestParam String page, @RequestParam String limit) {
        PageBean pageBean = new PageBean();
//        pageBean.setRows(5);
        pageBean.setPage(page);
        pageBean.setRows(limit);
        List<Map<String, Object>> ordersPage = orderitemService.queryitembyid(orderitem);
        List<Object> list = new ArrayList<>();
        for (Map<String, Object> stringObjectMap : ordersPage) {
            list.add(stringObjectMap);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageBean.getTotal());
        map.put("data", list);
        return map;
    }

    //采购 商品入库
    @RequestMapping("/updatitemByidput")
    @ResponseBody
    public Map<String, Object> updatitemByidput(@RequestParam String id,@RequestParam String storeid,@RequestParam String goodsid,@RequestParam String num) {
        System.out.println("采购 商品入库");
        Orderitem orderitem=new Orderitem();
        orderitem.setId(Integer.parseInt(id));
        orderitem.setStoreid(Integer.parseInt(storeid));
        orderitem.setGoodsid(Integer.parseInt(goodsid));
        orderitem.setNum(Integer.parseInt(num));
        orderitemService.updateByPrimaryKey(orderitem);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "商品入库成功");
        return map;
    }

    //销售 出库
    @RequestMapping("/updatitemByidout")
    @ResponseBody
    public Map<String, Object> updatitemByidout(@RequestParam String id,@RequestParam String storeid,@RequestParam String goodsid,@RequestParam String num) {
        Orderitem orderitem=new Orderitem();
        orderitem.setId(Integer.parseInt(id));
        orderitem.setStoreid(Integer.parseInt(storeid));
        orderitem.setGoodsid(Integer.parseInt(goodsid));
        orderitem.setNum(Integer.parseInt(num));
        int i = orderitemService.updateByitemid(orderitem);
        Map<String, Object> map = new HashMap<>();
        if(i==1){
            map.put("msg", "商品出库成功");
        }else{
            map.put("msg", "商品出库失败,请查看库存是否足够！");
        }
        return map;
    }
}
