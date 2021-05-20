//package com.ad61v1.test.server;
//
//import com.github.tomakehurst.wiremock.WireMockServer;
//import com.github.tomakehurst.wiremock.client.WireMock;
//
//import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
//
///**
// * @Author: eaazhel
// * @Date: 2021/4/15 15:33
// */
//public class WiremockHttp {
//	public static void main(String[] args) throws Exception {
//		WireMockServer ws = new WireMockServer(wireMockConfig().port(8001));
//		String body = "{\"status\":\"ok\"}";
//		ws.stubFor(WireMock.get("/eiil/healthcheck").withHeader("accept",WireMock.equalTo("*/*")).willReturn(WireMock.aResponse().withBody(body).withHeader("Content-Type","application/json").withStatus(200)));
//		Thread t = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				ws.start();
//			}
//		});
//		t.start();
//		Thread.sleep(5000);
//		System.out.println("down...");
//		ws.stop();
//	}
//}
