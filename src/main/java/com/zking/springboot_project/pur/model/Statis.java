package com.zking.springboot_project.pur.model;

import lombok.ToString;

import java.util.Date;

@ToString
public class Statis {
    private Date endtime;

    private Integer goodsid;

    private Float money;

    private Integer goodtypeid;

    private String goodtypename;

    public Statis(Date endtime, Integer goodsid, Float money, Integer goodtypeid, String goodtypename) {
        this.endtime = endtime;
        this.goodsid = goodsid;
        this.money = money;
        this.goodtypeid = goodtypeid;
        this.goodtypename = goodtypename;
    }

    public Statis() {
        super();
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getGoodtypeid() {
        return goodtypeid;
    }

    public void setGoodtypeid(Integer goodtypeid) {
        this.goodtypeid = goodtypeid;
    }

    public String getGoodtypename() {
        return goodtypename;
    }

    public void setGoodtypename(String goodtypename) {
        this.goodtypename = goodtypename;
    }
}