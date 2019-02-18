package com.zking.springboot_project.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Indexcontroller {

    @RequestMapping("/")
    public String toindex(){
        return "index";
    }

    @RequestMapping("/basic/goodstype.jsp")
    public String toindexs(){
        return "basic/goodstype";
    }

    @RequestMapping("/basic/goods.jsp")
    public String togoods(){
        return "basic/goods";
    }

    @RequestMapping("/basic/supplier.jsp")
    public String tosupplier(){
        return "basic/supplier";
    }

    @RequestMapping("/basic/customer.jsp")
    public String tocustomer(){
        return "basic/customer";
    }

    @RequestMapping("/basic/store.jsp")
    public String tostore(){
        return "basic/store";
    }

    @RequestMapping("/basic/goodstypeadd.jsp")
    public String togoodstypeadd(){
        return "basic/goodstypeadd";
    }

    @RequestMapping("/basic/goodstypeedit.jsp")
    public String togoodstypeedit(){
        return "basic/goodstypeedit";
    }

    @RequestMapping("/basic/goodsDateil.jsp")
    public String togoodsDateil(){
        return "basic/goodsDateil";
    }

    @RequestMapping("/basic/goodsedit.jsp")
    public String togoodsedit(){
        return "basic/goodsedit";
    }

    @RequestMapping("/basic/supplieredit.jsp")
    public String supplieredit(){
        return "basic/supplieredit";
    }

    @RequestMapping("/basic/storeedit.jsp")
    public String storeedit(){
        return "basic/storeedit";
    }

    @RequestMapping("/personnel/depManage.jsp")
    public String depManage(){
        return "personnel/depManage";
    }

    @RequestMapping("/personnel/depDateil.jsp")
    public String depDateil(){
        return "personnel/depDateil";
    }

    @RequestMapping("/personnel/empManage.jsp")
    public String empManage(){
        return "personnel/empManage";
    }

    @RequestMapping("/personnel/empDateil.jsp")
    public String empDateil(){
        return "personnel/empDateil";
    }

    @RequestMapping("/personnel/empSet.jsp")
    public String empSet(){
        return "personnel/empSet";
    }

    @RequestMapping("/personnel/empedit.jsp")
    public String empedit(){
        return "personnel/empedit";
    }

    @RequestMapping("/depot/storeManage.jsp")
    public String storeManage(){
        return "depot/storeManage";
    }

    @RequestMapping("/depot/storeoper.jsp")
    public String storeoper(){
        return "depot/storeoper";
    }

    @RequestMapping("/depot/inventory.jsp")
    public String inventory(){
        return "depot/inventory";
    }

    @RequestMapping("/depot/inventoryedit.jsp")
    public String inventoryedit(){
        return "depot/inventoryedit";
    }

    @RequestMapping("/hac/statis.jsp")
    public String statis(){
        return "hac/statis";
    }

    @RequestMapping("/hac/tendency.jsp")
    public String tendency(){
        return "hac/tendency";
    }

    @RequestMapping("/role/empRole.jsp")
    public String empRole(){
        return "role/empRole";
    }

    @RequestMapping("/role/roleModule.jsp")
    public String roleModule(){
        return "role/roleModule";
    }

    @RequestMapping("/role/empRoleSet.jsp")
    public String empRoleSet(){
        return "role/empRoleSet";
    }

    @RequestMapping("/role/RoleSet.jsp")
    public String RoleSet(){
        return "role/RoleSet";
    }

    @RequestMapping("/role/modulea.jsp")
    public String modulea(){
        return "role/modulea";
    }

    @RequestMapping("/tomain")
    public String tomain(){
        return "main";
    }

    @RequestMapping("/addchance")
    public String addchance(){
        return "sal/addChance";
    }
}
