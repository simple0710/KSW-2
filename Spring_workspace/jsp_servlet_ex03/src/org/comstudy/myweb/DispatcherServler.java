package org.comstudy.myweb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy.myweb.model.SaramDTO;

public class DispatcherServler extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet() - DispatcherServlet 요청");
		
		// SaramDTO 객체(Bean)가 저장된 List를 view 페이지에 전달 하기.
		SaramDTO saram1 = new SaramDTO(1, "hong", "홍길동", 25);
		
		String viewName = "/WEB-INF/views/saram/list.jsp";
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		view.forward(req,  resp);
	}
}
