<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		background-color: #3399ff;
	}

	table {
		border-collapse: collapse;
		width: 100%;
		margin: 10px 0px;
	}

</style>
</head>

<script type="text/javascript">
	$(function()
			$.ajax({
				type: 'post',
				url: "findAllEmp.do",
				success: function(result) {
					console.log(result)
					for(let i=0; i<result.length; i++) {
						$('#listTable').append(
							'<tr>'
								+ '<td>' + result[i].num + '</td>'
								+ '<td>'
								+ '<a href="findEmp.do?num='+result[i].num+'">' 
									+ result[i].name + '</a>'
								+ '</td>'
								+ '<td>' + result[i].dept + '</td>'
							+'</tr>'
						)
						
					}
				},
				error: function(e){ console.log(e); }
			})
	});

</script>

<body>
<div id="content_body">
	<div id="title">
			<h3>사원 관리 - 리스트</h3>
	</div>
	
	<div>
		<table id="listTable">
		  <tr>
		    <th>사원번호</th>
		    <th>사원명</th>
		    <th>부서명</th>
		  </tr>
		</table>
	</div>
	
	<div align="center">
		<a href="register.jsp">추가 등록</a>
	</div>
</div>
</body>
</html>