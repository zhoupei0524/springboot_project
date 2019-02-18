package com.zking.springboot_project.basic.controller;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.basic.model.Storewarning;
import com.zking.springboot_project.basic.service.IStorewarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/storewarning")
public class Storewarningcontroller {

    @Autowired
    private IStorewarningService storewarningService;

    @RequestMapping("/queryStorewarningListPage")
    @ResponseBody
    private Map<String, Object> queryStorewarningListPage(Storewarning storewarning,
                                                          @RequestParam String page,
                                                          @RequestParam String limit) {
        PageBean pageBean = new PageBean();
        pageBean.setPage(page);
        pageBean.setRows(limit);
        List<Storewarning> storewarnings = storewarningService.queryStorewarningListPage(storewarning, pageBean);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageBean.getTotal());
        map.put("data", storewarnings);
        return map;
    }


}
