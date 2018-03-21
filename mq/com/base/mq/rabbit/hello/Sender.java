package com.base.mq.rabbit.hello;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Sender {  
    private final static String QUEUE_NAME = "MyQueue";  
      
    public static void main(String[] args) {  
        send();  
    }  
      
    public static void send()  
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
            String message = "my first message .....";  
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));  
            System.out.println("已经发送消息....."+message);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally{  
            try {  
                //关闭资源  
                channel.close();  
                connection.close();  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}  
