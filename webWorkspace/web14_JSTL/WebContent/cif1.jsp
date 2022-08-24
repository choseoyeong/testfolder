<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
JSP를 완벽한 태그 기반의 언어로 만들기 위해서는 
EL + JSTL 기술이 필요하다.

EL은 getXxx()의 원리를 태그로 만든 기법으로
getAttribute() / getParameter() / getXxx 등을 코드 없이 사용할 수 있다.
${RESULT}
${param.userName}
${vo}
${vo.id} :: vo.getId()

하지만 EL기술 만으로는 for, if를 사용할 수 없다.
그래서 결국 EL과 JSTL은 함께 사용된다.

JSTL을 하기 위해서는
1) jstl.jar, standard.jar파일이 추가되어야 한다.
2) jsp선언부에 반드시 taglib가 선언되어져 있어야 한다.
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>JSTL if 사용하기</h2>
<form action="cif1_view.jsp">
NUM <input type="text" name="NUM">
<input type="submit" value="전송">
</form>
</body>
</html>


















