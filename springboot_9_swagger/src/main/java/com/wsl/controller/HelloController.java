package com.wsl.controller;

import com.wsl.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello";
    }
    //只要我们的接口返回值中存在实体类，他就会被扫描到Swagger中
    @PostMapping(value = "/user")
    public User user(){
        return new User();
    }
    //Operation接口，不是放在类上面的
    @ApiOperation("Hello控制类")
    @GetMapping("/hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello"+username;
    }

    @ApiOperation("Post测试类")
    @PostMapping("/post")
    public User hello2(@ApiParam("用户") User user){
        return user;
    }
}
