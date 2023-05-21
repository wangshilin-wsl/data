package com.wsl.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.wsl.entity.User;
import com.wsl.service.UserService;
import com.wsl.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/user/login")
    public Map<String, Object> login(User user){
        log.info("用户名：[{}]",user.getName());
        log.info("密码：[{}]",user.getPassword());
        HashMap<String, Object> map = new HashMap<>();
        try {
            User login = userService.login(user);
            Map<String,String> temp=new HashMap<>();
            temp.put("id",login.getId());
            temp.put("name",login.getName());
            //生成jwt令牌
            String token = JWTUtils.getToken(temp);
            map.put("state",true);
            map.put("msg","登录成功！！！");
            map.put("token",token);//相应token
        }catch (Exception e){
            map.put("state",false);
            map.put("msg",e.getMessage());
        }
        return map;
    }
    @PostMapping("/user/test")
    public Map<String,Object> test(HttpServletRequest request){
        //处理业务逻辑
        HashMap<String, Object> map = new HashMap<>();
        //拿到请求头里面的token
        String token = request.getHeader("token");
        DecodedJWT verify = JWTUtils.verify(token);
        log.info("用户id:[{}]",verify.getClaim("id").asString());
        log.info("用户id:[{}]",verify.getClaim("name").asString());
        map.put("state",true);
        map.put("msg","请求成功！！！");
       return map;
    }
}
