package com.zking.springboot_project.sys.mapper;

import com.zking.springboot_project.sys.model.Module;
import com.zking.springboot_project.sys.model.RoleModule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ModuleMapper {

    List<Map<String,Object>> querymodulemap(Module module);

    List<Module> querymoduleList(Module module);

    int insertRoleModule(RoleModule RoleModule);

    List<RoleModule> queryroleModulesingm(RoleModule roleModule);


    void deleteByIdtorolemodule(Module module);

    //根据登陆ID获取角色模块
    List<Map<String,Object>> querylistmapByIdtomodule(Module module);
}