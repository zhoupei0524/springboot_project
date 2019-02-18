package com.zking.springboot_project.sys.service.impl;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.sys.mapper.RoleMapper;
import com.zking.springboot_project.sys.model.Role;
import com.zking.springboot_project.sys.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> queryRolelistPage(Role role, PageBean pageBean) {
        return roleMapper.queryRolelist(role);
    }

    @Override
    public List<Role> queryRolelist(Role role) {
        return roleMapper.queryRolelist(role);
    }

    @Override
    public int deleteByID(Integer roleid) {
        return roleMapper.deleteByID(roleid);
    }

    @Override
    public int updateById(Role record) {
        Role roles = roleMapper.queryRole(record);
        boolean updateto=false;
        if(roles!=null){
            if (roles.getRoleid()==record.getRoleid()&&roles.getRolename().equals(record.getRolename())){
                updateto=true;
            }
        }
        int a=0;
        if (roles==null||updateto){
            roleMapper.updateById(record);
            a=1;
        }
        return a;
    }

    @Override
    public int insert(Role record) {
        Role roles = roleMapper.queryRole(record);
        int a=0;
        if (roles==null){
            roleMapper.insert(record);
            a=1;
        }
        return a;
    }
}
