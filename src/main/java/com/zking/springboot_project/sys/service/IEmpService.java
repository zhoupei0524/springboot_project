package com.zking.springboot_project.sys.service;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.sys.VO.EmpVo;
import com.zking.springboot_project.sys.model.Emp;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface IEmpService {

    Emp querySingle(String username);

    Emp queryUserLogin(String username);

    /**
     * 根据username查询该用户的所有角色，用于角色验证
     * @param username
     * @return
     */
    Set<String> findRoles(String username);

    /**
     * 根据username查询他所拥有的权限信息，用于权限判断
     * @param username
     * @return
     */
    Set<String> findPermissions(String username);

    List<Emp> queryEmp(Emp emp);

    List<Map<String,Object>> queryEmpPage(EmpVo empVo, PageBean pageBean);

    int insert(Emp emp);

    int delEmp(Emp emp);

    int updateEmp(Emp emp);

    int updatePassword(Emp emp);

    List<Map<String,Object>> queryEmpRolePage(EmpVo empVo, PageBean pageBean);

    List<Emp> queryEmpByRole(Emp emp);

    Map<String,Object> MapLoginSession(Emp emp);

    int editUser(Emp emp);

    int editPhoto(Emp emp);

}