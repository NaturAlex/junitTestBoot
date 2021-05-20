package com.ad61v1.test.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @Author: eaazhel
 * @Date: 2021/2/23 14:09
 */
public class TestJackson {

	public static void main(String[] args) throws IOException {
		//1.get json
		InputStream in = TestJackson.class.getClassLoader().getResourceAsStream("test.json");
		byte[] bytes = new byte[10];
		StringBuffer sb = new StringBuffer();
		int len;
		//in.read() 读取文件,当文件结束时候会返回-1 当读到-1的时候read()方法会结束,但是返回倒数第二个数
		//假设最后bytes[] = {2,1,3,-1},则read()方法本次返回3,下次循环才返回-1
		// 这里最后假设返回倒数第二次返回3,
		while((len=in.read(bytes))!=-1){
			String s = new String(bytes,0,len);
			sb.append(s);
		}
		String json = sb.toString();
		System.out.println("json = " + json);
		in.close();

		//2.read json from map
		ObjectMapper om = new ObjectMapper();
		Map map = om.readValue(json, Map.class);
		Object v = map.get("msisdn");
		System.out.println("v.getClass() = " + v.getClass());
		String mapJson = om.writeValueAsString(map);
		System.out.println("mapJson = " + mapJson);

		//3.read json from bean
		TestBean testBean = om.readValue(json, TestBean.class);
		System.out.println("testBean.getMsisdn() = " + testBean.getMsisdn());
		String testBeanJson = om.writeValueAsString(testBean);
		System.out.println("testBeanJson = " + testBeanJson);


	}
}
