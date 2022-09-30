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
	.content_body{
		margin: 30px;
		padding: 10px;
		border: 3px solid lightgray;
		border-radius: 10px;
		background-color: lightgray;
	}
	
	#login{
		background-color: white;
		width: 60%;
		padding: 10px;
	}
</style>
</head>
<script>
$(function() {
	var userid = '<%= (String)session.getAttribute("userid")%>';
	
	if(userid != null) {
		$('#LoginForm').hide();
	}
	
});


</script>
<body>
<div class='content_body' align="center">
	<h2>메인 페이지</h2><br>
	
	<form method="post" name="LoginForm" id="LoginForm" action="/selectUser.do">
		<div id="login" align="center">
			<div id="form" align="center">	
				<div id="title"><h3>로그인</h3></div>
				<div id="message"><p>${loginMsg}<p></div>
				<table class="table">
				  	<tbody>
					    <tr class="tr">
					      <td>아이디:  &nbsp&nbsp&nbsp<input type="text" name="id" id="id" required="required"></td>
					    </tr>
					    <tr class="tr">
					      <td>비밀번호: <input type="password" name="password" id="password" required="required"></td>
					    </tr>
				  	</tbody>
				</table>
			</div>
		
			<div id="buttons" align="center">
				<input type="submit"  id="btn_login" class="btn btn-outline-secondary" value="로그인" />
				
			</div>
		</div>
	</form>
	
	<a href="/logout.do"><input type="button"  id="btn_logout" class="btn btn-outline-secondary" value="로그아웃" /></a><br>
	<a href='register.jsp'>상품 등록</a><br>
	<a href='list.jsp'>상품 목록</a>
</div>
</body>
</html>