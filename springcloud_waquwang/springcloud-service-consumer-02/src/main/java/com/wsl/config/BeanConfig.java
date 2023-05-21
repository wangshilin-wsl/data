package com.wsl.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName BeanConfig.java
 * @Description TODO
 * @createTime 2023年02月15日 23:04:00
 */
@Configuration
public class BeanConfig {
    @Bean
    @LoadBalanced//负载均衡ribbon调用
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    //覆盖默认的轮询负载均衡策略
    //@Bean
    public IRule iRule(){
        //采用随机的
        return new RandomRule();
    }
}
