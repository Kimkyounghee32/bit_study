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
	div.box{
		width: 40px;
		height: 40px;
	}
</style>
</head>
<body>
<table class="table table-bordered" style="width: 600px; border: 2px solid gray;">
	<caption><b>상품 상세보기</b></caption>
	<tr>
		<td>
			<span style="font-size:2em;">${dto.sangpum }</span>
			<span style="float : right; color: gray;">
				등록일 :
				<fmt:formatDate value="${dto.writeday }" 
					pattern="yyyy-MM-dd HH:mm"/>
			</span>
		</td>
	</tr>
	<tr>
		<td>
			<h4>가격: 
				<fmt:formatNumber value="${dto.price }" type="currency"/>
			</h4>
			<h4>입고일: ${dto.ipgoday}</h4>
			<h4 style="width: 130px;">상품색상:
				<div class="box" style="background-color: ${dto.color }; float:right;"></div>
			</h4>
			<br>
			<c:if test="${dto.photo=='no'}">
				<h4><b>등록된 사진이 없습니다</b></h4>
			</c:if>
			<c:if test="${dto.photo!='no'}"></c:if>
				<h4><b>상품사진</b></h4>
			<c:forTokens var="s" items="${dto.photo }" delims=",">
				<img alt="" src="photo/${s}" style="max-width: 300px;"><br>
			</c:forTokens>
	</tr>
	<tr>
	<td align="right">
		<button type="button" class="btn btn-info btn-sm"
			style="width: 80px;" onclick="location.href='addform'">상품등록</button>
		<button type="button" class="btn btn-info btn-sm"
			style="width: 80px;"onclick="location.href='list'">상품목록</button>
		<button type="button" class="btn btn-info btn-sm"
		style="width: 80px;"onclick="location.href='updateform?num=${dto.num}'">상품수정</button>
		<button type="button" class="btn btn-info btn-sm"
		style="width: 80px;"onclick="location.href='delete?num=${dto.num}'">상품삭제</button>
	</td>
</tr>
</table>
</body>
</html>