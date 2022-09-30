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
		findProduct();
		
		function findProduct() {
			$.ajax({
				type: 'post',
				url: '/findProduct.do',
				data: {"code": "${code}"},
				success: function(result) {
					let product = result;
					console.log("console code::"+product.code);
					$("#tr_title td").text(product.title);
					$("#tr_code td").text(product.code);
					$("#tr_category td").text(product.category);
					$("#tr_rate td").text(product.rate);
					$("#tr_memo td").text(product.memo);
				},
				error: function(e){ console.log(e); }
			})
		}
	});
</script>
<body>
<div id="content_body">
	<div id="title">
		<h3>입력된 상품 정보 </h3>
	</div>
	<div id="form">	
		<table class="table">
		  	<tbody>
			    <tr class="tr" id="tr_title">
			      <th scope="row" class="table_row" id="title">상품명</th>
			      <td></td>
			    </tr>
			    <tr class="tr" id="tr_code">
			      <th scope="row" class="table_row" id="code">상품번호</th>
			      <td></td>
			    </tr>
			    <tr class="tr" id="tr_category">
			      <th scope="row" class="table_row" id="category">상품분류</th>
			      <td></td>
			    </tr>
			    <tr class="tr" id="tr_rate">
			      <th scope="row" class="table_row" id="rate">이율</th>
			      <td></td>
			    </tr>
			    <tr class="tr" id="tr_memo">
			      <th scope="row" class="table_row" id="memo">상품설명</th>
			      <td></td>
			    </tr>
		  </tbody>
		</table>
	</div>
	<div id="buttons" align="center">
		<a href="/list.jsp"><button type="button" class="btn btn-outline-secondary" id="btn_list">상품 목록</button></a>
		<a href="/index.jsp"><button type="button" class="btn btn-outline-secondary" id="btn_index">메인페이지</button></a>
		<a href="/deleteProduct.do?code=${code}"><button type="button" class="btn btn-outline-secondary" id="btn_delete">삭제</button></a>
	</div>
</div>
</body>
</html>