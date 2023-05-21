package com.wsl.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName RabbitMqConfig.java
 * @Description TODO
 * @createTime 2022年08月25日 20:00:00
 */
@Configuration
public class TTLRabbitMqConfiguration {

    //声明交换机
    @Bean
    public DirectExchange ttlDirectExchange(){
        return new DirectExchange("direct_ttl_exchange", true, false);
    }

    //声明3个队列
    @Bean
    public Queue directTTLQueue(){
        Map<String, Object> args = new HashMap<>();
        args.put("x-message-ttl", 5000);
        args.put("x-dead-letter-exchange", "direct_dead_exchange");
        args.put("x-dead-letter-routing-key", "dead");
        return new Queue("ttl.direct.queue", true, false, false, args);
    }
    @Bean
    public Queue directTTLMessageQueue(){
        Map<String, Object> args = new HashMap<>();
        args.put("x-message-ttl", 5000);
        args.put("x-dead-letter-exchange", "direct_dead_exchange");
        args.put("x-dead-letter-routing-key", "dead");
        return new Queue("ttl.message.direct.queue", true, false, false, args);
    }

    //绑定关系
    @Bean
    Binding ttlBinding(){
        return BindingBuilder.bind(directTTLQueue()).to(ttlDirectExchange()).with("ttl");
    }

    //绑定关系
    @Bean
    Binding ttlMessageBinding(){
        return BindingBuilder.bind(directTTLMessageQueue()).to(ttlDirectExchange()).with("msg");
    }

}
