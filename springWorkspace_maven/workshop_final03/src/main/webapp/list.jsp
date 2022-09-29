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
		var companyName;
		
		refresh();
		
		// 자동차 목록 출력을 위한 전체 car 목록 조회
		function findAllCar() {
			$.ajax({
				type: 'post',
				url: "/findAllCar.do",
				success: function(result) {
					//console.log(result)
					let carList = result;
					for(let i=0; i<carList.length; i++) {
						let vcode = carList[i].vcode;
						findCompany(vcode);
						$('#listTable').append(
							'<tr>'
								+ '<td>' 
								+ '<a href="/detail.do/'
										+carList[i].num+'">'
								+ carList[i].num + '</a>'
								+ '</td>'
								+ '<td>' + carList[i].model + '</td>'
								+ '<td>' + carList[i].price + '</td>'
								+ '<td>' + companyName + '</td>'
								+ '<td><input type=checkbox name="delete" value=' + carList[i].num + ' </td>'
							+'</tr>'
						)
						
					} 
				},
				error: function(e){ console.log(e); }
			})
		}//findAllCar
		
		// 목록에 회사 vcode 대신 vendor를 출력해야해서 vcode로 company를 찾음
		function findCompany(vcode) {
			$.ajax({
				type: 'post',
				url: "/findCompany.do",
				data: {"vcode": vcode},
				async: false,
				success: function(result) {
					companyName = result.vendor;
					//console.log(companyName);
				},
				error: function(e){ console.log(e); }
			})
		}
		
		var numList=[];
		
		function deleteCar() {
			$.ajax({
				type: 'post',
				url: "/deleteCar.do",
				data: {"numList" : numList},
				async: false,
				success: function(result) {
					console.log("delete success : " + result);
				},
				error: function(e){ console.log(e); }
			})
		}
		
		
		$("#delete_a").on("click", function(){
			let checkList = $(":checkbox:checked");
			
			if(checkList.length != 0) {
				$.each(checkList, function(index, item) {
					numList.push(item.value);
				});
				
				console.log("numlist: "+ numList);
				deleteCar();
			}

			refresh();
		})
		
		function refresh() {
			// 페이지 지우기
			$("#listTable").html(
					"<tr>"
				    	+"<th>모델번호</th>"
				    	+"<th>모델이름</th>"
				    	+"<th>가격</th>"
				    	+"<th>제조사명</th>"
				    	+"<th>삭제</th>"
				  	+"</tr>"
			)
			
			findAllCar();
		}
			
	});//function

</script>

<body>
<div id="content_body">
	<div id="title">
			<h3>자동차 관리 - 리스트</h3>
	</div>
	
	<div>
		<table id="listTable">
		  <tr>
		    <th>모델번호</th>
		    <th>모델이름</th>
		    <th>가격</th>
		    <th>제조사명</th>
		    <th>삭제</th>
		  </tr>
		</table>
	</div>
	
	<div align="center">
		<a href="register.jsp">추가 등록</a><br>
		<a href="#" id="delete_a">선택항목 삭제</a>
	</div>
</div>
</body>
</html>