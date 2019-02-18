package com.zking.springboot_project.sys.controller;

import com.zking.springboot_project.sys.model.EmpRole;
import com.zking.springboot_project.sys.service.IEmpRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/empRole")
public class EmpRolecontroller {

    @Autowired
    private IEmpRoleService empRoleService;

    @RequestMapping("/distribution")
    @ResponseBody
    public Object distribution(EmpRole empRole){
        empRoleService.updateEmpRole(empRole);
        Map<String,Object> map=new HashMap<>();
        map.put("msg","分配成功");
        return map;
    }

}
