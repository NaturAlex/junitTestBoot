package com.ad61v1.mq;


import com.ad61v1.common.BaseControllerTest;
import com.i61.rabbitmq.config.CustomCorrelationData;
import com.i61.rabbitmq.message.MessageSaverDefaultImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: zhangtengchen
 * @Date: 2020/2/24 16:17
 */
public class RabbitMqConsumerTest extends BaseControllerTest {

//	@Autowired
//	private Consumer consumer;

	@Autowired
	private MessageSaverDefaultImpl messageSaverDefault;

	@Test
	public void testConsumer() throws InterruptedException {
//		System.out.println("consumer = " + consumer);
		System.out.println("----------------test consumer----------");
		Thread.sleep(5000000);
	}
	
	
	@Test
	public void getDataTest() throws Exception {
		List<CustomCorrelationData> allCustomCorrelationData = messageSaverDefault.getAllCustomCorrelationData();
		System.out.println("allCustomCorrelationData = " + allCustomCorrelationData);

		System.out.println("123");
	}
}
