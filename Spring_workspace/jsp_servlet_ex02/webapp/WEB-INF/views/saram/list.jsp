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
	%>
</body>
</html>