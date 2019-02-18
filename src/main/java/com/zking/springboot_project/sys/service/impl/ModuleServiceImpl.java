package com.zking.springboot_project.sys.service.impl;

import com.zking.springboot_project.sys.mapper.ModuleMapper;
import com.zking.springboot_project.sys.mapper.RoleMapper;
import com.zking.springboot_project.sys.model.Module;
import com.zking.springboot_project.sys.model.RoleModule;
import com.zking.springboot_project.sys.service.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ModuleServiceImpl implements IModuleService {

    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    public List<Map<String, Object>> querymodulemap(Module module) {
        return moduleMapper.querymodulemap(module);
    }

    @Override
    public List<Module> querymoduleList(Module module) {
        return moduleMapper.querymoduleList(module);
    }

    @Override
    public int insertRoleModule(RoleModule roleMapper,String[] strings) {
        Module module=new Module();
        module.setId(roleMapper.getRoleid());
        moduleMapper.deleteByIdtorolemodule(module);

        int i=0;
        for (String s : strings) {
             roleMapper.setModuleid(Integer.parseInt(s));
             System.out.println(s);
             i = moduleMapper.insertRoleModule(roleMapper);
        }

        return i;
    }

    @Override
    public List<RoleModule> queryroleModulesingm(RoleModule roleModule) {
        return moduleMapper.queryroleModulesingm(roleModule);
    }

    @Override
    public List<Map<String, Object>> querylistmapByIdtomodule(Module module) {
        return moduleMapper.querylistmapByIdtomodule(module);
    }
}
