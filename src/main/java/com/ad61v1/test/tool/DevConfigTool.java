package com.ad61v1.test.tool;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * @Author: eaazhel
 * @Date: 2021/2/23 17:04
 */
public class DevConfigTool {


	public static void main(String[] args) throws IOException {
		//1.获取配置转为map
		Properties p = new Properties();
		p.load(DevConfigTool.class.getResourceAsStream("/config.properties"));
		//2.正则处理获得key列表
		Set<String> keys = p.stringPropertyNames();
		for (String key : keys) {
			System.out.println(key);
		}
		//3.正则处理获得value
		System.out.println("--------------------------------------------");
		for (String key : keys) {
			System.out.println(p.getProperty(key));
		}
	}
}
