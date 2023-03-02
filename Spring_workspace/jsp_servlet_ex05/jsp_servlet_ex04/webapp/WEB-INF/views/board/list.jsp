<%@page import="org.comstudy.myweb.board.model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>길동이의 홈페이지</h3>
<h1>게시글 목록</h1>
<%
ArrayList<BoardDTO> boardList = (ArrayList<BoardDTO>)request.getAttribute("boardList");
for(BoardDTO board : boardList) {
	out.println("<p>"+ board.toString() +"</p>");
}
%>

</body>
</html>