package com.zking.springboot_project.sys.mapper;

import com.zking.springboot_project.sys.VO.EmpVo;
import com.zking.springboot_project.sys.model.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Mapper
public interface EmpMapper {

    Emp querySingle(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);

    List<Emp> queryEmp(Emp emp);

    List<Map<String,Object>> queryEmpPage(EmpVo empVo);

    int insert(Emp emp);

    int delEmp(Emp emp);

    int updateEmp(Emp emp);

    //修改密码
    int updatePassword(Emp emp);

    List<Map<String,Object>> queryEmpRolePage(EmpVo empVo);

    List<Emp> queryEmpByRole(Emp emp);

   Map<String,Object> MapLoginSession(Emp emp);
   //员工修改信息
   int editUser(Emp emp);
   //上传图片
   int editPhoto(Emp emp);





}