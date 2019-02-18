package com.zking.springboot_project.hac.service;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.hac.vo.StatisVo;

import java.util.List;
import java.util.Map;

public interface IStatisService {

    //根据开始   --   结束时间查询这段时间的各个商品类型的总销售额
    List<Map<String,Object>> queryStatisList(StatisVo statisVo, PageBean pageBean);

}