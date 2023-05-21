package com.wsl.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wsl.springcloud.pojo.Dept;
import com.wsl.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName DeptController.java
 * @Description 提供restful服务
 * @createTime 2022年04月03日 14:25:00
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Long id){
        final Dept dept = deptService.queryById(id);
        if(dept == null){
            throw new RuntimeException("id=>"+id+"，不存在该用户，或者信息无法找到");
        }
        return dept;
    }

    //备选方法，请求上面方法发生异常就会运行一下代码
    public Dept hystrixGet(@PathVariable("id") Long id){
        return new Dept()
                .setDeptno(id)
                .setDname("id=>"+id+"，不存在该用户，或者信息无法找到")
                .setDb_source("no this database in mysql");
    }
}
