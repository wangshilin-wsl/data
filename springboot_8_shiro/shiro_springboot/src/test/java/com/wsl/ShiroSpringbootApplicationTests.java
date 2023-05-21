package com.wsl;

import com.wsl.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroSpringbootApplicationTests {
    @Autowired
    private UserServiceImpl userService;
    @Test
    void contextLoads() {
        System.out.println(userService.queryUserByName("张三"));
    }

}
