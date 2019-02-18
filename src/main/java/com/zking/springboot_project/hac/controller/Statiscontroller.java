package com.zking.springboot_project.hac.controller;



import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.base.util.StringUtils;
import com.zking.springboot_project.hac.service.IStatisService;
import com.zking.springboot_project.hac.vo.StatisVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DecimalFormat;
import java.util.*;

@Controller
@RequestMapping("/StatisType")
public class Statiscontroller {

    @Autowired
    private IStatisService statisService;


    @RequestMapping("/view")
    @ResponseBody
    public Map<String,Object> view(StatisVo statisVo,PageBean pageBean){
        Map<String,Object> map=new HashMap<>();
        List<Map<String, Object>> list = statisService.queryStatisList(statisVo, pageBean);
        map.put("code", 0);
        map.put("count", pageBean.getTotal());
        map.put("data", list);
        return map;
    }


    @RequestMapping("/queryStaType")
    @ResponseBody
    public Map<String,Object> queryStaType(String begin,String end){
        Map<String,Object> map=new HashMap<String, Object>();
        StatisVo statisVo=new StatisVo();
        statisVo.setBegin(begin);
        statisVo.setEnd(end);
        List<Map<String, Object>> maps = statisService.queryStatisList(statisVo,null);
        Map<String,Object> line=new HashMap<String, Object>();
        float taso = 0;//总计金额  /被除数
        float stato=100;//除数
        float ys=0;//公余数余数
        for (Map<String, Object> st : maps) {
            System.out.println(st.get("y"));
            taso+=Float.parseFloat(st.get("y")+"");
        }
        ys=taso/stato;
        float bcs=0;//保存数率
        String name="";//保存name
        float zs=0;

        List<Map<String,Object>> liSa=new ArrayList<Map<String, Object>>();
        List<List<Map<String,Object>>> llsta=new ArrayList<List<Map<String, Object>>>();

        for (Map<String, Object> st : maps) {
            Map<String,Object> maname=new HashMap<String, Object>();
            bcs=Float.parseFloat(st.get("y")+"")/ys;
            name=st.get("name")+"";
            maname.put("name",name);
            maname.put("y",bcs);
            liSa.add(maname);
//            System.out.println("name:"+name+" , y"+bcs);
            zs+=bcs;
        }
        llsta.add(liSa);
        for (List<Map<String, Object>> mapList : llsta) {
            System.out.println(mapList);
        }
         String s="";
        if(statisVo.getBegin()!=null&&statisVo.getEnd()!=null){
            s+=statisVo.getBegin()+" 至 "+statisVo.getEnd()+"销售统计";
        }else if(statisVo.getBegin()==null&&statisVo.getEnd()!=null){
            s+=statisVo.getEnd()+"之前销售统计";
        }else if(statisVo.getBegin()!=null&&statisVo.getEnd()==null){
            s+=statisVo.getBegin()+"之后销售统计";
        }else{
            s+="销售统计";
        }
        map.put("text",s);
        map.put("code", 0);
        map.put("data", llsta);

        return map;
    }

    @RequestMapping("/queryStatisType")
    @ResponseBody
    public Map<String,Object> queryStatisType(StatisVo statis, @RequestParam String page, @RequestParam String limit){
        Map<String,Object> map=new HashMap<String, Object>();
        PageBean pageBean=new PageBean();
        pageBean.setPage(page);
        pageBean.setRows(limit);

        List<Map<String, Object>> maps = statisService.queryStatisList(statis,pageBean);
        Map<String,Object> line=new HashMap<String, Object>();

        float taso = 0;//总计金额  /被除数
        float stato=100;//除数
        float ys=0;//公余数余数
        for (Map<String, Object> st : maps) {
            System.out.println(st.get("y"));
            taso+=Float.parseFloat(st.get("y")+"");
        }

//        Date date=new Date();
//        System.out.println(date.toString());
//        System.out.println("-------------------------------");
        ys=taso/stato;
//        System.out.println("总数："+taso);
//        System.out.println("除数："+stato);
//        System.out.println("余数："+ys);
//        System.out.println("--------------------------------");
        float bcs=0;//保存数率
        String name="";//保存name
        float zs=0;


        List<Map<String,Object>> liSa=new ArrayList<Map<String, Object>>();
        List<List<Map<String,Object>>> llsta=new ArrayList<List<Map<String, Object>>>();


        for (Map<String, Object> st : maps) {
            Map<String,Object> maname=new HashMap<String, Object>();
            bcs=Float.parseFloat(st.get("y")+"")/ys;
            name=st.get("name")+"";
//            may.put("y",bcs);
            maname.put("name",name);
            maname.put("y",bcs);
//            System.out.println("map+========");
//            System.out.println(may.get("y"));
//            System.out.println(maname.get("name"));

//            liSa.add(may);
            liSa.add(maname);

            System.out.println("name:"+name+" , y"+bcs);
            zs+=bcs;

        }
        llsta.add(liSa);
//        System.out.println("概率总数"+zs);

//        for (Map<String, Object> sd : liSa) {
//            System.out.println(sd);
//        }
//        System.out.println("---------LLSTA------------");
//        System.out.println(llsta.get(0));

        String s="";
        if(StringUtils.isNotBlank(statis.getBegin())&&StringUtils.isNotBlank(statis.getEnd())){
            s+=statis.getBegin()+" 至 "+statis.getEnd()+"销售统计";
        }else if(statis.getBegin()==null&&StringUtils.isNotBlank(statis.getEnd())){
            s+=statis.getEnd()+"之前销售统计";
        }else if(statis.getBegin()!=null&&statis.getEnd()==null){
            s+=statis.getBegin()+"之后销售统计";
        }else{
            s+="销售统计";
        }
        map.put("sdata",llsta);
        map.put("text",s);
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageBean.getTotal());
        map.put("data", maps);

        return map;
    }




}
