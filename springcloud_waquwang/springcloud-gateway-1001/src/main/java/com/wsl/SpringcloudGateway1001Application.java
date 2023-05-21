package com.wsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy//开启zuul的api网关服务功能
@EnableEurekaClient//开启eureka客户端功能
public class SpringcloudGateway1001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudGateway1001Application.class, args);
    }

}
