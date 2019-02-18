package com.zking.springboot_project.basic.controller;

import com.zking.springboot_project.base.util.PageBean;
import com.zking.springboot_project.basic.model.Supplier;
import com.zking.springboot_project.basic.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/supplier")
public class Suppliercontroller {

    @Autowired
    private ISupplierService supplierService;
    //分页
    @RequestMapping("/querySupplierPage")
    @ResponseBody
    public Map<String, Object> querySupplierPage(Supplier supplier,
                                                 @RequestParam String page,
                                                 @RequestParam String limit) {
        PageBean pageBean = new PageBean();
        pageBean.setPage(page);
        pageBean.setRows(limit);
        List<Supplier> suppliers = supplierService.querySupplierPage(supplier, pageBean);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageBean.getTotal());
        map.put("data", suppliers);
        return map;
    }

    //不分页
    @RequestMapping("/querySupplier")
    @ResponseBody
    public Object querySupplier(Supplier supplier) {
        List<Supplier> suppliers = supplierService.querySupplier(supplier);
        return suppliers;
    }

    @RequestMapping("/delsupplier")
    @ResponseBody
    public Map<String, Object> delsupplier(Supplier supplier) {
        supplierService.deleteSupplierByID(supplier.getId());
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "删除成功");
        return map;
    }

    @RequestMapping("/updatesupplier")
    @ResponseBody
    public Map<String, Object> updatesupplier(Supplier supplier) {
        int i = supplierService.updateSupplierByID(supplier);
        Map<String, Object> map = new HashMap<>();
        if(i!=0){
            map.put("msg","修改成功");
        } else{
            map.put("msg", "修改失败!!!名称不可重复");
        }
        return map;
    }

    @RequestMapping("/addsupplier")
    @ResponseBody
    public Map<String, Object> addsupplier(Supplier supplier) {
        int insert = supplierService.insert(supplier);
        Map<String, Object> map = new HashMap<>();
        if(insert!=0){
            map.put("msg","增加成功");
        } else{
            map.put("msg", "增加失败!!!名称不可重复");
        }
        return map;
    }

    /**
     * 分页查询商品类型
     */
    @RequestMapping("/querysupplierList")
    @ResponseBody
    public List<Supplier> queryGoodstypeList(Supplier supplier) {
        List<Supplier> list = supplierService.querySupplierlst(supplier);
        return list;
    }


    /**
     * 查询所有客户
     */
    @RequestMapping("/querysupplierclient")
    @ResponseBody
    public List<Supplier> querysupplierclient(Supplier supplier) {
        List<Supplier> list = supplierService.querySupplierclient();
        return list;
    }











}
