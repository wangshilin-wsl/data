package com.wsl.all;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName Consumer.java
 * @Description TODO
 * @createTime 2022年08月23日 21:44:00
 */
public class Consumer {
   public static void main(String[] args) {
        //所有的中间件都是基于tcp/ip协议基础之上构建新型的协议规范，只不过rabbitmq遵循的是amqp
        //ip  port

        //1、创建连接工厂
        final ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("wsl");
        factory.setPassword("623920");
        factory.setVirtualHost("/");
        Connection connection = null;
        Channel channel = null;
        try {
            //2、创建连接connection，一个链接可以包含多个通道
            connection = factory.newConnection("生产者");

            //3、通过连接获取通道channel
            channel = connection.createChannel();

            //4、通过通道创建交换机，队列，声明绑定关系，发送消息，接受消息
            String queueName = "queue1";
            /*
             *  如果队列不存在，则会创建
             *  Rabbitmq不允许创建两个相同的队列名称，否则会报错。
             *
             *  @params1： queue 队列的名称
             *  @params2： durable 队列是否持久化
             *  @params3： exclusive 是否排他，即是否私有的，如果为true,会对当前队列加锁，其他的通道不能访问，并且连接自动关闭
             *  @params4： autoDelete 是否自动删除，当最后一个消费者断开连接之后是否自动删除消息。
             *  @params5： arguments 可以设置队列附加参数，设置队列的有效期，消息的最大长度，队列的消息生命周期等等。
             * */
            channel.queueDeclare(queueName, false, false, false, null);

            //5、准备消息内容
            String message = "你好，学相伴！！！";

            //6、发送消息到队列
            // @params1: 交换机exchange
            // @params2: 队列名称/routing
            // @params3: 属性配置
            // @params4: 发送消息的内容
            channel.basicConsume(queueName, false, new DeliverCallback() {
                @Override
                public void handle(String s, Delivery delivery) throws IOException {
                    System.out.println("收到消息是：" + new String(delivery.getBody(), "UTF-8"));
                }
            }, new CancelCallback() {
                @Override
                public void handle(String s) throws IOException {
                    System.out.println("接受失败了");
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //7、关闭通道
            if(channel != null && channel.isOpen()){
                try {
                    channel.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            //8、关闭连接
            if(connection != null && connection.isOpen()){
                try {
                    connection.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
