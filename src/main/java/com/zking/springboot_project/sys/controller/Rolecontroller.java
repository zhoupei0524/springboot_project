package com.zking.springboot_project.sys.controller;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.sys.model.Role;
import com.zking.springboot_project.sys.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class Rolecontroller {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/queryRolelistPage")
    @ResponseBody
    public Map<String, Object> queryRolelistPage(Role role,
                                                 @RequestParam String page,
                                                 @RequestParam String limit) {
        PageBean pageBean = new PageBean();
        pageBean.setPage(page);
        pageBean.setRows(limit);
        List<Role> roles = roleService.queryRolelistPage(role, pageBean);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageBean.getTotal());
        map.put("data", roles);
        return map;
    }
    @RequestMapping("/queryRolelist")
    @ResponseBody
    public List<Role> queryRolelist(Role role){
        List<Role> roles = roleService.queryRolelist(role);
        return roles;
    }

    @RequestMapping("/deleteByid")
    @ResponseBody
    public Object deleteByid(Role role){
        roleService.deleteByID(role.getRoleid());
        Map<String, Object> map = new HashMap<>();
        map.put("msg","删除成功");
        return map;
    }

    @RequestMapping("/updateById")
    @ResponseBody
    public Object updateById(Role role){
        int i = roleService.updateById(role);
        Map<String, Object> map = new HashMap<>();
        if(i>0){
            map.put("msg","修改成功");
        }else{
            map.put("msg","修改失败!!!角色名称重复!!");
        }
        return map;
    }

    @RequestMapping("/addRole")
    @ResponseBody
    public Object addRole(Role role){
        int insert = roleService.insert(role);
        Map<String, Object> map = new HashMap<>();
        if(insert>0){
            map.put("msg","增加成功");
        }else{
            map.put("msg","增加失败!!!角色名称重复!!");
        }
        return map;
    }

}
