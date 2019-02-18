package com.zking.springboot_project.personnel.service;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.personnel.model.Dep;

import java.util.List;

public interface DepService {
    int updateByID(Dep record);

    List<Dep> queryDepPage(Dep dep, PageBean pageBean);

    List<Dep> queryDep(Dep dep);

    int deleteByID(Integer id);

    int insert(Dep record);
}
