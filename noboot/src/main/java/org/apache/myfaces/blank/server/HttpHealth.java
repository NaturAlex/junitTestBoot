package org.apache.myfaces.blank.server;

import com.alibaba.fastjson.JSON;
import com.sun.net.httpserver.Headers;
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
		final HttpServer server = HttpServer.create(new InetSocketAddress(8001), 0);
		server.setExecutor(Executors.newCachedThreadPool());
		server.createContext("/eiil/healthcheck",new Test2Handler());
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
			InputStream is = httpExchange.getRequestBody();

			String requestData = is2string(is);
			System.out.println("request: " + requestData);
			String response = "{\"pid\":\"510229197206267348\",\"pname\":\"zhangshan\"}";   // 写回这个数据就会failed
			// String response = "hello world";  // 若写回这个数据则没有问题
			System.out.println("response: " + response);
			is.close();

			Headers headers = httpExchange.getResponseHeaders();
			headers.set("Content-Type", "application/json; charset=utf-8");
			headers.set("Access-Control-Allow-Origin", "*");
			headers.set("Access-Control-Allow-Methods","GET,POST,PUT,DELETE,OPTIONS");
			headers.set("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");

			httpExchange.sendResponseHeaders(200, response.getBytes().length);
			OutputStream os = httpExchange.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}

		private String is2string(InputStream is) throws IOException {
			final int bufferSize = 1024;
			final char[] buffer = new char[bufferSize];
			final StringBuilder out = new StringBuilder();
			Reader in = new InputStreamReader(is, "UTF-8");

			for (; ; ) {
				int rsz = in.read(buffer, 0, buffer.length);
				if (rsz < 0)
					break;
				out.append(buffer, 0, rsz);
			}
			return out.toString();
		}

	}


	static class Test2Handler implements HttpHandler {
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
				String regex = "\\?";
				String[] array = requestURI.toString().split(regex);
				if(array.length>1){
					String[] params = array[1].split("&");
					for (String str : params) {
						String key = str.split("=")[0];
						String value = str.split("=")[1];
						System.out.println("请求参数名：" + key);
						System.out.println("请求参数值：" + value);
					}
				}
			}
			if ("POST".equals(requestMethod)) {
				Map map = JSON.parseObject(stringBuffer.toString());
				String requestParam = map.get("imgPath").toString();
				for (Object obj : map.keySet()) {
					System.out.println("key为：" + obj);
					System.out.println("value为：" + map.get(obj));
				}
			}
			Headers headers = httpExchange.getResponseHeaders();
			headers.set("Content-Type", "application/json; charset=utf-8");
			headers.set("Access-Control-Allow-Origin", "*");
			headers.set("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
			headers.set("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
			httpExchange.sendResponseHeaders(200, rtn.getBytes().length);
			OutputStream output = httpExchange.getResponseBody();
			output.write(rtn.getBytes());
			output.close();
		}
	}
}
