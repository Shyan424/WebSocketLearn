package com.kts.websocket;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/WSServer")
public class ServerPoint {
	
	public static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

	@OnOpen
	public void OnOpen(Session session) {
		session.getAsyncRemote().sendText("Åwªïµn¤J");
		sessions.add(session);
	}
	
	@OnMessage
	public void onMessage(Session session, String message) {
		sessions.forEach((s) -> {
			s.getAsyncRemote().sendText(message);
		});
		
	}
	
	@OnClose
	public void onClose() {
		
	}
	
}
