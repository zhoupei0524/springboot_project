package com.zking.springboot_project.pur.model;

import lombok.ToString;

import java.util.Date;
@ToString
public class Orders {
    private Integer id;

    private Date createtime;

    private Date checktime;

    private Date starttime;

    private Date endtime;

    private String type;

    private Integer creater;

    private Integer checker;

    private Integer starter;

    private Integer ender;

    private Integer supplierid;

    private Float totalmoney;

    private String state;

    private Integer waybills;

    public Orders(Integer id, Date createtime, Date checktime, Date starttime, Date endtime, String type, Integer creater, Integer checker, Integer starter, Integer ender, Integer supplierid, Float totalmoney, String state, Integer waybills) {
        this.id = id;
        this.createtime = createtime;
        this.checktime = checktime;
        this.starttime = starttime;
        this.endtime = endtime;
        this.type = type;
        this.creater = creater;
        this.checker = checker;
        this.starter = starter;
        this.ender = ender;
        this.supplierid = supplierid;
        this.totalmoney = totalmoney;
        this.state = state;
        this.waybills = waybills;
    }

    public Orders() {
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

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
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

    public Integer getStarter() {
        return starter;
    }

    public void setStarter(Integer starter) {
        this.starter = starter;
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

    public Integer getWaybills() {
        return waybills;
    }

    public void setWaybills(Integer waybills) {
        this.waybills = waybills;
    }
}