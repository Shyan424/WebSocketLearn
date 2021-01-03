package com.kts.websocket;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

// configurator = 設定檔名稱
@ServerEndpoint(value = "/WSServer", configurator = GetHttpSessionConfig.class)
public class ServerPoint {
	
	public static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

	@OnOpen						// 必須要使用 EndpointConfig 才能拿到裡面的東西
	public void OnOpen(Session session, EndpointConfig config) {
		
//		config.getUserProperties().get("");		// 拿取方式
		
		session.getAsyncRemote().sendText("歡迎登入");
		sessions.add(session);
	}
	
	@OnMessage
	public void onMessage(String message) {
		System.out.println(sessions.size());
		sessions.forEach((s) -> {
			s.getAsyncRemote().sendText(message);
		});
		
	}
	
	@OnClose
	public void onClose(Session session) {
		sessions.remove(session);
	}
	
}
