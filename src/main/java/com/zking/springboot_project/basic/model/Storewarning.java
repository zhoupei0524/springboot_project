package com.zking.springboot_project.basic.model;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class Storewarning implements Serializable{
    private Integer id;

    private Integer goodid;

    private String goodname;

    private Integer num;

    private Integer dropnum;

    public Storewarning(Integer id, Integer goodid, String goodname, Integer num, Integer dropnum) {
        this.id = id;
        this.goodid = goodid;
        this.goodname = goodname;
        this.num = num;
        this.dropnum = dropnum;
    }

    public Storewarning() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getDropnum() {
        return dropnum;
    }

    public void setDropnum(Integer dropnum) {
        this.dropnum = dropnum;
    }
}