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
		padding: 0px 5px 5px 5px;
	}
	
	#title *{
		background-color: lightgray;
		margin: 5px 0px;
		padding: 3px
	}
	
	table, td, th {
  		border: 1px solid gray;
  		text-align: center;
	}
	
	th{
		background-color: yellowGreen;
	}

	table {
		border-collapse: collapse;
		width: 100%;
		margin: 10px 0px;
	}

</style>
</head>

<script type="text/javascript">
	$(function(){		
		refresh();

		// 자동차 목록 출력을 위한 전체 car 목록 조회
		function findAllProduct() {
			$.ajax({
				type: 'post',
				url: "/findAllProduct.do",
				success: function(result) {
					//console.log(result)
					let productList = result;
					for(let i=0; i<productList.length; i++) {
						$('#listTable').append(
							'<tr>'
								+ '<td>' + productList[i].code + '</td>'
								+ '<td>' 
								+ '<a href="/detail.do/'
										+productList[i].code+'">'
								+ productList[i].title + '</a>'
								+ '</td>'
								+ '<td>' + productList[i].category + '</td>'
								+ '<td>' + productList[i].rate + '</td>'
							+'</tr>'
						)
						
					} 
				},
				error: function(e){ console.log(e); }
			})
		}//findAllCar
		
	
		
		function refresh() {
			// 페이지 지우기
			$("#listTable").html(
					"<tr>"
				    	+"<th>상품번호</th>"
				    	+"<th>상 품 명</th>"
				    	+"<th>상품분류</th>"
				    	+"<th>가격</th>"
				  	+"</tr>"
			)
			
			findAllProduct();
		}
			
	});//function

</script>

<body>
<div id="content_body">
	<div id="title">
			<h3>상품 목록 화면</h3>
	</div>
	
	<div>
		<table id="listTable">
		  <tr>
		    <th>상품번호</th>
		    <th>상 품 명</th>
		    <th>상품분류</th>
		    <th>가격</th>
		  </tr>
		</table>
	</div>
	
	<div align="center">
		<a href="register.jsp">상품 등록</a><br>
		<a href="index.jsp">메인페이지</a>
	</div>
</div>
</body>
</html>