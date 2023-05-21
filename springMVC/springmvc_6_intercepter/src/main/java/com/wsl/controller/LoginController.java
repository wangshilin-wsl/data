package com.wsl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    }
    @RequestMapping("/login")
    public String login(HttpSession session,String username, String password){
        session.setAttribute("userLoginInfo",username);
        return "main";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/goOut")
    public String out(HttpSession session){
       session.removeAttribute("userLoginInfo");
       return "main";
    }
}
