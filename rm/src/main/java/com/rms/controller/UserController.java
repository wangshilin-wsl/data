package com.rms.controller;

import com.rms.entity.User;
import com.rms.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin///允许跨域
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    //用于处理用户注册方法
    @PostMapping("register")
    public Map<String,Object> register(@RequestBody User user,@RequestParam String code,HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        System.out.println(code);
        System.out.println(user);
        //调用业务方法注册
        try {
            String  key = (String)request.getServletContext().getAttribute("code");
            System.out.println(key);
            if(key.equalsIgnoreCase(code)){
                userService.register(user);
                map.put("state",true);
                map.put("msg","提示：注册成功");
            }else{
                throw new RuntimeException("验证码错误");
            }

        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示："+e.getMessage());
        }

        return map;
    }
    @PostMapping("login")
    public Map<String,Object> login(@RequestBody User user){
        Map<String, Object> map = new HashMap<>();
        //调用业务方法注册
        try {
            User login = userService.login(user);
            map.put("state",true);
            map.put("msg","登录成功!");
            map.put("user",login);
        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示："+e.getMessage());
        }
        return map;
    }
}
