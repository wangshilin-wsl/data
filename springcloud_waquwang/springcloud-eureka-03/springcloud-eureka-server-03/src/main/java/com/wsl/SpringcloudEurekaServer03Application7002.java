package com.wsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//表示自己是eureka服务端
public class SpringcloudEurekaServer03Application7002 {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaServer03Application7002.class, args);
    }

}
