<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<String> list = new ArrayList<>();
	list.add("Apple");
	list.add("Banana");
	list.add("Orange");
	list.add("Grape");
	list.add("Water Melon");
	
	request.setAttribute("list", list);
%>

<jsp:forward page="cForEage4_view.jsp" />
</body>
</html>