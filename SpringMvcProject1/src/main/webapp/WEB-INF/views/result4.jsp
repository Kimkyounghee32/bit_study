<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
<h2>
	<pre>
		session과 model에 저장된 데이타 출력하기
		
		이름 : ${name}
		java점수 : ${java }
		spring점수 : ${spring }
		생년월일 : ${sessionScope.birth } <!-- 세션스코프에 있는 myid를 가지고 온다 -->
	</pre>

</h2>
</body>
</html>