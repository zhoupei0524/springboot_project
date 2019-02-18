package com.zking.springboot_project.pur.controller;


import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.pur.model.Rreturnorders;
import com.zking.springboot_project.pur.service.IReturnordersService;
import com.zking.springboot_project.sys.model.Emp;
import com.zking.springboot_project.vo.Ordervoreturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.*;

@Controller
@RequestMapping("/Orderback")
public class Orderreturncontroller {

    @Autowired
    private IReturnordersService returnordersService;

    Date date = new Date();
    Timestamp timestamp = new Timestamp(date.getTime());

    //采购退货查询
    @RequestMapping("/querypurbackPage")
    @ResponseBody
    public Map<String, Object> querypurbackPage(HttpServletRequest req, Ordervoreturn ordervoreturn,PageBean pageBean) {
        List<Map<String, Object>> ordersPage = returnordersService.querypurOrderPage(ordervoreturn,pageBean);
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

    //销售退货查询
    @RequestMapping("/queryOrderbackPage")
    @ResponseBody
    public Map<String, Object> queryOrderbackPage(HttpServletRequest req, Ordervoreturn ordervoreturn,PageBean pageBean) {
        List<Map<String, Object>> ordersPage = returnordersService.queryOrderLstPage(ordervoreturn,pageBean);
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

    @RequestMapping("/addOrdersback")
    @ResponseBody
    public Map<String, Object> addOrdersback(HttpServletRequest req,@RequestParam String b,@RequestParam String a) {
        Emp user = (Emp) req.getSession().getAttribute("User");
        returnordersService.insert(b,a,user.getId()+"");
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "添加成功");
        return map;
    }

    @RequestMapping("/updatecheck")
    @ResponseBody
    public Map<String, Object> updatecheck(HttpServletRequest req,Rreturnorders rreturnorders) {
        Emp user = (Emp) req.getSession().getAttribute("User");
        returnordersService.updatecheck(rreturnorders,user.getId()+"");
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "订单审核成功");
        return map;
    }

    //销售退货订单入库
    @RequestMapping("/updatbackput")
    @ResponseBody
    public Map<String, Object> updatbackput(HttpServletRequest req,Rreturnorders rreturnorders) {
        Emp user = (Emp) req.getSession().getAttribute("User");
        int i = returnordersService.updateender(rreturnorders,user.getId()+"");
        Map<String, Object> map = new HashMap<>();
        if(i!=0){
            map.put("msg", "订单入库成功");
        }else{
            map.put("msg", "订单入库失败!有商品还未入库");
        }
        return map;
    }


    //采购退货订单出库
    @RequestMapping("/updatByideout")
    @ResponseBody
    public Map<String, Object> updatByideout(HttpServletRequest req,Rreturnorders rreturnorders) {
        Emp user =(Emp) req.getSession().getAttribute("User");
        rreturnorders.setEnder(user.getId());
        int i = returnordersService.updatByideout(rreturnorders);
        Map<String, Object> map = new HashMap<>();
        if(i!=0){
            map.put("msg", "订单出库成功");
        }else{
            map.put("msg", "订单出库失败!有商品还未出库");
        }
        return map;
    }


}
