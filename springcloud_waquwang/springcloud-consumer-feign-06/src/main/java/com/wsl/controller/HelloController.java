package com.wsl.controller;

import com.wsl.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName HelloController.java
 * @Description TODO
 * @createTime 2023年03月02日 20:07:00
 */
@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/web/hello")
    public String hello(){
        //逻辑判断（省略）
        //调用springcloud提供的类
        //return restTemplate.getForEntity("http://localhost:8001/service/hello", String.class).getBody();

        //feign调用
        return helloService.hello();
    }
}
