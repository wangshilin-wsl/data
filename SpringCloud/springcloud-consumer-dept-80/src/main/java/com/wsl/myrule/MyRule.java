package com.wsl.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName MyRule.java
 * @Description TODO
 * @createTime 2022年04月12日 21:26:00
 */
@Configuration
public class MyRule {
    @Bean
    public IRule myWslRule(){
        //默认是轮询，现在我们自定义的RandomRule
        return new RandomRule();
    }
}
