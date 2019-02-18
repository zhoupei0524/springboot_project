package com.zking.springboot_project.sys.controller;

import com.zking.springboot_project.base.util.PageBean;

import com.zking.springboot_project.sys.VO.EmpVo;
import com.zking.springboot_project.sys.model.Emp;
import com.zking.springboot_project.sys.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/emp")
public class Empcontroller {

    @Autowired
    private IEmpService empService;

    @RequestMapping("/queryEmp")
    @ResponseBody
    private Object queryEmp(Emp emp) {
        List<Emp> emps = empService.queryEmp(emp);
        return emps;
    }

    @RequestMapping("/queryEmpPage")
    @ResponseBody
    private Map<String, Object> queryEmpPage(EmpVo emp,
                                             @RequestParam String page,
                                             @RequestParam String limit) {
        PageBean pageBean = new PageBean();
        pageBean.setPage(page);
        pageBean.setRows(limit);
        List<Map<String, Object>> list = empService.queryEmpPage(emp, pageBean);
        List<Object> lis = new ArrayList<>();
        for (Map<String, Object> stringObjectMap : list) {
            lis.add(stringObjectMap);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageBean.getTotal());
        map.put("data", lis);
        return map;
    }

    @RequestMapping("/queryEmpRolePage")
    @ResponseBody
    private Map<String, Object> queryEmpRolePage(EmpVo emp,
                                                 @RequestParam String page,
                                                 @RequestParam String limit) {
        PageBean pageBean = new PageBean();
        pageBean.setPage(page);
        pageBean.setRows(limit);
        List<Map<String, Object>> list = empService.queryEmpRolePage(emp, pageBean);
        List<Object> lis = new ArrayList<>();
        for (Map<String, Object> stringObjectMap : list) {
            lis.add(stringObjectMap);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageBean.getTotal());
        map.put("data", lis);
        return map;
    }

    @RequestMapping("/queryDep")
    @ResponseBody
    public Object queryDep(Emp emp) {
        Emp emp1 = empService.querySingle(emp.getUsername());
        Map<String, Object> map = new HashMap<>();
        if (emp1 != null) {
            map.put("msg", "已存在");
        } else {
            map.put("msg", "没有");
        }
        return map;
    }

    @RequestMapping("/queryDepy")
    @ResponseBody
    public Object queryDepy(Emp emp) {
        Emp emp1 = empService.querySingle(emp.getUsername());
        Map<String, Object> map = new HashMap<>();
        if (emp1 != null) {
            if (emp1.getId() == emp.getId() && emp1.getUsername().equals(emp.getUsername())) {
                map.put("msg", "没有");
            } else {
                map.put("msg", "已存在");
            }
        } else {
            map.put("msg", "没有");
        }
        return map;
    }

    @RequestMapping("/queryDepEmp")
    @ResponseBody
    public Object queryDepEmp(Emp emp) {
        Emp emp1 = empService.querySingle(emp.getUsername());
        return emp1;
    }


    @RequestMapping("/addEmp")
    @ResponseBody
    public Map<String, Object> addEmp(Emp emp) {
        emp.setPassword("123456");
        emp.setPhoto("images/admin.jpg");
        String password = emp.getPassword();
//        String salt = PasswordHelper.createSalt();
//        String credentials = PasswordHelper.createCredentials(password, salt);
//        emp.setPassword(credentials);
//        emp.setSalt(salt);
        emp.setCreateday(new Date());
        Map<String, Object> map = new HashMap<>();
        int insert = empService.insert(emp);
        if (insert != 0) {
            map.put("msg", "增加成功");
        } else {
            map.put("msg", "增加失败!!!用户账号重复！！！");
        }
        return map;
    }


    @RequestMapping("/delEmp")
    @ResponseBody
    public Map<String, Object> delEmp(Emp emp) {
        empService.delEmp(emp);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "删除成功");
        return map;
    }

    @RequestMapping("/updateEmp")
    @ResponseBody
    public Map<String, Object> updateEmp(Emp emp) {
        int i = empService.updateEmp(emp);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "修改成功");
        return map;
    }

//    @RequestMapping("/updatePassword")
//    @ResponseBody
//    public Map<String, Object> updatePassword(Emp emp) {
////        String salt = PasswordHelper.createSalt();
////        String credentials = PasswordHelper.createCredentials(emp.getPassword(), salt);
//        emp.setSalt(salt);
//        emp.setPassword(credentials);
//        int i = empService.updatePassword(emp);
//        Map<String, Object> map = new HashMap<>();
//        map.put("msg", "密码重置成功");
//        return map;
//    }

    @RequestMapping("/queryEmpByRole")
    @ResponseBody
    public List<Emp> queryEmpByRole(Emp emp) {
        List<Emp> emps = empService.queryEmpByRole(emp);
        return emps;
    }


    @RequestMapping("/editUser")
    @ResponseBody
    public Map<String, Object> editUser(Emp emp, @RequestParam String day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        emp.setCreateday(date);
        int i = empService.editUser(emp);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "修改成功");
        return map;
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Map<String, Object> upload(HttpServletRequest request, MultipartFile file) {
        Map<String, Object> map = new HashMap<>();
        if (null != file) {
            String filePath = file.getOriginalFilename();
            String pat = "E://y2/SSM_Project/SSM_ERP/src/main/webapp/images/photo/";//获取文件保存路径
            String Path = pat + filePath;
            File fileDir = new File(Path);
            if (!fileDir.exists()) { //如果不存在 则创建
                fileDir.mkdirs();
                try {
                    file.transferTo(new File(Path));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Emp emp = new Emp();
            Emp user = (Emp) request.getSession().getAttribute("User");
            emp.setId(user.getId());
            emp.setPhoto("images/photo/" + filePath);
            empService.editPhoto(emp);
            map.put("msg", "上传成功");
        } else {
            map.put("msg", "文件为空");
        }
        return map;
    }

    @RequestMapping("/queryloginEmp")
    @ResponseBody
    public Map<String, Object> queryloginEmp(HttpServletRequest request, Emp emp) {
        Map<String, Object> map = new HashMap<>();
        //获取Session登陆用户
        Emp user = (Emp) request.getSession().getAttribute("User");
        System.out.println(user);
//        String credentials = PasswordHelper.createCredentials(emp.getPassword(), user.getSalt());
//        boolean b = PasswordHelper.checkCredentials(emp.getPassword(), user.getSalt(), credentials);
//        if (b) {
//            map.put("msg", "密码正确");
//        } else {
//            map.put("msg", "密码错误");
//        }
        return map;
    }


}
