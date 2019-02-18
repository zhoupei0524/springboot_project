package com.zking.springboot_project.basic.controller;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.basic.model.Goodstype;
import com.zking.springboot_project.basic.service.IGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Goodstype")
public class Goodstypecontroller {

    @Autowired
    private IGoodsTypeService goodsTypeService;

    /**
     * 分页查询商品类型
     */
    @RequestMapping("/queryGoodstypeListPage")
    @ResponseBody
    public Map<String, Object> queryGoodstypeListPage(Goodstype goodstype,
                                                 @RequestParam String page,
                                                 @RequestParam String limit) {
        PageBean pageBean = new PageBean();
        pageBean.setPage(page);
        pageBean.setRows(limit);
        List<Goodstype> goodstypes = goodsTypeService.queryListPage(goodstype, pageBean);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageBean.getTotal());
        map.put("data", goodstypes);
        return map;
    }


    /**
     * 查询商品类型
     */
    @RequestMapping("/queryGoodstypeList")
    @ResponseBody
    public List<Goodstype> queryGoodstypeList(Goodstype goodstype) {
        List<Goodstype> goodstypes = goodsTypeService.queryList(goodstype);
        return goodstypes;
    }

    @RequestMapping("/delGoodstype")
    @ResponseBody
    public Map<String, Object> delGoodstype(Goodstype goodstype) {
        goodsTypeService.deleteByPrimaryKey(goodstype.getId());
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "删除成功");
        return map;
    }

    @RequestMapping("/updateGoodstype")
    @ResponseBody
    public Map<String, Object> updateGoodstype(Goodstype goodstype) {
        int i = goodsTypeService.updateByPrimaryKey(goodstype);
        Map<String, Object> map = new HashMap<>();
        if(i!=0){
            map.put("msg", "修改成功");
        }else{
            map.put("msg", "修改失败!!!该商品类型已存在");
        }
        return map;
    }

   // @RequiresRoles(value = "采购员")
    @RequestMapping("/addGoodstype")
    @ResponseBody
    public Map<String, Object> addGoodstype(Goodstype goodstype) {
        int insert = goodsTypeService.insert(goodstype);
        Map<String, Object> map = new HashMap<>();
        if(insert!=0){
            map.put("msg", "增加成功");
        }else{
            map.put("msg", "增加失败!!!该商品类型已存在");
        }
        return map;
    }


}
