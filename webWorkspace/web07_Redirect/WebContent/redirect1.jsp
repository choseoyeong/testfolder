<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 로직을 담는 역할을 한다 -> jsp의 역할과는 다르므로 많이 쓰면 안됨. 여기서는 Servlet도 여기 구현하기 위해 사용 -->
<!-- 네이버 검색시스템뫄 연결 -->

<% 
String url = "https://search.naver.com/search.naver?";
String keyword = request.getParameter("word");
url += "query=" + keyword;

// 페이지 이동...redirect() 방법 --> 헤더 방향을 네이버로 바꿈
response.sendRedirect(url);
%>
</body>
</html>