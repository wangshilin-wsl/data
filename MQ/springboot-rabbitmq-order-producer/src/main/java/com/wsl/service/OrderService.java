package com.wsl.service;

import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName OrderService.java
 * @Description TODO
 * @createTime 2022年08月25日 19:56:00
 */
@Service
public class OrderService {
    @Resource
    private RabbitTemplate rabbitTemplate;
    public void makeOrder(String userId, String productId, int num){
        //1、查询商品的余量是否足够
        //2、保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功 " + orderId);
        //3、发送信息到mq
        String exchangeName = "fanout_order_exchange";
        String routingKey = "";
        rabbitTemplate.convertAndSend(exchangeName, routingKey, orderId);
    }

    public void makeOrderDirect(String userId, String productId, int num){
        //1、查询商品的余量是否足够
        //2、保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功 " + orderId);
        //3、发送信息到mq
        String exchangeName = "direct_order_exchange";
        String routingKey = "";
        rabbitTemplate.convertAndSend(exchangeName, "email", orderId);
        rabbitTemplate.convertAndSend(exchangeName, "duanxin", orderId);
    }

    public void makeOrderTopic(String userId, String productId, int num){
        //1、查询商品的余量是否足够
        //2、保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功 " + orderId);
        //3、发送信息到mq
        String exchangeName = "topic_order_exchange";
        String routingKey = "duanxin.email";
        rabbitTemplate.convertAndSend(exchangeName, routingKey, orderId);
    }
    public void makeOrderTTL(String userId, String productId, int num){
        //1、查询商品的余量是否足够
        //2、保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功 " + orderId);
        //3、发送信息到mq
        String exchangeName = "direct_ttl_exchange";
        String routingKey = "ttl";
        rabbitTemplate.convertAndSend(exchangeName, routingKey, orderId);
    }

    public void makeOrderTTLMessage(String userId, String productId, int num){
        //1、查询商品的余量是否足够
        //2、保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功 " + orderId);
        //3、发送信息到mq
        String exchangeName = "direct_ttl_exchange";
        String routingKey = "msg";
        //给消息设置过期时间
        MessagePostProcessor messagePostProcessor = message -> {
          message.getMessageProperties().setExpiration("5000");
          message.getMessageProperties().setContentEncoding("UTF-8");
          return message;
        };
        rabbitTemplate.convertAndSend(exchangeName, routingKey, orderId, messagePostProcessor);
    }
}
