package com.zking.springboot_project.pur.model;

import lombok.ToString;

import java.util.Date;
@ToString
public class Rreturnorders {
    private Integer id;

    private Date createtime;

    private Date checktime;

    private Date endtime;

    private String type;

    private Integer creater;

    private Integer checker;

    private Integer ender;

    private Integer supplierid;

    private Float totalmoney;

    private String state;

    private Integer ordersid;

    private Integer waybillsn;

    public Rreturnorders(Integer id, Date createtime, Date checktime, Date endtime, String type, Integer creater, Integer checker, Integer ender, Integer supplierid, Float totalmoney, String state, Integer ordersid, Integer waybillsn) {
        this.id = id;
        this.createtime = createtime;
        this.checktime = checktime;
        this.endtime = endtime;
        this.type = type;
        this.creater = creater;
        this.checker = checker;
        this.ender = ender;
        this.supplierid = supplierid;
        this.totalmoney = totalmoney;
        this.state = state;
        this.ordersid = ordersid;
        this.waybillsn = waybillsn;
    }

    public Rreturnorders() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
    }

    public Integer getChecker() {
        return checker;
    }

    public void setChecker(Integer checker) {
        this.checker = checker;
    }

    public Integer getEnder() {
        return ender;
    }

    public void setEnder(Integer ender) {
        this.ender = ender;
    }

    public Integer getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Integer supplierid) {
        this.supplierid = supplierid;
    }

    public Float getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Float totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getOrdersid() {
        return ordersid;
    }

    public void setOrdersid(Integer ordersid) {
        this.ordersid = ordersid;
    }

    public Integer getWaybillsn() {
        return waybillsn;
    }

    public void setWaybillsn(Integer waybillsn) {
        this.waybillsn = waybillsn;
    }
}