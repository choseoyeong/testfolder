<%@page import="servlet.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	User vo = (User)session.getAttribute("vo");
	
	if(vo==null) {
%>
	<a href="login.html">로그인 하기</a>
<% 
	} else {
		session.invalidate();
	}
%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logout() {
		alert("LOGOUT!!");
	}
</script>
</head>
<body onload="return logout()">
<h2>로그아웃 되었습니다.</h2><br>
<a href="login.html">HOME</a>
</body>
</html>