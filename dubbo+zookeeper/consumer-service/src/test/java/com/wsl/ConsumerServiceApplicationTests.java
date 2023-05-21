package com.wsl;

import com.wsl.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerServiceApplicationTests {
    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        userService.buyTicket();
    }

}
