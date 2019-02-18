package com.zking.springboot_project.sys.service.impl;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.sys.VO.EmpVo;
import com.zking.springboot_project.sys.mapper.EmpMapper;
import com.zking.springboot_project.sys.model.Emp;
import com.zking.springboot_project.sys.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class EmpServiceImpl implements IEmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public Emp querySingle(String username) {
        return empMapper.querySingle(username);
    }


    @Override
    public Emp queryUserLogin(String username) {
        return empMapper.querySingle(username);
    }

    @Override
    public Set<String> findRoles(String username) {
        return empMapper.findRoles(username);
    }

    @Override
    public Set<String> findPermissions(String username) {
        return empMapper.findPermissions(username);
    }

    @Override
    public List<Emp> queryEmp(Emp emp) {
        return empMapper.queryEmp(emp);
    }


    @Override
    public List<Map<String, Object>> queryEmpPage(EmpVo empV, PageBean pageBean) {
        return empMapper.queryEmpPage(empV);
    }

    @Override
    public int insert(Emp emp) {
        Emp emp1 = empMapper.querySingle(emp.getUsername());
        int a=0;
        if(emp1==null){
            empMapper.insert(emp);
            a=1;
        }
        return a;
    }

    @Override
    public int delEmp(Emp emp) {
        return empMapper.delEmp(emp);
    }

    @Override
    public int updateEmp(Emp emp) {
//        Emp emp1 = empMapper.querySingle(emp.getUsername());
//        boolean updateto=false;
//        if(emp1!=null){
//            if(emp1.getId()==emp.getId()&&emp1.getUsername().equals(emp.getUsername())){
//                updateto=true;
//            }
//        }
//        int a=0;
//        if(emp1==null||updateto){
//
//            a=1;
//        }
        return empMapper.updateEmp(emp);
    }

    @Override
    public int updatePassword(Emp emp) {
        return empMapper.updatePassword(emp);
    }


    @Override
    public List<Map<String, Object>> queryEmpRolePage(EmpVo empVo, PageBean pageBean) {
        return empMapper.queryEmpRolePage(empVo);
    }

    @Override
    public List<Emp> queryEmpByRole(Emp emp) {
        return empMapper.queryEmpByRole(emp);
    }


    @Override
    public Map<String, Object> MapLoginSession(Emp emp) {
        return empMapper.MapLoginSession(emp);
    }

    @Override
    public int editUser(Emp emp) {
        return empMapper.editUser(emp);
    }

    @Override
    public int editPhoto(Emp emp) {
        return empMapper.editPhoto(emp);
    }
}
