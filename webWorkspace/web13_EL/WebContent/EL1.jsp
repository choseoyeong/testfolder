<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>이것은 원래 서블릿 입니다.</h2>
<h2>Attribute에 바인딩된 값 EL로 받아오기</h2>
<%
	int sum = 0;
	for(int cnt = 0; cnt<=50; cnt++) sum+=cnt;	//1275
	
	// 내장 객체이므로 어딘가에서 안받아와도 쓸 수 있음
	request.setAttribute("RESULT", sum);
	session.setAttribute("RESULT", "session");
	application.setAttribute("NAME", "BNK"); 	// application은 JSP에서 제공하는 ServletContext임.
	
	request.getRequestDispatcher("EL1_View.jsp").forward(request, response);

%>
</body>
</html>