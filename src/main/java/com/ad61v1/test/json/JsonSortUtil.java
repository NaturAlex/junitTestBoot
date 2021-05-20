package com.ad61v1.test.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.TreeMap;

/**
 * @Author: eaazhel
 * @Date: 2021/3/4 18:20
 */
public class JsonSortUtil {


	public static void main(String[] args) throws Exception {
		String json = readJson("/sortJson.json");
		//fastJson
		JSONObject jo = JSON.parseObject(json);
		String sortJson2 = JSON.toJSONString(jo, SerializerFeature.PrettyFormat, SerializerFeature.SortField);
		System.out.println("sortJson2 = " + sortJson2);

		//jackson
		ObjectMapper om = new ObjectMapper();
//		JsonNode jn = om.readTree(json);
		TreeMap jn = om.readValue(json, TreeMap.class);
		om.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY,true);
		String sortJson = om.writeValueAsString(jn);
//		System.out.println("sortJson = " + sortJson);
	}

	private static String readJson(String path) throws Exception {
		InputStream in = JsonSortUtil.class.getResourceAsStream(path);
		byte[] bytes = new byte[1024];
		int len;
		StringBuilder sb = new StringBuilder();
		while((len=in.read(bytes))!=-1){
				sb.append(new String(bytes,0,len));
		}
		String json = sb.toString();
		return json;
	}
}
