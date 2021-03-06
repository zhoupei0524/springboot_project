package com.zking.springboot_project.depot.model;

import java.util.Date;

public class Storeoper {
    private Integer id;

    private Integer empid;

    private Date opertime;

    private Integer storeid;

    private Integer goodsid;

    private Integer num;

    private String type;

    public Storeoper(Integer id, Integer empid, Date opertime, Integer storeid, Integer goodsid, Integer num, String type) {
        this.id = id;
        this.empid = empid;
        this.opertime = opertime;
        this.storeid = storeid;
        this.goodsid = goodsid;
        this.num = num;
        this.type = type;
    }

    public Storeoper() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public Date getOpertime() {
        return opertime;
    }

    public void setOpertime(Date opertime) {
        this.opertime = opertime;
    }

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}