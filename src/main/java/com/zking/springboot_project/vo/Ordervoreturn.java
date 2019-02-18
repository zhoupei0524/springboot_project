package com.zking.springboot_project.vo;

import com.zking.springboot_project.pur.model.Orders;

import java.util.Date;

public class Ordervoreturn extends Orders{

    private Date datea;
    private Date dateb;

    public Date getDatea() {
        return datea;
    }

    public void setDatea(Date datea) {
        this.datea = datea;
    }

    public Date getDateb() {
        return dateb;
    }

    public void setDateb(Date dateb) {
        this.dateb = dateb;
    }

    public Ordervoreturn() {

    }
}
