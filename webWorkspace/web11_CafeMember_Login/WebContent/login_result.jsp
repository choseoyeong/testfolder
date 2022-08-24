<%@ page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO vo = (MemberVO)session.getAttribute("vo");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>LOGIN INFORMATION</h2>
ID <%= vo.getId() %> <br>
NAME <%= vo.getName() %> <br>
ADDRESS <%= vo.getAddress() %> <br>
<p></p><hr><p></p>

<a href="logout.jsp">LOGOUT</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="index.html">INDEX</a>

</body>
</html>