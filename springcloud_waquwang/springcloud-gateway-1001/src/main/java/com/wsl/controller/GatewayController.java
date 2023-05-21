package com.wsl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName GatewayController.java
 * @Description TODO
 * @createTime 2023年03月09日 20:45:00
 */
@RestController
public class GatewayController {
    @RequestMapping("/api/local")
    public String local(){
        System.out.println("在api网关中执行业务逻辑");
        return "exec the api gateway";
    }
}
