<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- html 주석입니다... 브라우저에서 페이지 소스보기에서 보입니다.-->
<%-- jsp 주석입니다...안보입니다. 
	로그인 되어져 있다면...세션을 invalidate 시킵니다.
	 -> 로그인 성공하면 vo가 return되므로 이걸 이용한다.
--%>
<%
    MemberVO vo = (MemberVO)session.getAttribute("vo");
	if(vo == null) { // 로그인 안되었다면
%>
	<h2><a href="login.jsp">로그인 하기</a></h2>
<%		
	} else{ // 로그인 된 상태라면..
		session.invalidate();	// 세션을 unbind 시킴(로그아웃)
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logout() {
		alert("Log Out~!!!");
	}
</script>
</head>
<body onload="return logout()">
<b>로그아웃 되셨습니다..</b><br>
<a href="index.html">INDEX</a>
</body>
</html>