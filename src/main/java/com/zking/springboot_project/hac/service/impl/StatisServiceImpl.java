package com.zking.springboot_project.hac.service.impl;


import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.hac.mapper.StatisMapper;
import com.zking.springboot_project.hac.service.IStatisService;
import com.zking.springboot_project.hac.vo.StatisVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StatisServiceImpl implements IStatisService {

    @Autowired
    private StatisMapper statisMapper;

    @Override
    public List<Map<String, Object>> queryStatisList(StatisVo statisVo, PageBean pageBean) {
        return statisMapper.queryStatisList(statisVo);
    }
}
