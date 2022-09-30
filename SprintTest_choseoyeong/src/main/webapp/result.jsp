<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<style>
	.content_body{
		margin: 10px;
		padding: 10px;
		border: 2px solid gray;
	}
</style>
</head>

<body>
	<div class="content_body">
		<div class="messageArea" id="messageArea">
			<h3 align="center">결과페이지</h3>
			<h4 align="center">정상적으로 ${message} 되었습니다.</h4><br>
		</div>
		
		<!-- 결과페이지 통합할 수 있도록 링크도 받아오는 값마다 바뀌도록 -->
		<div id="button_div" align="center">
			<a href="register.jsp">추가등록</a><br>
			<a href="${destUrl}">${destName}</a>
		</div>
	</div>
</body>
</html>