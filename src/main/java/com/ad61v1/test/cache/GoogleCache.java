package com.ad61v1.test.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/**
 * @Author: eaazhel
 * @Date: 10/20/2020 12:06 PM
 */
public class GoogleCache {

	public static void main(String[] args) throws Exception {
//		test1();
		test2();
	}

	private static void test1() throws Exception{
		Cache<Object, Object> cache =
				CacheBuilder.newBuilder().maximumSize(10).expireAfterWrite(2, TimeUnit.SECONDS).build();
		cache.put("a","abc");
		Object a = cache.get("a", ()->"a123");
		System.out.println("a = " + a);
		Thread.sleep(2000);
		Object a1 = cache.getIfPresent("a");
		System.out.println("a1 = " + a1);
	}

	private static void test2() throws Exception{
		Cache<Object, Object> cache =
				CacheBuilder.newBuilder().maximumSize(10).expireAfterWrite(2, TimeUnit.SECONDS).build();
		ConcurrentMap<Object, Object> cacheMap = cache.asMap();
		cacheMap.put("a","abc");
		Object a = cacheMap.get("a");
		System.out.println("a = " + a);
		Thread.sleep(2000);
		System.out.println("cacheMap = " + cacheMap);
		Object a1 = cacheMap.get("a");
		System.out.println("a1 = " + a1);
	}
}
