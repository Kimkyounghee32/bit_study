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
<h2 class="alert alert-info">${mes }</h2>
<button type="button" class="btn btn-info" style="width: 130px;"
onclick="location.href='writeform'">회원 추가</button>
<br>
<hr>
<table class="table table-bordered" style="width: 1200px;">
	<caption><b>회원 목록</b></caption>
		<tr align="center" bgcolor="#ddd">
			<th width="60">번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>  
			<th>직업</th>
			<th>주소</th>
			<th>이메일</th>
			<th>연락처</th>
			<th>생년월일</th>
			<th width="100">관리</th>
		</tr>
		<c:forEach var="dto" items="${list}" varStatus="i">
			<tr align="center">
			<td>${i.count}</td>
			<td align="left">${dto.name}</td>
			<td align="left">${dto.id}</td>
			<td align="left">${dto.pass}</td>
			<td align="left">${dto.job}</td>
			<td align="left">${dto.addr}</td>
			<td align="left">${dto.email}</td>
			<td align="left">${dto.hp}</td>
			<td align="left">${dto.birthday }<td>
				<button type="button" class="btn btn-info btn-xs"
					onclick="location.href='updateform?num=${dto.num}'">수정</button>
				<button type="button" class="btn btn-danger btn-xs"
					onclick="location.href='delete?num=${dto.num}'">삭제</button>
			</td>	
		</tr>
	</c:forEach>
</table>
</body>
</html>