package com.zking.springboot_project.sys.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zking.springboot_project.sys.mapper.RoleMapper;
import com.zking.springboot_project.sys.model.Emp;
import com.zking.springboot_project.sys.model.Module;
import com.zking.springboot_project.sys.model.RoleModule;
import com.zking.springboot_project.sys.service.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Transaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Module")
public class Modulecontroller {
    @Autowired
    private IModuleService iModuleService;

    ObjectMapper mapper = new ObjectMapper();


    @RequestMapping("/queryModuleList")
    @ResponseBody
    public Object queryModuleList(HttpServletRequest req, HttpServletResponse resp, Module module) throws Exception {
      List<Map<String, Object>> lst = iModuleService.querymodulemap(module);
//        Emp user = (Emp) req.getSession().getAttribute("User");
//        System.out.println(user);
//        module.setId(user.getId()+"");
//        List<Map<String, Object>> lst = iModuleService.querylistmapByIdtomodule(module);
        Object list = tree(lst, "-1");
        return list;
    }

    @RequestMapping("/queryModulezTree")
    @ResponseBody
    public Object queryModulezTree(Module module, RoleModule roleModule) {
        //所有
        List<Module> allm = iModuleService.querymoduleList(module);
        //已分配
        List<RoleModule> singm = iModuleService.queryroleModulesingm(roleModule);
        //判断
        Map<String, String> tomap = new HashMap<>();
        for (RoleModule roleModule1 : singm) {
            Object str = roleModule1.getModuleid();
            tomap.put(str + "", "true");
        }
        //数据拼合 （三级子节点的笨方法）
        List<Object> ls = new ArrayList<>();      //存储所有的一级子节点
        Map<String, Object> map = new HashMap<>();//一级子节点的中转容器
        List<Object> la = new ArrayList<>();      //存储二级子节点 数据填充完毕后 放到对应一级子节点（map）的children属性下
        Map<String, Object> mab = new HashMap<>();//二级子节点的中转容器 数据填充完毕后 放到对应二级子节点（la）里
        List<Object> lb = new ArrayList<>();      //存储三级子节点
        Map<String, Object> mac = new HashMap<>();//一个mac相当于一个三级节点对象

        //循环所有的权限数据
        for (Module SysModule : allm) {
            //如果是一级（定义pid值为-1的为一级子节点你也可以自己定义null）
            if ((SysModule.getPid()+"").equals("-1")) {
                //建一个一级子节点对象 必须在if里面实例化
                map = new HashMap<>();
                map.put("id", SysModule.getId());
                map.put("name", SysModule.getText());
                if (tomap.get(SysModule.getId()) != null) {
                    map.put("checked", "true");
                }
                //如果一级子节点下有子节点那么实例化一个集合保存它
                la = new ArrayList<>();
                //循环全部的权限找到pid等于父节点id的所有节点
                for (int i = 0; i < allm.size(); i++) {
                    //如果它是，实例化一个mab装它
                    if ((allm.get(i).getPid()+"").equals(SysModule.getId())) {
                        mab = new HashMap<>();
                        mab.put("id", allm.get(i).getId());
                        mab.put("name", allm.get(i).getText());
                        mab.put("open", "true");
                        if (tomap.get(allm.get(i).getId()) != null) {
                            mab.put("checked", "true");
                        }
                        lb = new ArrayList<>();
                        for (int j = 0; j < allm.size(); j++) {
                            if ((allm.get(j).getPid()+"").equals(allm.get(i).getId())) {
                                mac = new HashMap<>();
                                mac.put("id", allm.get(j).getId());
                                mac.put("name", allm.get(j).getText());
                                if (tomap.get(allm.get(j).getId()) != null) {
                                    mac.put("checked", "true");
                                }
                                lb.add(mac);
                            }
                        }
                        mab.put("children", lb);
                        //最后把这个mab放进la这个二级节点容器
                        la.add(mab);
                    }
                }
                map.put("children", la);
                //一个一级子节点填完了放进集合里
                ls.add(map);
            }
        }
        return ls;
    }

    @RequestMapping("/Roleassign")
    @ResponseBody
    public String assign(HttpServletRequest req) {
        Map<String, String[]> maps = req.getParameterMap();
        String[] mids = maps.get("mids");
        String[] rid = maps.get("rid");
        RoleModule roleModule = new RoleModule();
        roleModule.setRoleid(rid[0]);
        iModuleService.insertRoleModule(roleModule,mids);

//        try {
//            for (String s : mids) {
//
//                roleModule.setModuleid(Integer.parseInt(s));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return null;
    }


    public Object ztree(List<Map<String, Object>> lst, String pid) {
        List<Map<String, Object>> sj = new ArrayList<>();
        Map<String, Object> map = null;
        for (Map<String, Object> m : lst) {
            if ((m.get("pid") + "").equals(pid)) {
                map = new HashMap<>();
                map.put("pid", m.get("pid"));
                map.put("id", m.get("id"));
                if ("".equals(m.get("text"))) {
                    map.put("name", m.get("name"));
                } else {
                    map.put("name", m.get("text"));
                }
                map.put("url", m.get("url"));
                map.put("icon", m.get("icon"));
                map.put("sort", m.get("sort"));
                List<Map<String, Object>> tree = (List<Map<String, Object>>) ztree(lst, m.get("id") + "");
                if (tree.size() > 0) {
                    map.put("children", tree);
                }
                sj.add(map);
            }
        }
        return sj;
    }

    public Object tree(List<Map<String, Object>> lst, String pid) {
        List<Map<String, Object>> sj = new ArrayList<>();
        Map<String, Object> map = null;
        for (Map<String, Object> m : lst) {
            if ((m.get("pid") + "").equals(pid)) {
                map = new HashMap<>();
                map.put("pid", m.get("pid"));
                map.put("id", m.get("id"));
                map.put("text", m.get("text"));
                map.put("url", m.get("url"));
                map.put("icon", m.get("icon"));
                map.put("sort", m.get("sort"));
                List<Map<String, Object>> tree = (List<Map<String, Object>>) tree(lst, m.get("id") + "");
                if (tree.size() > 0)
                    map.put("children", tree);
                sj.add(map);
            }
        }
        return sj;
    }
}
