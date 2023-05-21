package com.wsl.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
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
public class RabbitMqConfigurationFanout {

    //声明交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanout_order_exchange", true, false);
    }

    //声明3个队列
    @Bean
    public Queue smsQueue(){
        return new Queue("sms.fanout.queue", true);
    }
    @Bean
    public Queue duanxinQueue(){
        return new Queue("duanxin.fanout.queue", true);
    }
    @Bean
    public Queue emailQueue(){
        return new Queue("email.fanout.queue", true);
    }
    //绑定关系
    @Bean
    Binding smsBinding(){
        return BindingBuilder.bind(smsQueue()).to(fanoutExchange());
    }
    @Bean
    Binding duanxinBinding(){
        return BindingBuilder.bind(duanxinQueue()).to(fanoutExchange());
    }
    @Bean
    Binding emailBinding(){
        return BindingBuilder.bind(emailQueue()).to(fanoutExchange());
    }

}
