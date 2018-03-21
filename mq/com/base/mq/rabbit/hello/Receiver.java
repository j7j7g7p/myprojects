package com.base.mq.rabbit.hello;

import java.io.IOException;

import com.rabbitmq.client.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Receiver {  
    private final static String QUEUE_NAME = "MyQueue";  
      
    public static void main(String[] args) {  
        receive();  
    }  
      
    public static void receive()  
    {  
        ConnectionFactory factory = null;  
        Connection connection = null;  
        Channel channel = null;  
          
        try {  
            factory = new ConnectionFactory();  
            factory.setHost("localhost");  
            connection = factory.newConnection();  
            channel = connection.createChannel();  
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);  
            Consumer consumer = new MyDefaultConsumer(channel);
            channel.basicConsume(QUEUE_NAME, true,consumer);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally{  
            try {  
                //关闭资源  
                channel.close();  
                connection.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }
        }  
    }  
}  