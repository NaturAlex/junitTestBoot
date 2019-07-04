package com.ad61v1.test.executors;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhangtengchen
 * @Date: 2019/7/3 20:32
 */
public class ExecutorsTest
{

	//FIXME 完善理解里面的Queue
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(4);
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
		for (int i = 0; i < 4; i++) {
			final int index = i;
			scheduledExecutorService.schedule(()-> System.out.println("num:"+index),1, TimeUnit.SECONDS);
			countDownLatch.countDown();
		}
		countDownLatch.await();
		scheduledExecutorService.shutdown();


	}
}
