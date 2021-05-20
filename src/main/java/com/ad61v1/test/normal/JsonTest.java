package com.ad61v1.test.normal;

import cn.ways.common.entity.Department;
import cn.ways.common.entity.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @Author: eaazhel
 * @Date: 11/30/2020 11:00 AM
 */
public class JsonTest {

	public static void main(String[] args) throws Exception {
		User u = new User();
		u.setAddress("GZ");
		u.setName("name");
		u.setEmail("123@qq.com");
		u.setId(1L);
		Department d = new Department();
		d.setDeptCode("dbc");
		d.setDeptName("logic");
		d.setId(2L);
		ObjectMapper om = new ObjectMapper();
		String s = null;
		String s1 = null;
		s = om.writeValueAsString(u);	//标记1
		System.out.println("s = " + s);
//		s1 = om.writeValueAsString(d);
//		System.out.println("s1 = " + s1);
		om.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY,true);
		om.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS,true);
		s = om.writeValueAsString(u);
		System.out.println("s = " + s);		//输出和上面的s一致,上面两个configure不起作用了,如果"标记1"注释了,可以起作用.
		s1 = om.writeValueAsString(d);
		System.out.println("s1 = " + s1);
		JsonNode jsonNode = om.readTree("");


	}
}

