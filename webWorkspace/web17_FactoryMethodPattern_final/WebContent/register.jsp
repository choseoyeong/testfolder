<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 화면을 꾸밀 때 사용하는 태그 -->
<style>	
	h2{
		text-align: center;
		color: purple
	}
	#wrap{
		margin-left: 220px;		
	}
</style>

<!-- 화면에  이벤트를 만들 때 사용하는 태그 -->
<script type="text/javascript">
	function btnclick() {
		alert("button Click!!");
	}

</script>

</head>

<body>

<h2>REGISTER MEMBER FORM</h2>
<div id="wrap">
	<form action="front.do" method="post">
		<!-- 값이 노출되지 않으면서 서버로 전달할 때 사용하는 태그 -->
		<input type="hidden" name="command" value="register">
		ID <input type="text" name="id" required="required"><br><br>
		PASS <input type="password" name="password" required="required"><br><br>
		NAME <input type="text" name="name" required="required"><br><br>
		ADDR <input type="text" name="address" required="required"><br><br>
		<input type="submit" value="REGISTER">
		<input type="button" value="CLICK" onclick="btnclick()">
	</form>
</div>

</body>
</html>