package com.zking.springboot_project.pur.model;

import lombok.ToString;

import java.util.Date;
@ToString
public class Returnorderdetail {
    private Integer id;

    private Integer goodsid;

    private Float price;

    private Integer num;

    private Float money;

    private Date endtime;

    private Integer ender;

    private Integer storeid;

    private String start;

    private Integer ordersid;

    private String goodsname;

    public Returnorderdetail(Integer id, Integer goodsid, Float price, Integer num, Float money, Date endtime, Integer ender, Integer storeid, String start, Integer ordersid,String goodsname) {
        this.id = id;
        this.goodsid = goodsid;
        this.price = price;
        this.num = num;
        this.money = money;
        this.endtime = endtime;
        this.ender = ender;
        this.storeid = storeid;
        this.start = start;
        this.ordersid = ordersid;
        this.goodsname = goodsname;
    }

    public Returnorderdetail() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getEnder() {
        return ender;
    }

    public void setEnder(Integer ender) {
        this.ender = ender;
    }

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public Integer getOrdersid() {
        return ordersid;
    }

    public void setOrdersid(Integer ordersid) {
        this.ordersid = ordersid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }
}