package com.wsl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName EurekaServer_7001.java
 * @Description TODO
 * @createTime 2022年04月07日 20:38:00
 */
@SpringBootApplication
@EnableEurekaServer//服务端的启动类
public class EurekaServer_7003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7003.class, args);
    }
}
