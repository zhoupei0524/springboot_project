package com.zking.springboot_project.personnel.controller;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.personnel.model.Dep;
import com.zking.springboot_project.personnel.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dep")
public class Depcontroller {

    @Autowired
    private DepService depService;

    @RequestMapping("/queryDepPage")
    @ResponseBody
    public Object queryDepPage(Dep dep,
                               @RequestParam String page,
                               @RequestParam String limit) {
        PageBean pageBean=new PageBean();
        pageBean.setPage(page);
        pageBean.setRows(limit);
        List<Dep> deps = depService.queryDepPage(dep, pageBean);
        Map<String,Object> map=new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageBean.getTotal());
        map.put("data", deps);
        return map;

    }
    @RequestMapping("/queryDep")
    @ResponseBody
    public Object queryDep(Dep dep) {
        List<Dep> deps = depService.queryDep(dep);
        return deps;
    }
    @RequestMapping("/delDep")
    @ResponseBody
    public Object delDep(Dep dep) {
        depService.deleteByID(dep.getId());
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "删除成功");
        return map;
    }
    @RequestMapping("/addDep")
    @ResponseBody
    public Object addDep(Dep dep) {
        int insert = depService.insert(dep);
        Map<String, Object> map = new HashMap<>();
        if(insert!=0){
            map.put("msg","增加成功");
        } else{
            map.put("msg", "增加失败!!!部门名称重复!!");
        }
        return map;
    }
    @RequestMapping("/updateDep")
    @ResponseBody
    public Object updateDep(Dep dep) {
        int i = depService.updateByID(dep);
        Map<String, Object> map = new HashMap<>();
        if(i!=0){
            map.put("msg","修改成功");
        } else{
            map.put("msg", "修改失败!!!部门名称重复!!");
        }
        return map;
    }


}
