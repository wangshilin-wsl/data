package com.wsl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ModelTest1 {
    @RequestMapping("/m1/t1")
    public String test(HttpServletRequest request, HttpServletResponse response){
        HttpSession httpSession=request.getSession();
        System.out.println(httpSession.getId());
        return "redirect:/index.jsp";
    }
}
