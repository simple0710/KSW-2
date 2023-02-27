<%@page import="java.util.ArrayList"%>
<%@page import="java.awt.desktop.UserSessionListener"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/saram/list.jsp</title>
</head>
<body>
<!--
 Servlet에서 forward 되는 JSP 페이지는 request, response 객체가 전달되므로
 해당 Servlet 페이지 내부에서 처리되는 것과 (있는 것과) 같다. 
 -->
	<h1>길동이의 홈페이지</h1>
	<h3>사람 목록 페이지</h3>
	<!-- HTML 주석 : JSP에서 사용 가능한 표현식. expression, EL, JSTL 등. -->
	<p>안녕하세요. ${username}님.</p> <!-- EL -->
	<!-- 
	JSP에서 기본 제공 되는 내장 객체:
	pageContext, resquest, response, session, application
	선언 하지 않고 바로 사용 가능하다.
	 -->
	<p>안녕하세요. <%=request.getAttribute("username") %></p>
	<hr/>

	<%
	// Object객체를 ArrayList타입으로 다운 캐스팅
	ArrayList<String> userList  = (ArrayList<String>)request.getAttribute("userList");
	for(String user : userList) {
		out.println(user + "<br/>");
	}
	String realPath = request.getSession().getServletContext().getRealPath("/");
	out.println(realPath);
	%>
	<!-- 
	MVC 패턴 : Model 2라고도 한다. 모델 + 뷰 + 컨트롤러 형태로 만들어 진다.
	모델 : DB와 연관 되는 부분. DAO, DTO
	뷰 : 사용자가 보는 화면과 연관 되는 부분. JSP페이지, HTML + Ajax + Thymeleaf, 머스타치 ...
	콘트롤러 : 모델 2에서는 Servlet이 컨틀롤러 역할을 한다. 모델 1에서는 JSP가 (컨트롤러+모델) 역할을 대신한다.
	
	
	-->
	
	<!-- 
	JSP 실행 => Servlet.java파일로 변환 => 컴파일을 거친 후 톰캣에서 .class 파일 실행
	=> 최종 클라이언트 HTML 소스가 전달 된다.
	 -->
</body>
</html>