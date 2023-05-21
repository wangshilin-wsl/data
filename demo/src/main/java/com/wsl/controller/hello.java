package com.wsl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class hello {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
