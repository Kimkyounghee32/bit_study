<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<form action="insert" method="post" enctype="multipart/form-data">
	<table class="table table-bordered" style="width: 400px;">
		<caption><b>상품추가</b></caption>
		<tr>
			<th bgcolor="tomato" width="100">상품명</th>
			<td>
				<!-- 선언한 네임들은 dto와 같아야 나중에 읽어올수 있다. -->
				<input type="text" class="form-control" name="sangpum"
					required="required" placeholder="상품명">
			</td>
		</tr>
		<tr>
		<th bgcolor="tomato" width="100">색상</th>
			<td>
				<input type="color" class="form-control" name="color"
					value="#ccff33">
			</td>
		</tr>
		<tr>
		<th bgcolor="tomato" width="100">상품사진</th>
			<td>
				<input type="file" class="form-control" name="upload"
					multiple="multiple">
			</td>
		</tr>
		<tr>
		<th bgcolor="tomato" width="100">가격</th>
			<td>
				<input type="text" class="form-control" name="price"
					required="required" style="width: 150px;" placeholder="가격">
			</td>
		</tr>
		<tr>
		<th bgcolor="tomato" width="100">입고일</th>
			<td>
				<input type="date" class="form-control" name="ipgoday"
					value="${day}">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-info"
				style="width:100px;">상품저장</button>
				
				<button type="button" class="btn btn-sucess"
				style="width:100px;" onclick="location.href='list'">상품목록</button>
		
	</table>
</form>
</body>
</html>