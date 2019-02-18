package com.zking.springboot_project.depot.controller;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.depot.model.Inventory;
import com.zking.springboot_project.depot.service.IInventoryService;
import com.zking.springboot_project.depot.vo.InventoryVo;
import com.zking.springboot_project.sys.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/inventory")
public class Inventorycontroller {

    @Autowired
    private IInventoryService InventoryService;

    @RequestMapping("/queryInventoryMapPage")
    @ResponseBody
    public Object queryInventoryMapPage(HttpServletRequest req,InventoryVo inventory,
                                        @RequestParam String page,
                                        @RequestParam String limit){
//        Emp user = (Emp) req.getSession().getAttribute("User");
//        if(!"apei".equals(user.getUsername())){
//            inventory.setCreater(user.getId());
//        }
        PageBean pageBean = new PageBean();
        pageBean.setPage(page);
        pageBean.setRows(limit);
        List<Map<String, Object>> list = InventoryService.queryInventoryMapPage(inventory, pageBean);
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

    @RequestMapping("/addInventory")
    @ResponseBody
    public Object addInventory(HttpServletRequest req, Inventory inventory){
        Emp emp=(Emp)req.getSession().getAttribute("User");
        inventory.setCreatetime(new Date());
        inventory.setCreater(emp.getId());
        inventory.setState("1");
        int insert = InventoryService.insert(inventory);
        Map<String,Object> map=new HashMap<>();
        map.put("msg", "增加成功");
        return map;
    }


    @RequestMapping("/updateInventory")
    @ResponseBody
    public Object updateInventory(HttpServletRequest req, Inventory inventory){
        Emp emp=(Emp)req.getSession().getAttribute("User");
        inventory.setChecktime(new Date());
        inventory.setChecker(2);
        inventory.setState("2");
        int i = InventoryService.updateCheck(inventory);
        Map<String,Object> map=new HashMap<>();
        map.put("msg", "审核成功");
        return map;
    }




}
