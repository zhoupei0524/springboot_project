package com.zking.springboot_project.sys.model;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
public class Emp implements Serializable{
    private Integer id;

    private String username;

    private String password;

    private String realname;

    private String gender;

    private String email;

    private String tele;

    private String address;

    private Date createday;

    private Integer depid;

    private String salt;

    private String photo;

    public Emp(Integer id, String username, String password, String realname, String gender, String email, String tele, String address, Date createday, Integer depid, String salt,String photo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.gender = gender;
        this.email = email;
        this.tele = tele;
        this.address = address;
        this.createday = createday;
        this.depid = depid;
        this.salt = salt;
        this.photo=photo;
    }

    public Emp() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateday() {
        return createday;
    }

    public void setCreateday(Date createday) {
        this.createday = createday;
    }

    public Integer getDepid() {
        return depid;
    }

    public void setDepid(Integer depid) {
        this.depid = depid;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}