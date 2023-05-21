package com.wsl.controller;

import com.wsl.entity.User;
import com.wsl.service.UserServiceImpl;
import com.wsl.utils.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin///允许跨域
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    //生成验证码图片
    @GetMapping("getImage")
    public String getImageCode(HttpServletRequest request) throws IOException {
        //1.使用工具类生成验证码
        String code = VerifyCodeUtils.generateVerifyCode(4);
        //2.放入servletContext作用域
        request.getServletContext().setAttribute("code",code);
        //3.将我们的图片转为base64
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        VerifyCodeUtils.outputImage(220,60,stream,code);
        String s = "data:image/png;base64,"+Base64Utils.encodeToString(stream.toByteArray());
        return s;
    }
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
