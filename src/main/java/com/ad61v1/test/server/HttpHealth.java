package com.ad61v1.test.server;

import com.alibaba.fastjson.JSON;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * @Author: eaazhel
 * @Date: 2021/4/15 14:26
 */
public class HttpHealth {
	public static void main(String[] args) throws Exception {
		System.out.println(new Date());
		HttpServer server = HttpServer.create(new InetSocketAddress(8001), 0);
		server.setExecutor(Executors.newCachedThreadPool());
		server.createContext("/eiil/healthcheck",new TestHandler());
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				server.start();
			}
		});
		t.start();
		Thread.sleep(8000);
		System.out.println("down...");
		server.stop(1);

	}

	static class TestHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange httpExchange) throws IOException {
			//返回
			String rtn = "{\"status\":\"ok\"}";
			//获取请求路径
			URI requestURI = httpExchange.getRequestURI();
			System.out.println("请求路径为：" + requestURI);
			//获取请求方法
			String requestMethod = httpExchange.getRequestMethod();
			System.out.println("请求方法为：" + requestMethod);
			//获取请求体
			InputStream requestBody = httpExchange.getRequestBody();
			InputStreamReader inputStreamReader = new InputStreamReader(requestBody);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			StringBuffer stringBuffer = new StringBuffer();
			String s = "";
			while ((s = bufferedReader.readLine()) != null) {
				stringBuffer.append(s.trim());
			}
			if ("GET".equals(requestMethod)) {
				String[] pathParams = requestURI.toString().split("\\?");
				String[] params = requestURI.toString().split("\\?")[1].split("&");
				for (String str : params) {
					String key = str.split("=")[0];
					String value = str.split("=")[1];
					System.out.println("请求参数名：" + key);
					System.out.println("请求参数值：" + value);
				}
			}
			if ("POST".equals(requestMethod)) {
				//此处引入谷歌Gson框架将String转为Map方便获取参数
//                Gson gson = new Gson();
//                Map map = gson.fromJson(stringBuffer.toString(), new TypeToken<Map<String, Object>>(){}.getType());
				Map map = JSON.parseObject(stringBuffer.toString());
				String requestParam = map.get("imgPath").toString();
				for (Object obj : map.keySet()) {
					System.out.println("key为：" + obj);
					System.out.println("value为：" + map.get(obj));
				}
			}
			httpExchange.sendResponseHeaders(200, rtn.getBytes().length);
			OutputStream output = httpExchange.getResponseBody();
			output.write(rtn.getBytes("UTF-8"),0,rtn.getBytes().length);
			httpExchange.getResponseHeaders().set("Content-Type", "application/json");
			output.flush();
			output.close();
		}

	}
}
