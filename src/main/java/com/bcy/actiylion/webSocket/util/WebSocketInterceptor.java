package com.bcy.actiylion.webSocket.util;

import java.util.Map;


import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

public class WebSocketInterceptor implements HandshakeInterceptor{

	// 初次握手访问前
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		System.out.println("拦截器之前");
		 if (request instanceof ServletServerHttpRequest) {
	          //可以在这里完成你想要的功能。
	        }
		System.out.println("拦截器之前完成");
		return true;
	}

	//初次握手后
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		System.out.println("拦截器之后");
		
	}

}
