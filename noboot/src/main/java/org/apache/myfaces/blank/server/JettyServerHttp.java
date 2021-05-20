package org.apache.myfaces.blank.server;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: eaazhel
 * @Date: 2021/4/16 11:23
 */
public class JettyServerHttp {

	public static void main(String[] args) throws Exception {
		Server server = new Server();
//		ServerConnector serverConnector = new ServerConnector(server);
//		ExecutorService executor = Executors.newFixedThreadPool(3);
////		NetworkTrafficServerConnector serverConnector = new NetworkTrafficServerConnector(server, executor, null, null, 1, 2, new HttpConnectionFactory());
//		serverConnector.setPort(8001);
//		serverConnector.setHost("localhost");
//		serverConnector.setIdleTimeout(30000);
//		server.addConnector(serverConnector);
		ServerConnector sc = new ServerConnector(server, 1, 1);
		sc.setPort(8001);
//		sc.setHost("localhost");
		sc.setIdleTimeout(30000);
		sc.setAcceptQueueSize(1);
		sc.setStopTimeout(30000);
		ServerConnector[] scs = {sc};
		server.setConnectors(scs);

		server.setHandler(new HelloHandler());
		server.start();
		System.out.println("jetty start ...");
		server.join();
	}

	static int count = 0;

	static class HelloHandler extends AbstractHandler {
		public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			System.out.println("receive http request ...");
			response.setContentType("application/json ;charset=utf-8");
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			int i = 3000 + count;
			count++;
			System.out.println("count = " + count);
			try {
				Thread.sleep(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String json = "{\"status\":\"ok"+i+"\"}";
			response.getWriter().println(json);
		}
	}
}
