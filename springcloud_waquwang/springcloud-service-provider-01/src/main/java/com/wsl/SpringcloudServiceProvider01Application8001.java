package com.wsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//开启eureka客户端功能
public class SpringcloudServiceProvider01Application8001 {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudServiceProvider01Application8001.class, args);
    }

}
