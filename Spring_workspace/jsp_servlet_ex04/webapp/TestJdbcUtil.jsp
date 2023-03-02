<%@page import="org.comstudy.myweb.dbcp.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
Connection conn = JdbcUtil.getConnection();
out.println(conn);
// Connection 객체를 닫아준다.
JdbcUtil.close(conn);
%>

</body>
</html>