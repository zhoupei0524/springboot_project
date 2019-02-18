package com.zking.springboot_project.basic.controller;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.basic.model.Goods;
import com.zking.springboot_project.basic.model.Store;
import com.zking.springboot_project.basic.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Goods")
public class Goodscontroller {

    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("/queryGoods")
    @ResponseBody
    public Map<String, Object> queryGoods(HttpServletRequest req, Goods goods,
                                          @RequestParam String page,
                                          @RequestParam String limit) {
        PageBean pageBean = new PageBean();
        pageBean.setPage(page);
        pageBean.setRows(limit);
        List<Map<String, Object>> goodsPage = goodsService.queryGoodsPage(goods, pageBean);
        List<Object> list = new ArrayList<>();
        for (Map<String, Object> stringObjectMap : goodsPage) {
            list.add(stringObjectMap);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageBean.getTotal());
        map.put("data", list);
        return map;
    }

    @RequestMapping("/delGoods")
    @ResponseBody
    public Map<String, Object> delGoods(Goods goods) {
        goodsService.deleteByPrimaryKey(goods);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "删除成功");
        return map;
    }
    @RequestMapping("/updateGoods")
    @ResponseBody
    public Map<String, Object> updateGoods(Goods goods) {
        int i = goodsService.updateGoodsById(goods);
        Map<String, Object> map = new HashMap<>();
        if(i!=0){
            map.put("msg", "修改成功");
        }else{
            map.put("msg", "修改失败!!!商品名称重复！");
        }
        return map;
    }
    @RequestMapping("/addGoods")
    @ResponseBody
    public Map<String, Object> addGoods(Goods goods) {
        int insert = goodsService.insert(goods);
        Map<String, Object> map = new HashMap<>();
        if(insert!=0){
            map.put("msg", "增加成功");
        }else{
            map.put("msg", "增加失败!!!商品已存在！");
        }
        return map;
    }

    /**
     * 根据供应商id查询商品
     */
    @RequestMapping("/querygoodsproducer")
    @ResponseBody
    public List<Goods> queryGoodstypeList(Goods goods) {
        List<Goods> list = goodsService.queryGoodsid(goods);
        return list;
    }

    /**
     * 根据商品id查询单价
     */
    @RequestMapping("/querygoodsbyname")
    @ResponseBody
    public List<Goods> queryGoodsbyname(Goods goods) {
        List<Goods> list = goodsService.queryGoodsbyname(goods);
        return list;
    }

    @RequestMapping("/queryGoodsList")
    @ResponseBody
    private  List<Goods> queryGoodsList(){
        List<Goods> querylist = goodsService.querylist();
        return querylist;
    }

    /**
     * 查询所有商品
     */
    @RequestMapping("/queryGood")
    @ResponseBody
    public List<Goods> queryGood() {
        List<Goods> list = goodsService.queryGood();
        return list;
    }


}
