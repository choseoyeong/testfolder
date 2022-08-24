<%@page import="servlet.model.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Book vo = (Book)session.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div {
		text-align: center;
	}
</style>
</head>
<body>
<h2 align="center">결과 페이지</h2>
<h3 align="center" style="color:yellow;"><%= vo.getTitle() %></h3>
<h3 align="center">정상적으로 저장 되었습니다.</h3>
<div>
	<a href="./book/Book.html">추가 등록</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="./book/booklist.jsp?">도서목록</a>
</div>
</body>
</html>