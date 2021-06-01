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
<table class="table table-bordered" style="width: 1200px; margin-left: 100px">
	<caption><b>게시판 내용보기</b></caption>
	<tr>
		<td align="left"><b>${dto.subject}</b>
			<span style="float: right;">
			 	<fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm"/> 
			</span>
		</td>
	</tr>
	<tr>
		<td>
			<b>${dto.writer}(${dto.id })</b>
			<span style="float: right;">조회 ${dto.readcount}</span>
		</td>
	</tr>
	<tr>
		<td>
		<pre>${dto.content}</pre>
		<br>
			<c:if test="${dto.uploadname!='no'}">
				<c:forTokens var="im" items="${dto.uploadname}" delims=",">
					<img alt="" src="../image/${im}" class="img-thumbnail"
					style="max-width: 200px;">&nbsp;&nbsp;
				</c:forTokens>
			</c:if>
		</td>
	</tr>
	<tr>
		<td>
			<c:if test="${sessionScope.loginok!=null}">
				<button type="button" class="btn btn-info btn-xs"
				onclick="location.href='form?num=${dto.num}&reg=${dto.reg}&restep=${dto.restep}
					&relevel=${dto.relevel}&pageNum=${pageNum}'">답글</button>
			</c:if>
			
			<c:if test="${sessionScope.myid==dto.id }">
				<button type="button" class="btn btn-info btn-xs"
				onclick="location.href='updateform?num${dto.num}&pageNum=${pageNum}'">수정</button>
				
				<button type="button" class="btn btn-info btn-xs"
				onclick="location.href='delete?num=${dto.num}&pageNum=${pageNum}'">삭제</button>
			</c:if>
			
			<button type="button" class="btn btn-info btn-xs"
			onclick="location.href='list?pageNum=${pageNum}'">목록</button>
		</td>
	</tr>
</table>
</body>
</html>