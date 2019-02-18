package com.zking.springboot_project.basic.model;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class Store implements Serializable {

    private Integer id;

    private String name;

    private Integer empid;

    private String address;

    public Store(Integer id, String name, Integer empid,String address) {
        this.id = id;
        this.name = name;
        this.empid = empid;
        this.address=address;
    }

    public Store() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}