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
			width: 30px;
			height: 30px;
			border: 1px solid black;
			box-shadow:  5px 5px 5px gray;
		}
		
		.photo{
			width: 40px;
			height: 40px;
			border: 1px solid black;
			box-shadosw:  5px 5px 5px gray;
			cursor: pointer;
			margin-right: 10px;
		}
	</style>
</head>
<body>
<img alt="" src="../01.png">
<img alt="" src="../photo/bg18.gif">
<c:if test="${totalCount==0}">
	<div class="alert alert-info">
		<h2>저장된 상품 정보가 없습니다</h2>
	</div>
</c:if>

<c:if test="${totalCount>0}">
	<div class="alert alert-warning">
		<h2>총 ${totalCount} 개의 상품 정보가 있습니다</h2>
	</div>
</c:if>
<br>
<button type="button" class="btn btn-success" style="width: 130px;"
onclick="location.href='addform'">상품 추가</button>
<br>
<table class="table table-bordered" style="width: 1200px;">
	<caption><b>상품 목록</b></caption>
	<tr bgcolor="#ddd">
		<th width="50">번호</th>
		<th width="300">상품</th>
		<th width="80">가격</th>
		<th width="80">색상</th>
		<th width="110">입고일</th>
		<th width="120">등록일</th>
		<th width="100">관리</th>
	</tr>
	<c:forEach var="dto" items="${list}" varStatus="n">
		<tr>
			<td align="center">${n.count }</td>
			<td>
			 	<img alt="" src="../photo/${dto.photo }" class="photo" imgname="${dto.photo }">
			 	${dto.sangpum }
			</td>
			<td>
				<fmt:formatNumber value="${dto.price }" type="currency"/>
			</td>
			<td align="center">
				<div class="box" style="background-color: ${dto.color}"></div>
				${dto.color }
			</td>
			<td align="center">${dto.ipgoday }</td>
			<td align="center">
			 <fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd"/>
			</td>
			<td align="center">
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