package com.zking.springboot_project.pur.controller;


import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.pur.model.Orders;
import com.zking.springboot_project.pur.service.IOrdersService;
import com.zking.springboot_project.pur.vo.OrdersVo;
import com.zking.springboot_project.sys.model.Emp;
import com.zking.springboot_project.vo.Ordervo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.*;

@Controller
@RequestMapping("/Order")
public class Ordercontroller {

    @Autowired
    private IOrdersService ordersService;

    Date date = new Date();
    Timestamp timestamp = new Timestamp(date.getTime());

    @RequestMapping("/queryOrder")
    @ResponseBody
    public Map<String, Object> queryOrder(HttpServletRequest req, OrdersVo ordervo,
                                          @RequestParam String page,
                                          @RequestParam String limit) {
        System.out.println(ordervo);
        PageBean pageBean = new PageBean();
        pageBean.setPage(page);
        pageBean.setRows(limit);
        System.out.println("-------------------------");
        System.out.println(ordervo.getId());
        List<Map<String, Object>> ordersPage = ordersService.queryOrderLstPage(ordervo,pageBean);
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

    @RequestMapping("/querySaleOrder")
    @ResponseBody
    public Map<String, Object> querySaleOrder(HttpServletRequest req, OrdersVo ordervo,PageBean pageBean)
    {
        System.out.println(ordervo);
        List<Map<String, Object>> ordersPage = ordersService.querysalelistPage(ordervo,pageBean);
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

    @RequestMapping("/addOrders")
    @ResponseBody
    public Map<String, Object> addOrders(HttpServletRequest req,@RequestParam String a,@RequestParam String s) {
        Emp user = (Emp) req.getSession().getAttribute("User");
        ordersService.insert(a,s,user.getId()+"");
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "添加成功");
        return map;
    }

    @RequestMapping("/delOrders")
    @ResponseBody
    public Map<String, Object> delOrders(Orders orders) {
        ordersService.deleteByPrimaryKey(orders.getId());
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "删除成功");
        return map;
    }

    @RequestMapping("/editauditOrders")
    @ResponseBody
    public Map<String, Object> editauditOrders(HttpServletRequest req,Orders orders) {
        Emp user = (Emp) req.getSession().getAttribute("User");
        System.out.println(orders.getId()+"----------");
        orders.setChecker(user.getId());    //审核人id 获取当前用户
        orders.setChecktime(timestamp);   //当前时间
        orders.setState("2");
        ordersService.updateByPrimaryKey(orders);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "订单审核成功");
        return map;
    }

    @RequestMapping("/editaffirmOrders")
    @ResponseBody
    public Map<String, Object> editaffirmOrders(HttpServletRequest req,Orders orders) {
        Emp user = (Emp) req.getSession().getAttribute("User");
        orders.setStarter(user.getId());    //确认id 获取当前用户
        orders.setStarttime(timestamp);   //当前时间
        orders.setState("3");
        ordersService.updateByorderid(orders);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "订单确认成功");
        return map;
    }

    @RequestMapping("/updatByideput")
    @ResponseBody
    public Map<String, Object> updatByideput(HttpServletRequest req,Orders orders) {
        Emp user = (Emp) req.getSession().getAttribute("User");
        int i = ordersService.updatByideput(orders,user.getId());
        Map<String, Object> map = new HashMap<>();
        if(i!=0){
            map.put("msg", "订单入库成功");
        }else{
            map.put("msg", "订单入库失败!有商品还未入库");
        }
        return map;
    }

    @RequestMapping("/updatByideout")
    @ResponseBody
    public Map<String, Object> updatByideout(HttpServletRequest req,Orders orders) {
        Emp user = (Emp) req.getSession().getAttribute("User");
        int i = ordersService.updatByideput(orders,user.getId());
        Map<String, Object> map = new HashMap<>();
        if(i!=0){
            map.put("msg", "订单出库成功");
        }else{
            map.put("msg", "订单出库失败!有商品还未出库");
        }
        return map;
    }

    @RequestMapping("/queryOrdType")
    @ResponseBody
    public Map<String,Object> queryOrdType(@RequestParam String ss){
        Map<String,Object> map=new HashMap<String, Object>();

        List<Map<String, Object>> maps = ordersService.queryOrdersList(ss,null);

        List<Map<String,Object>> liSa=new ArrayList<Map<String, Object>>();
        List<List<Map<String,Object>>> llsta=new ArrayList<List<Map<String, Object>>>();
        //保存12月销售额
        List<Float> xl=new ArrayList<Float>();
        //一年的数据
        Map<String,Object> nsj=new HashMap<String, Object>();
        for (Map<String, Object> st : maps) {
            System.out.println(st);
            xl.add(Float.parseFloat(st.get("stati")+""));
        }
        nsj.put("name",date);
        nsj.put("data",xl);
        liSa.add(nsj);
        llsta.add(liSa);

        System.out.println(llsta.get(0));

        map.put("text",date+"年-销售统计");
        map.put("data", liSa);
        return map;
    }


    @RequestMapping("/queryOrdersType")
    @ResponseBody
    public Map<String,Object> queryOrdersType(@RequestParam String date, PageBean pageBean){
        System.out.println(date);
        Map<String,Object> map=new HashMap<String, Object>();
        List<Map<String, Object>> maps = ordersService.queryOrdersList(date,pageBean);

        List<Map<String,Object>> liSa=new ArrayList<Map<String, Object>>();
        List<List<Map<String,Object>>> llsta=new ArrayList<List<Map<String, Object>>>();
        //保存12月销售额
        List<Float> xl=new ArrayList<Float>();
        //一年的数据
        Map<String,Object> nsj=new HashMap<String, Object>();
        for (Map<String, Object> st : maps) {
            System.out.println(st);
            xl.add(Float.parseFloat(st.get("stati")+""));
        }

        nsj.put("data",xl);
        nsj.put("name",date);
        liSa.add(nsj);
        llsta.add(liSa);

        for (List<Map<String, Object>> s : llsta) {
            System.out.println(s);
        }

        map.put("sdata",llsta);
        map.put("text",date+"年-销售统计");
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageBean.getTotal());
        map.put("data", maps);
        return map;
    }



}
