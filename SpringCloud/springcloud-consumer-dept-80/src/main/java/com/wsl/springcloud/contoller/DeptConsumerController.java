package com.wsl.springcloud.contoller;

import com.wsl.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName DeptConsumerController.java
 * @Description TODO
 * @createTime 2022年04月07日 19:42:00
 */
@RestController
public class DeptConsumerController {
    //消费者，不应该有service层
    //RestTemplate,供我们直接调用
    //(url,实体：map, Class<T> responseType)
    @Autowired
    RestTemplate restTemplate;//提供多种便捷访问远程http服务的方法，简单的RestFul服务模板

    //ribbon,我们这里的地址，应该是一个变量，通过服务名来方问
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    //http://127.0.0.1:8001/dept/get/{id}
    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }
    @PostMapping("/consumer/dept/add")
    public boolean addDept(@RequestBody Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add" , dept, Boolean.class);
    }
    @GetMapping("/consumer/dept/list")
    public List<Dept> queryAll(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }
}
