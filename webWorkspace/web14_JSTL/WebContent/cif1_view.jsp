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
<h2>jstl core if result page...</h2>
	<c:if test="${param.NUM=='100'}">
		<h3>오늘 100만원 입금하셨습니다.</h3>
	</c:if>
	<c:if test="${param.NUM=='200'}">
		<h3>오늘 200만원 입금하셨습니다.</h3>
	</c:if>

</body>
</html>