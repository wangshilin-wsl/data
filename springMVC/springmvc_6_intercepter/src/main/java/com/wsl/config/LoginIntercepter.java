package com.wsl.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(request.getRequestURI().contains("goLogin")){
            return true;
        }
        if(request.getRequestURI().contains("login")){
            return true;
        }
        //放心的判断及登录了,第一次此登录也是没有session的
      if(session.getAttribute("userLoginInfo")!=null){
          return true;
      }
      request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        //判断什么情况下没有登录
        return false;

    }
}
