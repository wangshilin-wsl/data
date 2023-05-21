package com.wsl.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName ConfigClientController.java
 * @Description TODO
 * @createTime 2022年04月25日 21:51:00
 */
@RestController
public class ConfigClientController {
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;

    @Value("${server.port}")
    private String port;
    @RequestMapping("/config")
    public String getConfig(){
        return "applicationName:" +applicationName+
                "eurekaServer:" +eurekaServer+
                "port:" +port;
    }
}
