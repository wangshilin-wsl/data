package com.wsl.controller;

import com.wsl.pojo.Userinfo;
import com.wsl.service.UserinfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserinfoController {
    @Autowired
    UserinfoServiceImpl userinfoService;
    @RequestMapping("/dologin")
    public String dologin(Userinfo userinfo, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Userinfo login = userinfoService.login(userinfo);
        if(login!=null){
            request.getSession().setAttribute("loginuser",login);
            return "redirect:/index";
        }else {
            response.setContentType("text/html;charset=utf-8");
           response.getWriter().write("<script>alert('登录失败');history.go(-1);</script>");
           return null;
        }
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/regist")
    public String regist(){
        return "regist";
    }
    @RequestMapping("/doreg")
    public String doerg(Userinfo userinfo, HttpServletRequest request, HttpServletResponse response) throws IOException {
        int i = userinfoService.register(userinfo);
        if(i>0){
            return "redirect:/login";
        }else if(i==-1){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('用户名重复');history.go(-1);</script>");
            return null;
        }
        else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('注册失败');history.go(-1);</script>");
            return null;
        }
    }
}
