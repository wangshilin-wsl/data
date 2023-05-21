package com.wsl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName Config_Server_3344.java
 * @Description TODO
 * @createTime 2022年04月24日 19:39:00
 */
@SpringBootApplication
@EnableConfigServer
public class Config_Server_3344 {
    public static void main(String[] args) {
        SpringApplication.run(Config_Server_3344.class, args);
    }
}
