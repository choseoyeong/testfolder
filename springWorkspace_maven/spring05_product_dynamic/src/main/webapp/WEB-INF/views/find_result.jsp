<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl :: 라이브러리 다운, taglib 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td, h2{
		text-align: center;
	}
</style>
</head>
<body>
<h2>+++++++++++++ 상품정보를 출력합니다 +++++++++++++</h2>
<table border="2" align="center" width="50%" class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>MAKER</th>
        <th>PRICE</th>
      </tr>
    </thead>
    <tbody>
	    <c:forEach items="${list}" var="vo">
	      <tr>
	        <td>${vo.id}</td>
	        <td>${vo.name}</td>
	        <td>${vo.maker}</td>
	        <td>${vo.price}</td>
	      </tr>
	    </c:forEach>
    </tbody>
</table><br>
<center><a href="product.jsp">상품 가입하기 홈으로..</a></center>
</body>
</html>