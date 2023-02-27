package org.comstudy.myweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// web.xml 설정 대신 어노테이션 매핑 사용
// 클래스에서 우클릭 > Run As > Run on Server 실행 가능.
// 주소의 구조 : 프로토콜 - 도메인(IP) - 포트 - 컨텍스트 패스 - 엔드 포인트
// 주소의 예 : http://localhost:8888/myweb/test
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getContextPath());
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
