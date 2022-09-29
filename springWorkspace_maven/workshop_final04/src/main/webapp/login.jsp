<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<style type="text/css">
	#content_body{
		border: 3px solid black;
		width: 500px;
		height: 250px;
		margin: 100px auto;
	}
	
	#forms{
		position : absolute;
	}
	
	#title {
		margin: 10px;
	}

	#buttons{
		margin: 15px;
	}
	

</style>
<script type="text/javascript">

</script>
</head>
<body>
	<div id="content_body">
		<form method="post" name="LoginForm" action="/selectUser.do">
			<div id="form" align="center">	
				<div id="title"><h3>로그인</h3></div>
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
				<input type="submit" class="btn btn-outline-secondary" value="로그인" />
				<a href="join.jsp"><input type="button" class="btn btn-outline-secondary" value="회원가입" /></a>
			</div>
		</form>
	</div>
</body>
</html>