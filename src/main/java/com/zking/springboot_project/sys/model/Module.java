package com.zking.springboot_project.sys.model;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class Module implements Serializable{
    private String id;

    private Integer pid;

    private String text;

    private String icon;

    private String url;

    private Integer sort;

    public Module(String id, Integer pid, String text, String icon, String url, Integer sort) {
        this.id = id;
        this.pid = pid;
        this.text = text;
        this.icon = icon;
        this.url = url;
        this.sort = sort;
    }


    public Module() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}