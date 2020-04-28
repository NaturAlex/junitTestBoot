package com.ad61v1.mq;

import com.ad61v1.common.BaseControllerTest;
import com.i61.rabbitmq.sender.impl.EhcacheRabbitSender;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @Author: zhangtengchen
 * @Date: 2020/2/24 15:39
 */
public class RabbitMqTest extends BaseControllerTest {

	@Resource
	private EhcacheRabbitSender ehcacheRabbitSender;

//	@Resource
//	private RabbitTemplate rabbitTemplate;
	/**
	 * 1.代码准备
	 * 2.日志级别设置
	 * 3.测试自动确认
	 * 4.测试消费者抛出异常重新发送消息
	 * 5.测试手动确认
	 * @throws Exception
	 */
	@Test
	public void sendMsgTest() throws Exception {
//		System.out.println("rabbitTemplate = " + rabbitTemplate);
		System.out.println("ehcacheRabbitSender = " + ehcacheRabbitSender);
		for (int i = 0; i < 100; i++) {
			ehcacheRabbitSender.sendMessage("check_exchange","check.data.crm","testFirstMsg中文字符测试懒得看激发塑料袋咖啡机sad副驾驶的"+i);
			Thread.sleep(2000);
		}
	}

	@Test
	public void receiveMsgTest() throws Exception {

	}
}
