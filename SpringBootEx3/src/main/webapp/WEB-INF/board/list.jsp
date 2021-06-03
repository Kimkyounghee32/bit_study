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
<style type="text/css">
	.box{
		width: 40px;
		height: 50px;
		border: 1px solid gray;
	}
</style>
</head>
<body>
<h2 class="alrer alert-info">${mes}</h2>
<button type="button" class="btn btn-info" 
style="width: 120px;"onclick="location.href='carform'">추가</button>
<hr>
<!-- 테이블로 출력하는데 번호, 자동차명, 단가, 색상, 구입일, 등록일 -->
<table class="table table-bordered" style="width: 1200px;">
	<caption><b>자동차 목록</b></caption>
	<tr align="center" bgcolor="#ddd">
		<th width="60">번호</th>
		<th width="150">자동차명</th>
		<th width="250">단가</th>
		<th width="150">색상</th>
		<th width="250">구입일</th>
		<th width="250">등록일</th>
		<th width="100">관리</th>		
	</tr>
	<c:forEach var="dto" items="${list}" varStatus="i">
		<tr align="center">
			<td>${i.count}</td>
			<td align="left">${dto.carname}</td>
			<td align="left">
				<fmt:formatNumber value="${dto.carprice}" type="currency"/> 
			</td>
			<td>
				<div style="background-color:${dto.carcolor}" class="box"></div>
				<b>${dto.carcolor}</b>
			</td>
			<td>${dto.carguip}</td>
			<td>
			<!-- 수정하면 작성일이 수정시간 기준으로 나와서 db에 널값으로 들어간다. 이거 고쳐보자 -->
				<c:if test="${dto.writeday==null }">
				<fmt:formatDate value="${dto.updateday}"
					pattern="yyyy-MM-dd HH:mm"/>
				</c:if>
				<c:if test="${dto.writeday!=null }">
				<fmt:formatDate value="${dto.writeday}"
					pattern="yyyy-MM-dd HH:mm"/>
				</c:if>
				
			</td>
	  		<td>
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