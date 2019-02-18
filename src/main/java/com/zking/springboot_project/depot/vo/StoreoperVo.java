package com.zking.springboot_project.depot.vo;

import com.zking.springboot_project.depot.model.Storeoper;
import lombok.ToString;

import java.util.Date;

@ToString
public class StoreoperVo extends Storeoper{

    private String startDay;

    private String endDay;

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public StoreoperVo(Integer id, Integer empid, Date opertime, Integer storeid, Integer goodsid, Integer num, String type, String startDay, String endDay) {
        super(id, empid, opertime, storeid, goodsid, num, type);
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public StoreoperVo() {
        super();
    }
}
