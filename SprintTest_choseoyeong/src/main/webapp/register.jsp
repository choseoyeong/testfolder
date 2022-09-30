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
		/* findAllCompany();
		
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
		 */
		

	});	// function
</script>
<body>
<div id="content_body">
	<div id="title">
		<h3 align=center>상품 등록 화면</h3>
	</div>
	<form method="post" name="registerForm" action="insertProduct.do">
		<div id="form">	
			<table class="table">
		  	<tbody>
			    <tr class="tr">
			      <th scope="row" class="table_row">상품번호</th>
			      <td><input type="text" name="code" id="input_code" required="required"></td>
			    </tr>
			    <tr class="tr">
			      <th scope="row" class="table_row">상품제목</th>
			      <td><input type="text" name="title" id="input_title" required="required"></td>
			    </tr>
			    <tr class="tr">
			      <th scope="row" class="table_row">상품종류</th>
			      <td>
		      		<select name="category" id="input_category">
		      			<option name=category value="목돈마련">목돈마련</option>	
		      			<option name=category value="학자금">학자금</option>	
		      			<option name=category value="주택마련">주택마련</option>	
				  	</select>
			      </td>
			    </tr>
			    <tr class="tr">
			      <th scope="row" class="table_row">이율</th>
			      <td><input type="text" name="rate" id="input_rate"></td>
			    </tr>
			     <tr class="tr">
			      <th scope="row" class="table_row">상품설명</th>
			      <td><input type="text" name="memo" id="input_memo"></td>
			    </tr>
		  </tbody>
		</table>
		</div>
	
		<div id="buttons" align="center">
			<input type="submit" class="btn btn-outline-secondary" value="상품저장" />
			<a href="index.jsp"><input type="button" class="btn btn-outline-secondary" value="취소" /></a>
		</div>
	</form>
</div>
</body>
</html>