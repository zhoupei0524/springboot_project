package com.zking.springboot_project.depot.model;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
public class Inventory implements Serializable{

    private Integer id;

    private Integer goodsid;

    private Integer storeid;

    private Integer num;

    private String type;

    private Date createtime;

    private Date checktime;

    private Integer creater;

    private Integer checker;

    private String state;

    private String remark;

    public Inventory(Integer id, Integer goodsid, Integer storeid, Integer num, String type, Date createtime, Date checktime, Integer creater, Integer checker, String state, String remark) {
        this.id = id;
        this.goodsid = goodsid;
        this.storeid = storeid;
        this.num = num;
        this.type = type;
        this.createtime = createtime;
        this.checktime = checktime;
        this.creater = creater;
        this.checker = checker;
        this.state = state;
        this.remark = remark;
    }

    public Inventory() {
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

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}