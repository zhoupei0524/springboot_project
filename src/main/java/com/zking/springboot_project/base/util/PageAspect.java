package com.zking.springboot_project.base.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class PageAspect {

    @Around("execution(* *..*Service.*Page(..))")
    public Object invoke(ProceedingJoinPoint args) throws Throwable {
        Object[] params = args.getArgs();
        PageBean pageBean=null;
        for (Object param : params) {
            if(param instanceof  PageBean){
                pageBean=(PageBean) param;
                break;
            }
        }
        //设置分页参数
        if(null!=pageBean&&pageBean.isPagination())
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        //执行方法

        Object Result = args.proceed(params);

        //设置PageBean总记录数
        if(null!=pageBean&&pageBean.isPagination()){
            List list=(List) Result;
            PageInfo pageInfo=new PageInfo(list);
            pageBean.setTotal(pageInfo.getTotal()+"");
           //System.out.println("总记录数为："+pageBean.getTotal()+";当前页码："+pageBean.getPage()+";每页打印"+pageBean.getRows()+"条。");
        }

        return Result;
    }

}
