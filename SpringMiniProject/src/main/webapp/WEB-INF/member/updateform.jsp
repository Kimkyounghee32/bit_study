<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateform</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
<form action="update" method="post" enctype="form-inline">
	<input type="hidden" name="num" value="${dto.num }">
	<table class="table table-bordered" style="width:500px;">
		<caption><b>회원정보 수정</b></caption>
		<tr>
			<th bgcolor="orange" width="120">회원명</th>
			<td>
				<input type="text" class="form-control" name="name"
					placeholder="회원명" required="required"
					style="width: 130px;" value="${dto.name }">
			</td>
		</tr>
		<%-- <tr>
			<th bgcolor="orange" width="120">아이디</th>
			<td>
				<input type="text" class="form-control" name="id" id="id"
					placeholder="아이디" 
					style="width: 130px;" value="${dto.id }" >
			</td>
		</tr> --%>
		<tr>
			<th bgcolor="orange" width="120">핸드폰</th>
			<td>
				<input type="text" class="form-control" name="hp"
					placeholder="핸드폰" required="required"
					style="width: 200px;" value="${dto.hp }">
			</td>
		</tr>
		<tr>
		<!-- 비번은 맞을때만 수정이니까 벨류찍으면 안됨 -->
			<th bgcolor="orange" width="120">비밀번호</th>
			<td>
				<input type="text" class="form-control" name="pass"
					placeholder="비밀번호" 
					style="width: 150px;">
			</td>
		</tr> 
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-info">정보수정</button>
				<button type="button" class="btn btn-info"
				onclick="location.href='list'">목록이동</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>
