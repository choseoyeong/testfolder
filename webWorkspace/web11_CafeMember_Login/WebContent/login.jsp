<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>LOGIN PAGE</h2>
<form action="LoginServlet" method="post">
ID <input type="text" name="id" required="required"> <br><br>
PASSWORD <input type="password" name="password" required="required"> <br><br>

<input type="submit" value="LOGIN">
</form>
</body>
</html>