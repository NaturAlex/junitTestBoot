package com.ad61v1.test.matcher;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;

/**
 * @Author: eaazhel
 * @Date: 2021/3/5 19:49
 */
public class EqualMatcherTest {

	public static void main(String[] args) {
		String a = "{\"key\":[1,2,3,4]}";

		String b = "{\"key\":[1,2,4,3]}";
		JSONObject joa = JSON.parseObject(a);
		JSONObject job = JSON.parseObject(b);

		Assert.assertEquals(joa,job);
	}
}
