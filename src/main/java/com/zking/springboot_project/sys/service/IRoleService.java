package com.zking.springboot_project.sys.service;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.sys.model.Role;

import java.util.List;

public interface IRoleService {
    List<Role> queryRolelistPage(Role role, PageBean pageBean);

    List<Role> queryRolelist(Role role);

    int deleteByID(Integer roleid);

    int updateById(Role record);

    int insert(Role record);


}
