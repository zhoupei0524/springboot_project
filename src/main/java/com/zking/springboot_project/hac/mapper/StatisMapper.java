package com.zking.springboot_project.hac.mapper;

import com.zking.springboot_project.hac.model.Statis;
import com.zking.springboot_project.hac.vo.StatisVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface StatisMapper {

    int insert(Statis record);

    int insertSelective(Statis record);

    //根据开始   --   结束时间查询这段时间的各个商品类型的总销售额
    List<Map<String,Object>> queryStatisList(StatisVo statisVo);

}