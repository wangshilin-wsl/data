package com.wsl.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName DeptProviderHystrix_8001.java
 * @Description 启动类
 * @createTime 2022年04月03日 14:31:00
 */
@EnableEurekaClient//在服务启动后，自动注册到eureka中
@SpringBootApplication
@EnableDiscoveryClient//服务发现
@EnableCircuitBreaker//开启对熔断的支持
public class DeptProviderHystrix_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix_8001.class, args);
    }

    //增加一个servlet
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        final ServletRegistrationBean bean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        bean.addUrlMappings("/actuator/hystrix.stream");
        return bean;
    }
}
