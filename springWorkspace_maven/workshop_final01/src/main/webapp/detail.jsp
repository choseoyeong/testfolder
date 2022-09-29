<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
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
		border: 1px solid lightgray;
	}
	#buttons{
		padding: 10px 0px 0px 0px;
	}
</style>
</head>
<script>
	$(function() {
		
	});
</script>
<body>
<div id="content_body">
	<div id="title">
		<h3>사원 관리 - 사원 상세정보 </h3>
	</div>
	<div id="form">	
		<table class="table">
	  	<tbody>
		    <tr class="tr">
		      <th scope="row" class="row">사원번호</th>
		      <td><input type="text" id="input_num" value='${emp.num}'readonly></td>
		    </tr>
		    <tr class="tr">
		      <th scope="row" class="row">사원명</th>
		      <td><input type="text" id="input_name" value='${emp.name}' readonly></td>
		    </tr>
		    <tr class="tr">
		      <th scope="row" class="row">부서명</th>
		      <td><input type="text" id="input_dept" value='${emp.dept}' readonly></td>
		    </tr>
	  </tbody>
	</table>
	</div>
	<div id="buttons" align="center">
		<a href="list.jsp"><button id="btn_register">사원목록</button></a>
		<a href="delete.do?num=${emp.num}"><button id="btn_cancel">삭제</button></a>
	</div>
</div>
</body>
</html>