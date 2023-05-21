package com.wsl.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsl.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {
    @RequestMapping("/t1")
    public String test() {
        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1:param=" + name);
        if ("kuangshen".equals(name)) {
            response.getWriter().print("true");
        } else {
            response.getWriter().print("false");
        }
    }

    @RequestMapping("a2")
    public List<User> a2() {
        ObjectMapper mapper = new ObjectMapper();
        List<User> list = new ArrayList<>();
        //添加数据
        list.add(new User("狂神说Java", 1, "男"));
        list.add(new User("前端", 2, "女"));
        list.add(new User("运维", 3, "男"));
        return list;
    }

    @RequestMapping("/a3")
    public String a3(String name, String pwd) {
        String msg="";
        if (name != null) {
            if ("admin".equals(name)) {
                msg = "ok";
            } else {
                msg = "用户名有误";
            }
        }
        if (pwd != null) {
            if ("123456".equals(pwd)) {
                msg = "ok";
            } else {
                msg = "密码有误";
            }
        }
        return msg;
    }
}
