package com.base.mq.rabbit.topic;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/*
 
 1,在匹配交互器模式下，消费者端路由关键字 “*” 能接收到生产者端发来路由关键字为空的消息吗？
 
 2,在匹配交换器模式下，消费者端路由关键字“#.*”能接收到生产者端以“..”为关键字的消息吗？如果发送来的消息只有一个单词，能匹配上吗？
 
 3,“a.*.#” 与 “a.#” 有什么不同吗？

*/

public class Work {  
  
    private static final String EXCHANGE_NAME = "topic_logs";  
       
    public static void main(String[] argv) throws Exception {  
        ConnectionFactory factory = new ConnectionFactory();  
        factory.setHost("localhost");  
        Connection connection = factory.newConnection();  
        Channel channel = connection.createChannel();  
//      声明一个匹配模式的交换器  
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");  
        String queueName = channel.queueDeclare().getQueue();  
        // 路由关键字  
//        String[] routingKeys = new String[]{"*"};//验证是否可以收到生产者null的匹配
//        String[] routingKeys = new String[]{"#.*"};//验证是否可以接收到生产者的..的关键字
//        String[] routingKeys = new String[]{"a.#"};//1个单词以上
        String[] routingKeys = new String[]{"a.*.#"};//2个单词以上
//      绑定路由关键字  
        for (String bindingKey : routingKeys) {  
            channel.queueBind(queueName, EXCHANGE_NAME, bindingKey);  
            System.out.println("ReceiveLogsTopic1 exchange:"+EXCHANGE_NAME+", queue:"+queueName+", BindRoutingKey:" + bindingKey);  
        }  
  
        System.out.println("ReceiveLogsTopic1 [*] Waiting for messages. To exit press CTRL+C");  
  
        Consumer consumer = new DefaultConsumer(channel) {  
            @Override  
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {  
                String message = new String(body, "UTF-8");  
                System.out.println("ReceiveLogsTopic1 [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");  
            }  
        };  
        channel.basicConsume(queueName, true, consumer);  
    }  
}
