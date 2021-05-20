package com.ad61v1.test.server;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: eaazhel
 * @Date: 2021/4/16 11:23
 */
public class JettyServerHttp {

	public static void main(String[] args) throws Exception {
		Server server = new Server(8001);
//		ServerConnector serverConnector = new ServerConnector(server);
//		ExecutorService executor = Executors.newFixedThreadPool(3);
////		NetworkTrafficServerConnector serverConnector = new NetworkTrafficServerConnector(server, executor, null, null, 1, 2, new HttpConnectionFactory());
//		serverConnector.setPort(8001);
//		serverConnector.setHost("localhost");
//		serverConnector.setIdleTimeout(30000);
//		server.addConnector(serverConnector);
		server.setHandler(new AbstractHandler() {
			@Override
			public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
				System.out.println("s = " + s);
				PrintWriter writer = httpServletResponse.getWriter();
				writer.write("abc");
				writer.flush();
				writer.close();
			}
		});
		server.start();
		server.join();
	}
}
