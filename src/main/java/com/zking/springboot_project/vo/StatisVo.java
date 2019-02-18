package com.zking.springboot_project.vo;

import com.zking.springboot_project.pur.model.Statis;

public class StatisVo extends Statis {

    private String begin;

    private String end;

    public void setEnd(String end) {
        this.end = end;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public String getBegin() {
        return begin;
    }

    @Override
    public String toString() {
        return super.toString()+",begin="+this.getBegin()+",end="+this.getEnd();
    }
}
