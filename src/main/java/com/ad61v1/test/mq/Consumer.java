package com.ad61v1.test.mq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.util.Random;


/**
 * @Author: zhangtengchen
 * @Date: 2020/2/24 16:18
 */
//@Service
public class Consumer {

	@RabbitListener(queues = "check_queue")
	public void process(Channel channel, Message message) throws Exception{
		byte[] body = message.getBody();
		String msg = new String(body, "UTF-8");

		int i = new Random().nextInt(10);
		if(i>4){
			System.out.println("fail msg = " + msg);
//			channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
			channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
		}else{
			System.out.println("success msg = " + msg);
			channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
		}
	}

}
