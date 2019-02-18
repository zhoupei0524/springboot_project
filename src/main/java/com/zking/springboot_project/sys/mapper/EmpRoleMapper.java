package com.zking.springboot_project.sys.mapper;

import com.zking.springboot_project.sys.model.EmpRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface EmpRoleMapper {
    int insertEmpRole(EmpRole record);

    int insertSelective(EmpRole record);

    EmpRole queryEmpRole(EmpRole empRole);

    int updateEmpRole(EmpRole empRole);

}