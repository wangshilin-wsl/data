package com.wsl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName ConfigController.java
 * @Description TODO
 * @createTime 2023年03月16日 21:25:00
 */
@RestController
public class ConfigController {
    @Resource
    private Environment environment;

    @Value("${url}")
    private String url;
    @RequestMapping("/cloud/url")
    public String url(){
        return url;
    }

    @RequestMapping("/cloud/url1")
    public String url1(){
        return environment.getProperty("url");
    }
}
