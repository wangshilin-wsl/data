package com.wsl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//热部署
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
     return "hello，world";
    }
}
