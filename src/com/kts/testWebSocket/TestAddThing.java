package com.kts.testWebSocket;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kts.websocket.ServerPoint;

@WebServlet("/TestAddThing")
public class TestAddThing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestAddThing() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String message = request.getParameter("message");
		
		ServerPoint sp = new ServerPoint();
		
		sp.onMessage(message);
		
		response.sendRedirect("http://localhost:8081/WebSocketLearn/addThing.html");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
