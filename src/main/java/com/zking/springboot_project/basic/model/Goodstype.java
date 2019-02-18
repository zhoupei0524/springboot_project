package com.zking.springboot_project.basic.model;


import lombok.ToString;

import java.io.Serializable;

@ToString
public class Goodstype implements Serializable{
    private Integer id;

    private String name;

    public Goodstype(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Goodstype() {
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
}