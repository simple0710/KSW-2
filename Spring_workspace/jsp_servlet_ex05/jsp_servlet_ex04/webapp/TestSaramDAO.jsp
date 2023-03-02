<%@page import="java.io.IOException"%>
<%@page import="javax.swing.plaf.synth.SynthRadioButtonMenuItemUI"%>
<%@page import="org.comstudy.myweb.saram.model.SaramDTO"%>
<%@page import="java.util.List"%>
<%@page import="org.comstudy.myweb.saram.model.SaramDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
SaramDAO saramDao = new SaramDAO();

public void testFindAll(JspWriter out) throws IOException {
	List<SaramDTO> list = saramDao.findAll();
	out.println(list);
}

%>

<%
SaramDTO dto = new SaramDTO(0, "KANG2","강감찬2",25);
saramDao.save(dto);

// 삭제 테스트
dto.setSeq(5);
saramDao.remove(dto);

testFindAll(out);
%>

</body>
</html>