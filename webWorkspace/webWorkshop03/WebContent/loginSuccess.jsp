<%@page import="servlet.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	User vo = (User)session.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#wrap{
		text-align: center;
	}

</style>
</head>
<body>
<h2 align="center"><%= vo.getName() %> 님이 로그인 되었습니다!!</h2><br><br>
<div id="wrap">
	<a href="book/Book.html">도서 등록</a><br><br>
	<a href="logout.jsp">로그아웃</a>
</div>
</body>
</html>