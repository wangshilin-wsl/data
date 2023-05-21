package com.wsl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//被这个注解的类中的所有方法，如果返回值是string，并且有具体页面可以跳转，那么就会被视图解析器解析
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model){
        //封装数据

        model.addAttribute("msg","Hello,SpringMVCAnnotation!");
        return "hello";//会被视图解析器处理
    }
}
