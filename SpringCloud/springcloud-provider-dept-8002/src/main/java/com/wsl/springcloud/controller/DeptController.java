package com.wsl.springcloud.controller;

import com.wsl.springcloud.pojo.Dept;
import com.wsl.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Autowired
    private DiscoveryClient client;//获取一些配置信息，得到具体的微服务

    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }

    //注册进来的微服务，获取一些消息
    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获取微服务列表的清单
        final List<String> services = client.getServices();
        System.out.println("discovery=>services:" + services);

        //得到一个具体的微服务信息，通过具体的微服务id，applicationName
        final List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PRIVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri() + "\t" +
                    instance.getServiceId()
            );
        }
        return this.client;
    }
}
