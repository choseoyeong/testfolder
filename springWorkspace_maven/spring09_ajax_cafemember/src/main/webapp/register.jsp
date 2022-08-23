<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#id').keyup(function(){
			//1. 아이디 요건을 충족하는지의 여부를 가늠..
			var id = $(this).val();
			if(id.length<4 || id.length>8){
				$('#check').html('4자 이상 8자 이하로 작성').css('color', 'red');
				$('#submit_button').attr('disabled',true);
			} else {	// 2. 아이디 요건을 충족하면 DB가서 존재유무를 따진다..
				$.ajax({
					//요청부분
					type: 'post',
					url: 'idExist.do',
					data: 'id=' + id,
					
					//응답부분
					success: function(result){
						var jsonData = JSON.parse(result);
						console.log(jsonData);
						if(jsonData.check==true){
							$('#check').html('이미 사용중인 아이디!').css('color', 'red');
							$('#submit_button').attr('disabled',true);
						} else {
							$('#check').html('사용 가능 아이디!').css('color', 'blue');
							$('#submit_button').attr('disabled',false);
						}
					}// success
				}); //ajax
			} //else
		}); //keyup
	});//ready
</script>
</head>
<body>
<h3>회원가입</h3>
<!-- register_action에서 하고있는 기능이  RegisterServletd으로 이동
	 register_result.jsp로 결과를 보낸다.
-->
<form action="register.do" name="registerForm" >
ID : <input type="text" name="id" id="id" required="required"><span id="check" style="margin-left:10px;"></span><br><br>
PASSWORD : <input type="password" name="password" required="required"><br><br>
NAME : <input type="text" name="name" required="required"><br><br>
ADDRESS : <input type="text" name="address" required="required"><br><br>

<input type="submit" value="member register" id="submit_button">
</form>
</body>
</html>



















