<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>사람 정보 수정</h2>
<form action="modify.do" method="post">
	<input type="hidden" name="seq" value="${saram.seq }" /> 
	id: <input name="id" value="${saram.id }" /><br/>
	name: <input name="name" value="${saram.name }" /><br/>
	age: <input name="age" value="${saram.age }" /><br/>
	<input type="submit" value="수정완료" /> <a href="list.do">목록</a>
</form>

</body>
</html>