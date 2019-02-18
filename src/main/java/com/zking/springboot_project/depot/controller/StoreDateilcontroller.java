package com.zking.springboot_project.depot.controller;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.depot.model.Storedetail;
import com.zking.springboot_project.depot.service.IStoreDateilService;
import com.zking.springboot_project.sys.model.Emp;
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
@RequestMapping("/StoreDateil")
public class StoreDateilcontroller {

    @Autowired
    private IStoreDateilService storeDateilService;

    @RequestMapping("/queryStoreDateil")
    @ResponseBody
    public Map<String, Object> queryStoreDateil(HttpServletRequest req,Storedetail storedetail,
                                                @RequestParam String page,
                                                @RequestParam String limit){
//        Emp user = (Emp) req.getSession().getAttribute("User");
//        if(!"apei".equals(user.getUsername())){
//            storedetail.setNum(user.getId());
//        }
//        System.out.println(storedetail);
        PageBean pageBean = new PageBean();
        pageBean.setPage(page);
        pageBean.setRows(limit);
        List<Map<String, Object>> list = storeDateilService.queryStoredetaillistmapPage(storedetail, pageBean);
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

    @RequestMapping("/querySingStoreDateil")
    @ResponseBody
    public Object querySingStoreDateil(Storedetail storedetail) {
        List<Map<String, Object>> list = storeDateilService.queryStoredetaillistmap(storedetail);
        return list;
    }

}
