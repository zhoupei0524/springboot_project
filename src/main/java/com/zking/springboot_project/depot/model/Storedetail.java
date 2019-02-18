package com.zking.springboot_project.depot.model;

public class Storedetail {
    private Integer id;

    private Integer storeid;

    private Integer goodid;

    private Integer num;

    public Storedetail(Integer id, Integer storeid, Integer goodid, Integer num) {
        this.id = id;
        this.storeid = storeid;
        this.goodid = goodid;
        this.num = num;
    }

    public Storedetail() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}