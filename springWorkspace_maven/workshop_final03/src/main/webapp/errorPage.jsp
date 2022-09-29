<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.content_body{
		margin: 10px;
		padding: 10px;
		border: 2px solid gray;
	}
	
	#title{
		background-color: lightgray;
		padding: 1px;
		margin: 2px;
	}
	
	#messageArea{
		border: 3px solid red;
	}

</style>
</head>

<body>

<div class="content_body">
	<div id="title">
		<h3>${errorLocation} - 에러</h3>
	</div>
	
	<div class="messageArea" id="messageArea">
		<h3 align="center">처리 중 문제가 발생하였습니다.</h3>
		<h3 align="center">원인 : ${message}</h3>
	</div>

	<div id="button_div" align="center">
		<br><a href="index.jsp">메인페이지</a>
	</div>
</div>

</body>
</html>