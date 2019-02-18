package com.zking.springboot_project.sys.model;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class EmpRole implements Serializable{
    private Integer roleid;

    private Integer empid;

    public EmpRole(Integer roleid, Integer empid) {
        this.roleid = roleid;
        this.empid = empid;
    }

    public EmpRole() {
        super();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }
}