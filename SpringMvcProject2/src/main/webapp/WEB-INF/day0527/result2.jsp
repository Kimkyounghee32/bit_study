<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
<h3 class="alert alert-danger">폼데이타 dto 로 읽기 결과</h3>
<h3>상품명 : ${dto.sang}</h3>
<h3>색상 : ${dto.color}</h3>
<h3>가격 : 
<fmt:formatNumber type="currency" value="${dto.price}"/></h3>
</body>
</html>

