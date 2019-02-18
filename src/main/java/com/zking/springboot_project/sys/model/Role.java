package com.zking.springboot_project.sys.model;

public class Role {
    private Integer roleid;

    private String rolename;

    private String remark;

    public Role(Integer roleid, String rolename,String remark) {
        this.roleid = roleid;
        this.rolename = rolename;
        this.remark=remark;
    }

    public Role() {
        super();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}