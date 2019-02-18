package com.zking.springboot_project.personnel.model;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class Dep implements Serializable{
    private Integer id;

    private String name;

    private String tele;

    public Dep(Integer id, String name, String tele) {
        this.id = id;
        this.name = name;
        this.tele = tele;
    }

    public Dep() {
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

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }
}