package com.wsl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName FeignDeptConsumer_80.java
 * @Description TODO
 * @createTime 2022年04月18日 21:13:00
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.wsl.springcloud"})
@ComponentScans({@ComponentScan("com.wsl.springcloud")})
public class FeignDeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer_80.class, args);
    }
}
