package com.zking.springboot_project.depot.vo;

import com.zking.springboot_project.depot.model.Inventory;
import lombok.ToString;

import java.util.Date;

@ToString
public class InventoryVo extends Inventory{

    private String registerstartDay;

    private String registerendDay;

    private String checkstartDay;

    private String checkendDay;


    public String getRegisterstartDay() {
        return registerstartDay;
    }

    public void setRegisterstartDay(String registerstartDay) {
        this.registerstartDay = registerstartDay;
    }

    public String getRegisterendDay() {
        return registerendDay;
    }

    public void setRegisterendDay(String registerendDay) {
        this.registerendDay = registerendDay;
    }

    public String getCheckstartDay() {
        return checkstartDay;
    }

    public void setCheckstartDay(String checkstartDay) {
        this.checkstartDay = checkstartDay;
    }

    public String getCheckendDay() {
        return checkendDay;
    }

    public void setCheckendDay(String checkendDay) {
        this.checkendDay = checkendDay;
    }


    public InventoryVo(Integer id, Integer goodsid, Integer storeid, Integer num, String type, Date createtime, Date checktime, Integer creater, Integer checker, String state, String remark, String registerstartDay, String registerendDay, String checkstartDay, String checkendDay) {
        super(id, goodsid, storeid, num, type, createtime, checktime, creater, checker, state, remark);
        this.registerstartDay = registerstartDay;
        this.registerendDay = registerendDay;
        this.checkstartDay = checkstartDay;
        this.checkendDay = checkendDay;
    }

    public InventoryVo(String registerstartDay, String registerendDay, String checkstartDay, String checkendDay) {
        this.registerstartDay = registerstartDay;
        this.registerendDay = registerendDay;
        this.checkstartDay = checkstartDay;
        this.checkendDay = checkendDay;
    }

    public InventoryVo() {
        super();
    }
}
