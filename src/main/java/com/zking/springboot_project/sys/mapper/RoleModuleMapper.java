package com.zking.springboot_project.sys.mapper;

import com.zking.springboot_project.sys.model.RoleModule;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleModuleMapper {
    int insert(RoleModule record);

    int insertSelective(RoleModule record);
}