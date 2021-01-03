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

// configurator = �]�w�ɦW��
@ServerEndpoint(value = "/WSServer", configurator = GetHttpSessionConfig.class)
public class ServerPoint {
	
	public static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

	@OnOpen						// �����n�ϥ� EndpointConfig �~�ள��̭����F��
	public void OnOpen(Session session, EndpointConfig config) {
		
//		config.getUserProperties().get("");		// �����覡
		
		session.getAsyncRemote().sendText("�w��n�J");
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
