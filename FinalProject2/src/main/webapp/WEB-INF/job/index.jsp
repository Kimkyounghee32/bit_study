<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<style type="text/css">
		div.entire{
	border: 1px solid black;
     min-width: 1000px;
   max-width: 1000px;
   margin: auto;
   padding: 10px;
   height: 100vh;
	}
	
	div.nav {
	height: 100px;
	border: 1px solid black;
	z-index: 1;
	}
	
	div.body {
	margin-top : 50px;
	border: 1px solid black;
	height: 600px;
	}
	
</style>
</head>
<body>

	<div class="entire">
		<div class="nav">
			<jsp:include page="layout/nav.jsp" />
		</div>
		<div class="body">
			<jsp:include page="layout/body.jsp" />
		</div>
		<div class="login">
			<jsp:include page="login/home.jsp" />
		</div>
	</div>
</body>
</html>