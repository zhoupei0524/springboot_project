package com.zking.springboot_project.personnel.service.impl;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.personnel.mapper.DepMapper;
import com.zking.springboot_project.personnel.model.Dep;
import com.zking.springboot_project.personnel.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepServiceImpl implements DepService {

    @Autowired
    private DepMapper depMapper;

    @Override
    public int updateByID(Dep record) {
        Dep dep = depMapper.selectByName(record);
        boolean updateto=false;
        if(dep!=null){
            if(dep.getId()==record.getId()&&dep.getName().equals(record.getName())){
                updateto=true;
            }
        }
        int a=0;
        if(dep==null||updateto){
            depMapper.updateByID(record);
            a=1;
        }
        return a;
    }

    @Override
    public List<Dep> queryDepPage(Dep dep, PageBean pageBean) {
        return depMapper.queryDepPage(dep);
    }

    @Override
    public List<Dep> queryDep(Dep dep) {
        return depMapper.queryDepPage(dep);
    }

    @Override
    public int deleteByID(Integer id) {
        return depMapper.deleteByID(id);
    }

    @Override
    public int insert(Dep record) {
        Dep dep = depMapper.selectByName(record);
        int a=0;
        if(dep==null){
            depMapper.insert(record);
            a=1;
        }
        return a;
    }
}
