package com.wsl.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName FanoutSmsConsumer.java
 * @Description TODO
 * @createTime 2022年08月25日 20:14:00
 */
@RabbitListener(queues = {"sms.direct.queue"})
@Service
public class DirectSmsConsumer {
    @RabbitHandler
    public void receiveMessage(String msg){
        System.out.println("sms 接收到了订单信息:->" + msg);
    }
}
