package com.zking.springboot_project.sys.VO;

import com.zking.springboot_project.sys.model.Emp;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class EmpVo extends Emp{

      private String startDay;

      private String endDay;

    private String fileId;

    private MultipartFile img;

    public EmpVo(Integer id, String username, String password, String realname, String gender, String email, String tele, String address,String photo, Date createday, Integer depid, String salt, String startDay, String endDay) {
        super(id, username, password, realname, gender, email, tele, address, createday, depid, salt,photo);
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public EmpVo(String startDay, String endDay,String fileId,MultipartFile img) {
        this.startDay = startDay;
        this.endDay = endDay;
        this.fileId=fileId;
        this.img=img;
    }
    public EmpVo() {
        super();
    }

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

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }
}
