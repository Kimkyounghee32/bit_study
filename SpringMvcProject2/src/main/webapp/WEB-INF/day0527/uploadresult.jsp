<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출력할 리턴파일</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
<h2>이미지 업로드한 결과</h2>
<h3>작성자 : ${name }</h3>
<h3>업로드된 파일명 : ${photo }</h3>
<img alt="" src="image/${photo }" style="max-width: 400px;">
</body>
</html>