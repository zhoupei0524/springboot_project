package com.zking.springboot_project.personnel.mapper;

import com.zking.springboot_project.personnel.model.Dep;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface DepMapper {
    int deleteByID(Integer id);

    int insert(Dep record);

    Dep selectByID(Integer id);

    int updateByID(Dep record);

    List<Dep> queryDepPage(Dep dep);

    Dep selectByName(Dep dep);



}