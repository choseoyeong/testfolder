<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 
FileUpload 규칙
1. pom.xml에 라이브러리 추가(디펜던시 추가)...commons fileupload
2. method 방식을 post로 지정(get 방식은 안됨)
	그래서 <a>태그는 안되고 form태그 써야 함
3. enctype 속성 추가
4. input type="file" 폼을 사용함
5. MultipartFile 빈을 빈 설정문서에 등록한다.
 -->
<body>
<h2 align="center">File Upload Form...</h2>
<form action="fileupload.do" method="post" enctype="multipart/form-data">
	사용자명 <input type="text" name="userName">
	<input type="file" name="uploadFile">
	<input type="submit" value="파일업로드하기">
</form>
</body>
</html>


<!--  
지금까지는 여기까지 로직을 작성한 후 요청을 처리하는 Controller를 작성했다면,
파일업로드 만큼은 업로드한 파일정보를 저장할 VO를 먼저 작성해야 한다.
-->