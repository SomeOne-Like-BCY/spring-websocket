package com.bcy.actiylion.webSocket.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WebSocketHander implements WebSocketHandler {

	 //连接建立后处理
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("afterConnectionEstablished");
		
	}
	//接收文本消息，并发送出去
	public void handleMessage(final WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		String params = (String) message.getPayload();
		ObjectMapper mapper = new ObjectMapper();    
		HashMap<String,Object> map = mapper.readValue(params, HashMap.class);  
		final Object time = map.get("time");
		final Object text = map.get("text");
		final Object clientId = map.get("clientId");
		System.out.println(time.toString());
		System.out.println(text.toString());
		System.out.println(clientId.toString());
		//定时每3秒钟返回给前台数据
	    Timer timer = new Timer();
	    timer.schedule(new TimerTask() {
			@Override
			public void run() {
				TextMessage reply = new TextMessage("time : "+time+"text:"+text+"clientId:"+clientId);
				try {
					session.sendMessage(reply);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}, 0,3 * 1000);
	    
	}
	//抛出异常时处理
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		System.out.println("handleTransportError");
		
	}
	//连接关闭后处理
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		System.out.println("afterConnectionClosed");
		
	}

	public boolean supportsPartialMessages() {
		System.out.println("supportsPartialMessages");
		return false;
	}

	
}
