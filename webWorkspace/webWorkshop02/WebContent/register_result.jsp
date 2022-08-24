<%@page import="servlet.model.ProductVO"%>
<%@page import="servlet.model.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품이 저장되었습니다.</h2><br><br>
<%
	ProductVO vo = (ProductVO)request.getAttribute("vo");
%>
<b>상품 번호 : </b><%= vo.getProductNumber() %> <br>
<b>상 품 명  : </b><%= vo.getName() %> <br>
<b>상품 가격  : </b><%= vo.getPrice() %> <br>
<b>상품 설명  : </b><%= vo.getDetail() %> <br>
<p><a href="list.jsp">상품 목록</a></p>
</body>
</html>