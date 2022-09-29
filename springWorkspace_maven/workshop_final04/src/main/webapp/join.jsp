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
		height: relative;
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
	
	#checkId{
		float: right;
	}

</style>
<script type="text/javascript">
	$(function(){
		
		function idExist() {
			$.ajax({
				type: 'post',
				url: "/idExist.do",
				data: {"id": $("#id").val()},
				success: function(result) {
					console.log("result::"+result);
					if(result==true) {
						$("#checkMessage").html("중복 확인 완료");
						$("#checkMessage").css({"color":"blue"});
						$('#btn_join').prop('disabled', false);
					} else {
						$("#checkMessage").html("중복 확인을 눌러주세요");
						$('#btn_join').prop('disabled',true);
					}
				},
				error: function(e){ console.log(e); }
			})
		}
		
		$("#checkId").on("click", function() {
			if($("#id").val() != "") {
				idExist();
			}
		})
	});

</script>
</head>
<body>
	<div id="content_body">
		<form method="post" name="JoinForm" action="/insertUser.do">
			<div id="form" align="center">	
				<div id="title"><h3>회원가입</h3></div>
				<table class="table">
				  	<tbody>
					    <tr class="tr">
					      <td>
					      	아이디:  &nbsp&nbsp&nbsp<input type="text" name="id" id="id" required="required">
					      	<button type="button" class="btn btn-outline-secondary" id="checkId">중복확인</button><br>
					      	<p id="checkMessage" style="color:red">중복 확인을 눌러주세요</p>	
					      </td>
					    </tr>
					    <tr class="tr">
					      <td>비밀번호: <input type="password" name="pw" id="password" required="required"></td>
					    </tr>
				  	</tbody>
				</table>
			</div>
		
			<div id="buttons" align="center">
				<input type="submit" class="btn btn-outline-secondary" id="btn_join" value="가입하기" disabled/>
			</div>
		</form>
	</div>
</body>
</html>