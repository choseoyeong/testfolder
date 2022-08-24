<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>SEARCH MEMBER FORM</h2>

<form action="front.do" method="post">
	<input type="hidden" name="command" value="find">
	ID <input type="text" name="id" required="required"><br><br>
	<input type="submit" value="회원 조회">
</form>

</body>
</html>