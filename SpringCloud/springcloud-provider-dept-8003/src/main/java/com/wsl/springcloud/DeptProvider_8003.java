package com.wsl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName DeptProvider_8003.java
 * @Description 启动类
 * @createTime 2022年04月03日 14:31:00
 */
@EnableEurekaClient//在服务启动后，自动注册到eureka中
@SpringBootApplication
@EnableDiscoveryClient//服务发现
public class DeptProvider_8003 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8003.class, args);
    }
}
