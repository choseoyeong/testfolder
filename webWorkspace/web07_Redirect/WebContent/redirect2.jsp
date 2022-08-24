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
	String[] cities = request.getParameterValues("city");
	for(String city : cities)
		out.println(city + "<br>");
%>
</body>
</html>