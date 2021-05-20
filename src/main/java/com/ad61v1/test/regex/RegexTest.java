package com.ad61v1.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: eaazhel
 * @Date: 2020/10/10 17:33
 */
public class RegexTest{

	public static void main(String[] args) {
		testRegex1();

	}

	public static void testRegex1(){
		String pattern =  "(uname:useraName)|(mailto:usera@tmobile.com)";
		String str = "uname:useraName";
		boolean matches1 = str.matches(pattern);
		System.out.println("matches1 = " + matches1);
	}

	public static void testRegex2(){
		String a = "2015-10-01T10:30:00Z";
		String pattern =  "[1-2]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])T([0-1][0-9]|2[0-3])" +
				":[0-5]\\d:[0-5]\\d(-[0-5]\\d:[0-5]\\d)*[Z]?";
//				"T([0-1][0-9]|2[0-3]):[0-5]\\d:[0-5]\\d-[0-5]\\d:[0-5]\\d";
		String str = "2015-01-15T05:00:00-05:00";
		boolean matches1 = str.matches(pattern);
		System.out.println("matches1 = " + matches1);
		boolean matches2 = a.matches(pattern);
		System.out.println("matches2 = " + matches2);

		Pattern p = Pattern.compile(pattern);
		Matcher matcher1 = p.matcher(str);
		boolean matches = matcher1.matches();
		System.out.println("matches = " + matches);
	}
}
