<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>브라우저에 저장된 모든 쿠키를 받아옵니다.</h2>
<%
	Cookie[] cs = request.getCookies();
	
	for(Cookie c: cs) {
%>
	<li>Name : <%= c.getName() %></li>
	<li>Value : <%= c.getValue() %></li>
	<hr><br>
<%		
	}
%>
</body>
</html>