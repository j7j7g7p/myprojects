package com.base.mq.rabbit.topic;

import com.rabbitmq.client.ConnectionFactory;  
import com.rabbitmq.client.Connection;  
import com.rabbitmq.client.Channel;  
/*
 不过一定要记住，路由关键字【routingKey】不能超过255个字节（bytes）匹配交换器的匹配符（星号）表示一个单词#（井号）表示零个或者多个单词
*/

/*Q1绑定关键字是【*.orange.*】,Q2绑定关键字是【*.*.rabbit】和【lazy.#】，然后分析会发生什么：*/

/*生产者发送“quick.orange.rabbit”的消息，两个队列都会收到

生产者发送“lazy.orange.elephant”，两队列也都会收到。

生产者发送"quick.orange.fox"，那么只有Q1会收到。

生产者发送"lazy.brown.fox"，那么只会有Q2能收到。

生产者发送"quick.brown.fox"，那么这条消息会被丢弃，谁也收不到。

生产者发送"quick.orange.male.rabbit"，这个消息也会被丢弃，谁也收不到。

生产者发送"lazy.orange.male.rabbit"，这个消息会被Q2的【lazy.#】规则匹配上，发送到Q2队列中。

*/

/*交换器在匹配模式下：

如果消费者端的路由关键字只使用【#】来匹配消息，在匹配【topic】模式下，它会变成一个分发【fanout】模式，接收所有消息。

如果消费者端的路由关键字中没有【#】或者【*】，它就变成直连【direct】模式来工作*/

public class TopicSend {  
  
    private static final String EXCHANGE_NAME = "topic_logs";  
  
    public static void main(String[] argv) {  
        Connection connection = null;  
        Channel channel = null;  
        try {  
            ConnectionFactory factory = new ConnectionFactory();  
            factory.setHost("localhost");  
  
            connection = factory.newConnection();  
            channel = connection.createChannel();  
//          声明一个匹配模式的交换器  
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");  
  
            // 待发送的消息  
            String[] routingKeys = new String[]{"quick.orange.rabbit",   
                                                "lazy.orange.elephant",   
                                                "quick.orange.fox",   
                                                "lazy.brown.fox",   
                                                "quick.brown.fox",   
                                                "quick.orange.male.rabbit",   
                                                "lazy.orange.male.rabbit",
                                                "..",
                                                "a",
                                                "a.as",
                                                "a.as.adb",
                                                null};  
//          发送消息  
            for(String severity :routingKeys){  
            	severity = severity==null? "NULL":severity;
                String message = "From "+severity+" routingKey' s message!";  
                channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());  
                System.out.println("TopicSend [x] Sent '" + severity + "':'" + message + "'");  
            }  
              
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (connection != null) {  
                try {  
                    connection.close();  
                } catch (Exception ignore) {  
                }  
            }  
        }  
    }  
}  