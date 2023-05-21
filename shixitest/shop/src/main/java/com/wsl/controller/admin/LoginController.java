package com.wsl.controller.admin;

import com.wsl.pojo.Admin;
import com.wsl.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/admin/")
public class LoginController {
    @Autowired
    AdminServiceImpl service;
    @RequestMapping("login")
    public String login(Admin admin, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Admin login = service.login(admin);
        if(login!=null){
            request.setAttribute("admin","login");
           request.getRequestDispatcher("/jsp/index.jsp").forward(request,response);
        }else {
            response.getWriter().write("用户名或密码错误！！！");
        }
        return null;
    }
}
