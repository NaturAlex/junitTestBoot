package com.ad61v1.test.time;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhangtengchen
 * @Date: 2019/7/4 9:16
 */
public class InstantTest {
	public static void main(String[] args) {
		Instant i = Instant.now();
		System.out.println("i = " + i);
		Instant instant = Instant.ofEpochSecond(5);
		System.out.println("instant = " + instant);
		Instant now = Instant.now(Clock.systemDefaultZone());
		System.out.println("now = " + now);
		Instant parse = Instant.parse("2007-12-03T10:15:30.00Z");
		System.out.println("parse = " + parse);
		Instant now1 = Instant.now(Clock.system(ZoneId.of("+8")));
		System.out.println("now1 = " + now1);
		ZoneId zoneId = ZoneId.systemDefault();
		System.out.println("zoneId = " + zoneId);
		//当前时间
		Instant bjTime = now.plusMillis(TimeUnit.HOURS.toMillis(8));
		System.out.println("bjTime = " + bjTime);
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("ldt = " + ldt);
		LocalDateTime ldt2 = LocalDateTime.now(ZoneId.of("+8"));
		System.out.println("ldt2 = " + ldt2);
		LocalDateTime ldt3 = LocalDateTime.now(ZoneId.systemDefault());
		System.out.println("ldt3 = " + ldt3);
		Instant ii = ldt3.atZone(ZoneId.systemDefault()).toInstant();
		System.out.println("ii = " + ii);


	}
}
