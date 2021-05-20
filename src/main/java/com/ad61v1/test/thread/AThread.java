package com.ad61v1.test.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: eaazhel
 * @Date: 2021/5/13 15:08
 */
public class AThread {

	public static final ThreadLocal<Map<String, String>> tl = new ThreadLocal<Map<String, String>>(){
		@Override
		protected Map<String, String> initialValue() {
			return new HashMap<>();
		}
	};

	public static Map<String, String> get(){
		return tl.get();
	}
}
