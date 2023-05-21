package com.wsl.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName ConfigBean.java
 * @Description TODO
 * @createTime 2022年04月07日 19:45:00
 */
@Configuration
public class ConfigBean {
    //配置负载均衡实现restTemplate
    //IRule实现类
    //AvailabilityFilteringRule：会过滤掉跳闸、访问故障的服务-，对剩下的进行轮询访问
    //RandomRule：随机访问服务
    //RoundRobinRule：轮询
    //RetryRule：会先按照轮询获得服务，如果服务获取失败，则会在指定的时间内进行重试
    @Bean
    @LoadBalanced//ribbon的
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
