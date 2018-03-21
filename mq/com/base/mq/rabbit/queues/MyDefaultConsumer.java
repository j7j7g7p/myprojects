package com.base.mq.rabbit.queues;

import java.io.IOException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class MyDefaultConsumer extends DefaultConsumer {

	public MyDefaultConsumer(Channel channel) {
		super(channel);
	}

	@Override
	public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
			throws IOException {
		 System.out.println("11111111111");  
         String message = new String(body, "UTF-8");  
         System.out.println("收到消息....."+message); 
		super.handleDelivery(consumerTag, envelope, properties, body);
	}
	
	

}
