package com.wsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient//开启eureka客户端功能@EnableDiscoveryClient
public class SpringcloudConsumerFeign06Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumerFeign06Application.class, args);
    }

}
