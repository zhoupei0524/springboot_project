package com.zking.springboot_project.sys.service;

import com.zking.springboot_project.sys.model.Module;
import com.zking.springboot_project.sys.model.RoleModule;

import java.util.List;
import java.util.Map;


public interface IModuleService {

    List<Map<String,Object>> querymodulemap(Module module);

    List<Module> querymoduleList(Module module);

    int insertRoleModule(RoleModule roleMapper, String[] strings);

    List<RoleModule> queryroleModulesingm(RoleModule roleModule);

    List<Map<String,Object>> querylistmapByIdtomodule(Module module);

}