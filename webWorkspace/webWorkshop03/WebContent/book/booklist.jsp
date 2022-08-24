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
</head>
<body>
<h2>방금 등록된 책 제목</h2><br>
ISBN: <%= vo.getIsbn() %><br>
제목: <%= vo.getTitle() %><br>
카탈로그: <%= vo.getCatalogue() %><br>
도서분류: <%= vo.getNation() %><br>
출판일: <%= vo.getPublish_date() %><br>
출판사: <%= vo.getPublisher() %><br>
저자: <%= vo.getAuthor() %><br>
가격: <%= vo.getPrice() %><br>
설명: <%= vo.getDescription() %><br>
<form >
</form>
</body>
</html>