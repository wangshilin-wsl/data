package com.wsl.service.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName FanoutSmsConsumer.java
 * @Description TODO
 * @createTime 2022年08月25日 20:14:00
 */
@Service
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "duanxin.topic.queue", durable = "true", autoDelete = "false"),
        exchange = @Exchange(value = "topic_order_exchange",type = ExchangeTypes.TOPIC),
        key = "#.duanxin.#"
))
public class TopicDuanxinConsumer {
    @RabbitHandler
    public void receiveMessage(String msg){
        System.out.println("duanxin 接收到了订单信息:->" + msg);
    }
}
