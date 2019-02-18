package com.zking.springboot_project.basic.model;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class Supplier implements Serializable{
    private Integer id;

    private String name;

    private String address;

    private String contact;

    private String tele;

    private String email;

    private String type;

    public Supplier(Integer id, String name, String address, String contact, String tele, String email, String type) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.tele = tele;
        this.email = email;
        this.type = type;
    }

    public Supplier() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}