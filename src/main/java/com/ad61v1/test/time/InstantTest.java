package com.ad61v1.test.time;

import org.joda.time.DateTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhangtengchen
 * @Date: 2019/7/4 9:16
 */
public class InstantTest {

	public static void main(String[] args) {
//		instantFormat();
		//说明localDateTime为时区时间,但是toString没有展示时间,而instant为utc标准时间
		LocalDateTime now = LocalDateTime.now();
		System.out.println("now = " + now);		//2020-11-25T15:51:16.211
		Instant now1 = Instant.now();
		System.out.println("now1 = " + now1);	// 2020-11-25T07:51:16.211Z
		System.out.println("--------------------localDateTime------------------------");
		DateTime dateTime = new DateTime(now.toString());
		System.out.println("dateTime = " + dateTime);	//2020-11-25T15:51:16.211+08:00
		DateTime dateTime1 = new DateTime(now1.toString());
		System.out.println("dateTime1 = " + dateTime1);	//2020-11-25T15:51:16.211+08:00
		String basicIsoDate = now.format(DateTimeFormatter.BASIC_ISO_DATE);	//20201125
		System.out.println("format = " + basicIsoDate);
		String isoDateTime = now.format(DateTimeFormatter.ISO_DATE_TIME);	//2020-11-25T15:51:16.211
		System.out.println("format1 = " + isoDateTime);
//		String zoneDateTime = now.format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
//		System.out.println("zoneDateTime = " + zoneDateTime);
//		String isoInstant = now.format(DateTimeFormatter.ISO_INSTANT);	//exception unsupport
//		System.out.println("format2 = " + isoInstant);
		String isoLocalDateTime = now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		System.out.println("format3 = " + isoLocalDateTime);	//2020-11-25T15:54:09.163

		System.out.println("--------------------instant------------------------");
		//instant先转成了localDateTime
		String myFormat = now1.atOffset(ZoneOffset.ofHours(8)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ"));
		System.out.println("myFormat = " + myFormat);	//2020-11-25T16:07:18+0800
		String myFormatUtc = now1.atOffset(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ"));
		System.out.println("myFormatUtc = " + myFormatUtc);

		System.out.println("--------------------zoneDateTime------------------------");
		ZonedDateTime now2 = ZonedDateTime.now();
		System.out.println("now2 = " + now2);
		//--------------------------------去除毫秒---------------------------------
		now = now.withNano(0);
		System.out.println("now = " + now);	//2020-11-25T16:22:11
		ZonedDateTime myFormat8zone = ZonedDateTime.of(now, ZoneId.of("+08:00"));
		System.out.println("myFormat8zone = " + myFormat8zone);	//020-11-25T16:22:11+08:00
		//--------------------------设置时区格式---------------------------
		ZonedDateTime shanghaiTime = ZonedDateTime.of(now, ZoneId.of("Asia/Shanghai"));
		System.out.println("shanghaiTime = " + shanghaiTime);	//2020-11-25T16:22:11+08:00[Asia/Shanghai]
		ZonedDateTime z2 = ZonedDateTime.of(now, ZoneId.of("Z"));
		System.out.println("z2 = " + z2);	//z2 = 2020-11-25T16:22:11Z
		ZonedDateTime utcZoneDateTime = ZonedDateTime.of(now, ZoneId.of("UTC"));
		System.out.println("utcZoneDateTime = " + utcZoneDateTime);	//utcZoneDateTime = 2020-11-25T16:22:11Z[UTC]

	}



	private static void instantFormat() {
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
