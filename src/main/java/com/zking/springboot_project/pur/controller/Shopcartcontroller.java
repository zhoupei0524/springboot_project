package com.zking.springboot_project.pur.controller;


import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.pur.model.Orders;
import com.zking.springboot_project.pur.model.Shopcart;
import com.zking.springboot_project.pur.service.IShopcartService;
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
@RequestMapping("/Shopcart")
public class Shopcartcontroller {

    @Autowired
    private IShopcartService shopcartService;

    /*
    *增加购物车
     */
    @RequestMapping("/addshopcart")
    @ResponseBody
    public Map<String, Object> addshopcart(Shopcart shopcart) {
        shopcart.setState(1);
        shopcartService.insert(shopcart);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "添加成功");
        return map;
    }

    @RequestMapping("/delshopcart")
    @ResponseBody
    public Map<String, Object> delshopcart(Shopcart shopcart) {
        System.out.println("删除购物车商品----------"+shopcart.getCartid());
        shopcartService.deleteByPrimaryKey(shopcart.getCartid());
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "删除成功");
        return map;
    }

    @RequestMapping("/queryshopcart")
    @ResponseBody
    public Map<String, Object> queryshopcart(HttpServletRequest req, Orders orders,
                                          @RequestParam String page, @RequestParam String limit) {
        PageBean pageBean = new PageBean();
        pageBean.setPage(page);
        pageBean.setRows(5);
        pageBean.setRows(limit);
        List<Map<String, Object>> ordersPage = shopcartService.queryCartLst();
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

}
