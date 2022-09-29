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
				success: function(result) {
					let car = result;
					console.log("result" + result); 
					console.log("console num::"+car.num);
					$("#tr_num td").text(car.num);
					$("#tr_model td").text(car.model);
					$("#tr_price td").text(car.price + "만원");
					$("#tr_vendor td").text(car.company.vendor);
				},
				error: function(e){ console.log(e); }
			})
		}
	});
</script>
<body>
<div id="content_body">
	<div id="title">
		<h3>자동차 관리 - 자동차 조회 </h3>
	</div>
	<div id="form">	
		<table class="table">
		  	<tbody>
			    <tr class="tr" id="tr_num">
			      <th scope="row" class="table_row" id="num">차량번호</th>
			      <td></td>
			    </tr>
			    <tr class="tr" id="tr_model">
			      <th scope="row" class="table_row" id="model">모델명</th>
			      <td></td>
			    </tr>
			    <tr class="tr" id="tr_price">
			      <th scope="row" class="table_row" id="price">가격</th>
			      <td></td>
			    </tr>
			    <tr class="tr" id="tr_vendor">
			      <th scope="row" class="table_row" id="vendor">제조사</th>
			      <td></td>
			    </tr>
		  </tbody>
		</table>
	</div>
	<div id="buttons" align="center">
		<a href="/index.jsp"><button id="btn_index">메인페이지로</button></a>
	</div>
</div>
</body>
</html>