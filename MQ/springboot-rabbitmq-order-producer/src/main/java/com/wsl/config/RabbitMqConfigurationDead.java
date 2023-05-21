package com.wsl.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName RabbitMqConfig.java
 * @Description TODO
 * @createTime 2022年08月25日 20:00:00
 */
@Configuration
public class RabbitMqConfigurationDead {

    //声明交换机
    @Bean
    public DirectExchange deadDirectExchange(){
        return new DirectExchange("direct_dead_exchange", true, false);
    }

    //声明3个队列
    @Bean
    public Queue directDeadQueue(){
        return new Queue("dead.direct.queue");
    }
    //绑定关系
    @Bean
    Binding directDeadBinding(){
        return BindingBuilder.bind(directDeadQueue()).to(deadDirectExchange()).with("dead");
    }
}
