package com.zking.springboot_project.sys.model;

public class RoleModule {
    private String roleid;

    private Integer moduleid;

    public RoleModule(String roleid, Integer moduleid) {
        this.roleid = roleid;
        this.moduleid = moduleid;
    }

    public RoleModule() {
        super();
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public Integer getModuleid() {
        return moduleid;
    }

    public void setModuleid(Integer moduleid) {
        this.moduleid = moduleid;
    }
}