package com.ad61v1.test.time;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;

/**
 * @Author: eaazhel
 * @Date: 2020/10/10 14:59
 */
public class JodaDateTimeTest {

	public static void main(String[] args) {
		String a = "2015-01-15T05:00:00-05:00";
		DateTime dt1 = new DateTime(a);
		System.out.println("dt1 = " + dt1);
//		DateTime dt4 = new DateTime();
//		System.out.println("dt4 = " + dt4);
//		String e = "";
//		DateTime dt6 = new DateTime(e);
//		System.out.println("dt6 = " + dt6);
//		String c = "2015-01-15 05:00:00";
//		DateTime dt3 = new DateTime(c);
//		System.out.println("dt3 = " + dt3);
//		String b = "20th September 2020";
//		DateTime dt2 = new DateTime(b);
		//Exception in thread "main" java.lang.IllegalArgumentException: Invalid format: "20th September 2020" is malformed at "h September 2020"
//		System.out.println("dt2 = " + dt2);
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
//		DateTime dateTime = dateTimeFormatter.parseDateTime(c);
//		System.out.println("dateTime = " + dateTime);
		String d = "1970-01-01T00:00:00";
		DateTime dt5 = new DateTime(d);
		System.out.println("dt5 = " + dt5);
		String f= "2015-10-01T10:30:00Z";
		DateTime dateTimef = new DateTime(f);
		System.out.println("dateTime1 = " + dateTimef);

		LocalDate ld = new LocalDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String result = sdf.format(ld.toDate());
		System.out.println("result = " + result);

	}

}
