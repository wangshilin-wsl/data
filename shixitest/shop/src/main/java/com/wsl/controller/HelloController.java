package com.wsl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(HttpServletRequest request){
        request.setAttribute("msg","hello springmvc");
        return "hello";
    }
}
