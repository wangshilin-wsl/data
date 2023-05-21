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
public class RabbitMqConfigurationDirect {

    //声明交换机
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct_order_exchange", true, false);
    }

    //声明3个队列
    @Bean
    public Queue directSmsQueue(){
        return new Queue("sms.direct.queue", true);
    }
    @Bean
    public Queue directDuanxinQueue(){
        return new Queue("duanxin.direct.queue", true);
    }
    @Bean
    public Queue directEmailQueue(){
        return new Queue("email.direct.queue", true);
    }
    //绑定关系
    @Bean
    Binding directSmsBinding(){
        return BindingBuilder.bind(directSmsQueue()).to(directExchange()).with("sms");
    }
    @Bean
    Binding directDuanxinBinding(){
        return BindingBuilder.bind(directDuanxinQueue()).to(directExchange()).with("duanxin");
    }
    @Bean
    Binding directEmailBinding(){
        return BindingBuilder.bind(directEmailQueue()).to(directExchange()).with("email");
    }

}
