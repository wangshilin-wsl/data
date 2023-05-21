package com.wsl.controller;

import com.wsl.mapper.UserMapper;
import com.wsl.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/query")
    public User queryUserList(){
        User list = userMapper.queryUserById(1);
        return list;
    }
}
