package com.zking.springboot_project.pur.model;

import lombok.ToString;

@ToString
public class Shopcart {
    private Integer cartid;

    private Integer userid;

    private Integer goodid;

    private String goodname;

    private Float unitprice;

    private Integer num;

    private Float subtotal;

    private Integer state;

    public Shopcart(Integer cartid, Integer userid, Integer goodid, String goodname, Float unitprice, Integer num, Float subtotal, Integer state) {
        this.cartid = cartid;
        this.userid = userid;
        this.goodid = goodid;
        this.goodname = goodname;
        this.unitprice = unitprice;
        this.num = num;
        this.subtotal = subtotal;
        this.state = state;
    }

    public Shopcart() {
        super();
    }

    public Integer getCartid() {
        return cartid;
    }

    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public Float getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Float unitprice) {
        this.unitprice = unitprice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}