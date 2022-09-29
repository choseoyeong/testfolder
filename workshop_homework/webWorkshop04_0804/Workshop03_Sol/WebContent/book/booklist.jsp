<%@page import="servlet.model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<STYLE TYPE="text/css"> table {font-size: 9pt;} </STYLE>
</head>
<body>

	<h2 align="center">전체 도서 List 보기</h2><br>

	<%
		ArrayList<Book> books = (ArrayList<Book>)request.getAttribute("results");
	%>
	
	<table border="2" width="750" bgcolor="yellow" align="center">
		<%
			for (Book bk: books) {
		%>
			<tr>
				<td><%= bk.getIsbn() %></td>
				<td><%= bk.getTitle() %></td>
				<td><%= bk.getCatalogue() %></td>
				<td><%= bk.getNation() %></td>
				<td><%= bk.getPublish_date() %></td>
				<td><%= bk.getPublisher() %></td>
				<td><%= bk.getAuthor() %></td>
				<td><%= bk.getPrice() %>원</td>				
				<td><%= bk.getDescription() %></td>
			</tr>
		<%
			}
		%>
	</table>
	
	<h3 align="center"><a href="Book.html">등록 화면으로</a></h3>
	<h3 align="center"><a href="../login.html">로그인 화면으로</a></h3>
</body>
</html>