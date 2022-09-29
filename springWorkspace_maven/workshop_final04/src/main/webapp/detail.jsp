<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
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
	$(function() {
		findCar();
		
		function findCar() {
			$.ajax({
				type: 'post',
				url: '/findCar.do',
				data: {"num": "${num}"},
				aync:false,
				success: function(result) {
					let car = result;
					console.log("result" + result); 
					console.log("console num::"+car.num);
					$(".text_val").val(car.num);
					$("#input_model").val(car.model);
					$("#input_price").val(car.price );
					$('#input_vcode').val(car.vcode);
					$("#tr_vendor td").text(car.company.vendor);
				},
				error: function(e){ console.log(e); }
			})
		}

		// update를 위한 코드
		$('#btn_update').on("click", function(){
			console.log($(this).text());
			$("#btn_update, #btn_index").hide();
			$("#btn_submit").show();
			$(".input_val").prop("readonly", false);
		})
		
		$('#btn_submit').on("click", function(){
			console.log($(this).text());
			$("#btn_submit").hide();
			$("#btn_update, #btn_index").show();
			$(".input_val").prop("readonly", true);
		})
	});
</script>
<body>
<div id="content_body">
	<div id="title">
		<h3>자동차 관리 - 자동차 조회 </h3>
	</div>
	<form method="post" name="updateForm" action="/updateCar.do">
		<div id="form">	
			<table class="table">
			  	<tbody>
				    <tr class="tr" id="tr_num">
				      <th scope="row" class="table_row" id="num">차량번호</th>
				      <td><input type="text" class="text_val" name="num" id="text_num" value='' readonly></td>
				    </tr>
				    <tr class="tr" id="tr_model">
				      <th scope="row" class="table_row" id="model">모델명</th>
				      <td><input type="text" class="input_val" name="model" id="input_model" value='' readonly></td>
				    </tr>
				    <tr class="tr" id="tr_price">
				      <th scope="row" class="table_row" id="price">가격</th>
				      <td><input type="text" class="input_val" name="price" id="input_price" value='' readonly>만원</td>
				    </tr>
				    <tr class="tr" id="tr_vendor">
				      <th scope="row" class="table_row" id="vendor">제조사</th>
				      <td><input type="hidden" id="input_vcode" name="vcode" value=''></td>
				    </tr>
			  </tbody>
			</table>
		</div>
		<div id="buttons" align="center">
			<input type="submit" class="btn btn-outline-danger" id="btn_submit" value="저장하기" style="display:none"/>
			<button type="button" class="btn btn-outline-secondary" id="btn_update">수정하기</button>
			<a href="/index.jsp"><button type="button" class="btn btn-outline-secondary" id="btn_index">메인페이지로</button></a>
		</div>
	</form>
</div>
</body>
</html>