package com.zking.springboot_project.depot.controller;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.depot.service.IStoreoperService;
import com.zking.springboot_project.depot.vo.StoreoperVo;
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
@RequestMapping("/storeoper")
public class Storeopercontroller {

    @Autowired
    private IStoreoperService storeoperService;

    @RequestMapping("/queryStoreoperMapPage")
    @ResponseBody
    public Object queryStoreoperMapPage(HttpServletRequest req,StoreoperVo storeoperVo,
                                        @RequestParam String page,
                                        @RequestParam String limit){
//        Emp user = (Emp) req.getSession().getAttribute("User");
//        if(!"apei".equals(user.getUsername())){
//            storeoperVo.setNum(user.getId());
//        }
        PageBean pageBean = new PageBean();
        pageBean.setPage(page);
        pageBean.setRows(limit);
        List<Map<String, Object>> list = storeoperService.queryStoreoperMapPage(storeoperVo, pageBean);
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

}
