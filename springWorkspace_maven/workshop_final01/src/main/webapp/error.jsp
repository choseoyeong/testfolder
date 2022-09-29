<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#message{
		backgound-color: lightgray;
	}
	
	#button_div{
		backgound-color: cyan;
	}

</style>
</head>

<body>
<div id="message">
	<h3>${message} 중 문제 발생</h3>
</div>

<div id="button_div" align="center">
	<a href="index.jsp">메인페이지</a>
</div>
</body>
</html>