package com.wsl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RestFulController {
    //原来的http://localhost:8080/add?a=1&b=3
    //RestFul风格http://localhost:8080/add/1/3
    //@RequestMapping(value = "/add/{a}/{b}",method = RequestMethod.GET )
    @GetMapping("/add/{a}/{b}")
    public String test1(@PathVariable String  a, @PathVariable int b, Model model){
        String  res=a+b;
        model.addAttribute("msg","结果为:"+res);
        return "hello";
    }
}
