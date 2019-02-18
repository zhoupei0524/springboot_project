package com.zking.springboot_project.pur.vo;

import com.zking.springboot_project.pur.model.Orders;

import java.util.Date;

public class OrdersVo extends Orders{

    private String datea;

    private String dateb;

    public String getDatea() {
        return datea;
    }

    public void setDatea(String datea) {
        this.datea = datea;
    }

    public String getDateb() {
        return dateb;
    }

    public void setDateb(String dateb) {
        this.dateb = dateb;
    }

    public OrdersVo(Integer id, Date createtime, Date checktime, Date starttime, Date endtime, String type, Integer creater, Integer checker, Integer starter, Integer ender, Integer supplierid, Float totalmoney, String state, Integer waybills, String datea, String dateb) {
        super(id, createtime, checktime, starttime, endtime, type, creater, checker, starter, ender, supplierid, totalmoney, state, waybills);
        this.datea = datea;
        this.dateb = dateb;
    }

    public OrdersVo(String datea, String dateb) {
        this.datea = datea;
        this.dateb = dateb;
    }
    public OrdersVo(){
        super();
    }
}
