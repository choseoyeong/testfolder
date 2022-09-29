<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<style>
	#content_body{
		border: 2px solid gray;
		margin: 10px;
		padding: 0px 5px 5px 5px;
	}

	#title *{
		background-color: lightgray;
		margin: 10px 0px;
		padding: 3px
	} 
	
	table {
		width: 100%;
	}
	
	th, td{
		border: 2px solid lightgray;
	}
	.table_row{
		background-color: YellowGreen;
		text-align: center;
		width: 10%;
	}
	
	#buttons{
		padding: 10px 0px 0px 0px;
	}
</style>
</head>
<script>
	$(function(){
		findAllCompany();
		
		// 등록 시 vcode 목록 출력을 위한 코드
		function findAllCompany() {
			$.ajax({
				type: 'post',
				url: '/findAllCompany.do',
				success:function(result) {
					console.log(result);
					let company = result;
					for(let i=0; i<company.length; i++) {
						let code = company[i].vcode;
						$("#input_vcodes").append(
							"<option name=vcode value="+code+">"+code+"</option>"		
						)
					}
				},
				error:function(e) {
					console.log(e);
				}
			})
		} //findCompany
		
		

	});	// function
</script>
<body>
<div id="content_body">
	<div id="title">
		<h3>자동차 관리 - 자동차 등록</h3>
	</div>
	<form method="post" name="registerForm" action="insertCar.do">
		<div id="form">	
			<table class="table">
		  	<tbody>
			    <tr class="tr">
			      <th scope="row" class="table_row">차량번호</th>
			      <td><input type="text" name="num" id="input_num" required="required"></td>
			    </tr>
			    <tr class="tr">
			      <th scope="row" class="table_row">모델명</th>
			      <td><input type="text" name="model" id="input_model" required="required"></td>
			    </tr>
			    <tr class="tr">
			      <th scope="row" class="table_row">가격</th>
			      <td><input type="text" name="price" id="input_price" required="required">만원</td>
			    </tr>
			    <tr class="tr">
			      <th scope="row" class="table_row">제조사코드</th>
			      <td>
		      		<select name="vcode" id="input_vcodes">
				  	</select>
			      </td>
			    </tr>
		  </tbody>
		</table>
		</div>
	
		<div id="buttons" align="center">
			<input type="submit" value="자동차등록" />
			<a href="index.jsp"><input type="button" value="취소" /></a>
		</div>
	</form>
</div>
</body>
</html>