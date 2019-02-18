package com.zking.springboot_project.sys.service.impl;

import com.zking.springboot_project.SpringbootProjectApplicationTests;
import com.zking.springboot_project.sys.model.Module;
import com.zking.springboot_project.sys.service.IModuleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ModuleServiceImplTest extends SpringbootProjectApplicationTests {

    @Autowired
    private IModuleService moduleService;

    private Module module;

//    @Test
//    public void queryModuleMap() {
//        List<Map<String, Object>> list =
//                moduleService.queryModuleMap(module);
//        System.out.println(list);
//    }
}