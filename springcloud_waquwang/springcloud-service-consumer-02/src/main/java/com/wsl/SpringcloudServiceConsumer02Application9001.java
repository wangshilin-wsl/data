package com.wsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//开启eureka客户端功能@EnableDiscoveryClient
@EnableCircuitBreaker//开启hystrix熔断器
//@SpringCloudApplication//可以替代以上三个注解
public class SpringcloudServiceConsumer02Application9001 {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudServiceConsumer02Application9001.class, args);
    }

}
