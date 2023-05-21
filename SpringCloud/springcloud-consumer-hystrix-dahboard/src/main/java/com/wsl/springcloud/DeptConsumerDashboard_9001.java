package com.wsl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName DeptConsumerDashboard_9001.java
 * @Description TODO
 * @createTime 2022年04月21日 18:58:00
 */
@SpringBootApplication
//开启监控页面
@EnableHystrixDashboard
public class DeptConsumerDashboard_9001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerDashboard_9001.class, args);
    }
}
