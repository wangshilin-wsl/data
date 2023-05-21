package com.wsl.controller;

import com.wsl.domain.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName HelloController.java
 * @Description TODO
 * @createTime 2023年02月15日 22:47:00
 */
@RestController
public class HelloController {
    @RequestMapping("/service/hello")
    public String hello() throws InterruptedException {
        //进行业务处理(省略)
        //模拟提供者发生异常
//        int i = 1 / 0;
        System.out.println("服务提供者1");
        return "Hello, spring cloud, provider1";
    }
    @RequestMapping("/service/user")
    public User user() {
        //进行业务处理(省略)
        User user = new User();
        user.setId(1);
        user.setName("张三");
        user.setPhone("110");
        System.out.println("服务提供者1");
        return user;
    }

    @RequestMapping("/service/getUser")
    public User getuser(@RequestParam("id")Integer id, @RequestParam("name")String name, @RequestParam("phone")String phone) {
        //进行业务处理(省略)
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);
        System.out.println("服务提供者1");
        return user;
    }

    @PostMapping("/service/addUser")
    public User addUser(@RequestParam("id")Integer id, @RequestParam("name")String name, @RequestParam("phone")String phone) {
        //进行业务处理(省略)
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);
        System.out.println("服务提供者1");
        return user;
    }
    @PostMapping("/service/addUserForJson")
    public User addUserForJson(@RequestBody User user) {
        //进行业务处理(省略)
        System.out.println("服务提供者1");
        return user;
    }
}
