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
@RabbitListener(queues = {"email.direct.queue"})
@Service
public class DirectEmailConsumer {
    @RabbitHandler
    public void receiveMessage(String msg){
        System.out.println("email 接收到了订单信息:->" + msg);
    }
}
