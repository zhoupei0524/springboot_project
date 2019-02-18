package com.zking.springboot_project.sys.service.impl;

import com.zking.springboot_project.sys.mapper.EmpRoleMapper;
import com.zking.springboot_project.sys.model.EmpRole;
import com.zking.springboot_project.sys.service.IEmpRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpRoleServiceImpl implements IEmpRoleService {

    @Autowired
    private EmpRoleMapper empRoleMapper;

    @Override
    public int updateEmpRole(EmpRole empRole) {
        EmpRole empRole1 = empRoleMapper.queryEmpRole(empRole);
        if(empRole1!=null){
            empRoleMapper.updateEmpRole(empRole);
        }else{
            empRoleMapper.insertEmpRole(empRole);
        }
        return 0;
    }
}
