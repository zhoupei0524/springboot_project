package com.zking.springboot_project.sys.mapper;

import com.zking.springboot_project.sys.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleMapper {
    int deleteByID(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateById(Role record);

    List<Role> queryRolelist(Role role);

    Role queryRole(Role role);

}