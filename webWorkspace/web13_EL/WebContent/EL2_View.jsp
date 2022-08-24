<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>1. JSP 기본 element를 사용했을 경우 : </b>
<%= request.getParameter("myId") %><br>

<b>2. EL로 form값 받아오기 : </b>
${param.myId}<br>

<b>3. Menu에 해당하는 값을 JSP 기본 element로 받아오기 : </b>
<%
	String[] menus = request.getParameterValues("menu");
	for(String menu : menus) {
%>
	<b><%= menu %></b>
<%
	}
%>
<br>
<b>4. EL로 Menu에 해당하는 값 받아오기 : </b>
선택한 메뉴::
${paramValues.menu[0]}
${paramValues.menu[1]}
${paramValues.menu[2]}
${paramValues.menu[3]}
</body>
</html>