package com.wsl;

import com.wsl.entity.User;
import com.wsl.server.UserServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class TestUserServer {
    @Autowired
    private UserServer userServer;


    @Test
    public void testFindAll(){
        userServer.findAll().forEach(user -> System.out.println(user));
    }

    @Test
    public void testSave(){
        User user=new User();
        user.setName("王小弧");
        user.setBir(new Date());
        user.setSex("女");
        user.setAddress("湖北随州");
        userServer.save(user);
    }
    @Test
    public void delete(){
        String id="14";
        userServer.delete(id);
    }
}
