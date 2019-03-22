package com.bcy.actiylion.webSocket.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.bcy.actiylion.webSocket.controller.WebSocketHander;

@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{

	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(GetWebSocketHander(), "/bcy/qw.do").addInterceptors(GetWebSocketInterceptor());
		
	}
	@Bean
	public WebSocketHander GetWebSocketHander() {
		return new WebSocketHander();
	}
	@Bean
	public WebSocketInterceptor GetWebSocketInterceptor() {
		return new WebSocketInterceptor();
	}

}
