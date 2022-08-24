<%@page import="servlet.model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<STYLE TYPE="text/css"> table {font-size: 9pt;} </STYLE>
</head>
<body>
	<h2 align="center">전체 도서 List 보기</h2><br>
	
	<table border="2" width="750" bgcolor="yellow" align="center">
		<c:forEach var="bk" items="${results}">
			<tr>
				<td>${bk.isbn}</td>
				<td>${bk.title}</td>
				<td>${bk.catalogue}</td>
				<td>${bk.nation}</td>
				<td>${bk.publish_date}</td>
				<td>${bk.publisher}</td>
				<td>${bk.author}</td>
				<td>${bk.price}원</td>				
				<td>${bk.description}</td>
			</tr>
		</c:forEach>
	</table>
	
	<h3 align="center"><a href="Book.html">등록 화면으로</a></h3>
	<h3 align="center"><a href="../login.html">로그인 화면으로</a></h3>
</body>
</html>