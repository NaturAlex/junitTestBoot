package com.ad61v1.test.thread;

/**
 * @Author: eaazhel
 * @Date: 2021/5/13 15:10
 */
public class TestThreadLocal {

	public static void main(String[] args) {
		String put = AThread.get().put("k", "v");
		String s = BThread.get().get("k");
		System.out.println("s = " + s);
		String s1 = AThread.get().get("k");
		System.out.println("s1 = " + s1);
	}
}
