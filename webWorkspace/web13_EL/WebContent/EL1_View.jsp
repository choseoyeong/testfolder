<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Attribute에 바인딩된 값을 jsp 결과페이지에서 받아와서 출력합니다...</h2>
<b>1~50까지의 총합 결과값 1) :: </b> <br>
<%= request.getAttribute("RESULT") %> <br>
<%= session.getAttribute("RESULT") %> <br>

<%
	String myname = (String)session.getAttribute("RESULT");
%>

<hr>
<b>1~50까지의 총합 결과값 2) ::</b><br>
1. ${RESULT}<br>
2. ${requestScope.RESULT}<br>
3. ${sessionScope.RESULT}<br>
4. ${applicationScope.NAME}<br>
5. ${RESULT + 100} 연산도 가능하다
</body>
</html>