package com.bcy.actiylion.webSocket.util;

import java.util.Map;


import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

public class WebSocketInterceptor implements HandshakeInterceptor{

	// �������ַ���ǰ
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		System.out.println("������֮ǰ");
		 if (request instanceof ServletServerHttpRequest) {
	          //�����������������Ҫ�Ĺ��ܡ�
	        }
		System.out.println("������֮ǰ���");
		return true;
	}

	//�������ֺ�
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		System.out.println("������֮��");
		
	}

}
