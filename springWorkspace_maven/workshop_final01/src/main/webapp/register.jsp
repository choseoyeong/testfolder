<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#content_body{
		border: 2px solid gray;
		padding: 0px 5px 5px 5px;
	}

	#title *{
		background-color: lightgray;
		margin: 5px 0px;
		padding: 3px
	} 
	
	.row{
		background-color: #A9BCF5;
	}
	table {
		width: 100%;
	}
	th, td{
		border: 2px solid lightgray;
	}
	#buttons{
		padding: 10px 0px 0px 0px;
	}
</style>
</head>

<body>
<div id="content_body">
	<div id="title">
		<h3>사원 관리 - 사원 등록</h3>
	</div>
	<form method="post" name="registerForm" action="insert.do">
		<div id="form">	
			<table class="table">
		  	<tbody>
			    <tr class="tr">
			      <th scope="row" class="row">사원번호</th>
			      <td><input type="text" name="num" id="input_num"> (사원번호 입력 형식 : 1403101)</td>
			      <td><input type="text" name="num" id="input_num" required="required" minlength=7 maxlen=7 > (사원번호 입력 형식 : 1403101)</td>
			    </tr>
			    <tr class="tr">
			      <th scope="row" class="row">사원명</th>
			      <td><input type="text" name="name" id="input_name"></td>
			    </tr>
			    <tr class="tr">
			      <th scope="row" class="row">부서명</th>
			      <td><input type="text" name="dept" id="input_dept"></td>
			    </tr>
		  </tbody>
		</table>
		</div>
	
		<div id="buttons" align="center">
			<input type="submit" value="사원등록" />
			<a href="index.jsp"><input type="button" value="취소" /></a>
		</div>
	</form>
</div>
</body>
</html>