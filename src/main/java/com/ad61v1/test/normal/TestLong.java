package com.ad61v1.test.normal;

/**
 * @Author: eaazhel
 * @Date: 2020/9/29 11:41
 */
public class TestLong {

	public static void main(String[] args) {
		// 01 | 10 = 11 = 3
		long a = 1L|2L;
		System.out.println("a = " + a);
		// 10 11 = 11  = 3
		long  b = 2L|3L;
		System.out.println("b = " + b);
		// 10 & 11  = 10  = 2
		long c = 2L&3L;
		System.out.println("c = " + c);
	}
}
