package com.zking.springboot_project.basic.controller;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.basic.model.Store;
import com.zking.springboot_project.basic.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.Query;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/store")
public class Storecontroller {

    @Autowired
    private IStoreService storeService;

    @RequestMapping("/queryStorePage")
    @ResponseBody
    public Object queryStorePage(HttpServletRequest req,Store store,
                                 @RequestParam String page,
                                 @RequestParam String limit) {
        PageBean pageBean = new PageBean();
        pageBean.setPage(page);
        pageBean.setRows(limit);
        List<Map<String, Object>> list = storeService.queryStorePage(store,pageBean);
        List<Object> lis = new ArrayList<>();
        for (Map<String, Object> stringObjectMap : list) {
            lis.add(stringObjectMap);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageBean.getTotal());
        map.put("data", lis);
        return map;
    }

    @RequestMapping("/addStore")
    @ResponseBody
    public Object addStore(Store store){
        int insert = storeService.insert(store);
        Map<String, Object> map = new HashMap<>();
        if(insert!=0){
            map.put("msg","增加成功");
        } else{
            map.put("msg", "增加失败!!!仓库名称重复!!");
        }
        return map;
    }
    @RequestMapping("/delStore")
    @ResponseBody
    public Object delStore(Store store){
        storeService.deleteByPrimaryKey(store.getId());
        Map<String, Object> map = new HashMap<>();
            map.put("msg", "删除成功");
        return map;
    }
    @RequestMapping("/updateStore")
    @ResponseBody
    public Object updateStore(Store store){
        int i = storeService.updateStore(store);
        Map<String, Object> map = new HashMap<>();
        if(i!=0){
            map.put("msg","修改成功");
        } else{
            map.put("msg", "修改失败!!!仓库名称重复!!");
        }
        return map;
    }


    @RequestMapping("/querystoreList")
    @ResponseBody
    private List<Store> querystoreList(Store store){
        List<Store> querylist = storeService.querylist(store);
        return querylist;
    }






}
