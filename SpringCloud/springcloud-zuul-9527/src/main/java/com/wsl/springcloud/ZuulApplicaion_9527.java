package com.wsl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName ZuulApplicaion_9527.java
 * @Description TODO
 * @createTime 2022年04月21日 19:44:00
 */
@SpringBootApplication
@EnableZuulProxy//开启Zuul
public class ZuulApplicaion_9527 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplicaion_9527.class, args);
    }
}
