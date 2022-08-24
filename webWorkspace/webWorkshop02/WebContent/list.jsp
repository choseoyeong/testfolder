<%@page import="servlet.model.ProductVO"%>
<%@page import="servlet.model.ProductDAOImpl"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">OPTI-FREE Book Register!!</h2><br>
<h2 align="center">전체 상품 리스트 보기</h2>
<table border="2" width="450" bgcolor="yellow" align="center">
	<%
		ProductDAOImpl dao = ProductDAOImpl.getInstance();
		ArrayList<ProductVO> list = dao.findAllProduct();
		for(ProductVO vo: list) {
	%>
		<tr>
			<td><%= vo.getProductNumber() %></td>
			<td><%= vo.getName() %></td>
			<td><%= vo.getPrice() %></td>
			<td><%= vo.getDetail() %></td>
		</tr>
	<%
		}
	%>
</table>
<h2 align="center"><a href="register.html">상품 등록</a></h2>
</body>
</html>