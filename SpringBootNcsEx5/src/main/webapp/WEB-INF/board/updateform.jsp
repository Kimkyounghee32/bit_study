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
<form action="update" method="post">
<input type="hidden" name="num" value="${dto.num }">
	<table class="table table-bordered" style="width: 700px; margin-left: 50px; margin-top: 100px;" >
		<caption><b>회원 정보 수정</b></caption>
		<tr>
			<th width="130" bgcolor="#ddd">이름</th>
			<td>
				<!-- name은 dto에 있는 것과 반드시 같아야한다 -->
				<input type="text" name="name" class="form-control" value="${dto.name }">
			</td>
		</tr>
		<tr>
			<th width="130" bgcolor="#ddd">아이디</th>
			<td>
				<!-- name은 dto에 있는 것과 반드시 같아야한다 -->
				<input type="text" name="id" class="form-control" value="${dto.id }" disabled>
			</td>
		</tr>
		<tr>
			<th width="130" bgcolor="#ddd">비밀번호</th>
			<td>
				<!-- name은 dto에 있는 것과 반드시 같아야한다 -->
				<input type="text" name="pass" class="form-control" value="${dto.pass }" disabled>
			</td>
		</tr>
		<tr>
			<th width="130" bgcolor="#ddd">직업</th>
			<td>
				<!-- name은 dto에 있는 것과 반드시 같아야한다 -->
				<input type="text" name="job" class="form-control" value="${dto.job }">
			</td>
		</tr>
		<tr>
			<th width="130" bgcolor="#ddd">주소</th>
			<td>
				<!-- name은 dto에 있는 것과 반드시 같아야한다 -->
				<input type="text" name="addr" class="form-control" value="${dto.addr }">
			</td>
		</tr>
		<tr>
			<th width="130" bgcolor="#ddd">이메일</th>
			<td>
				<!-- name은 dto에 있는 것과 반드시 같아야한다 -->
				<input type="email" name="email" class="form-control" value="${dto.email }">
			</td>
		</tr>
		<tr>
			<th width="130" bgcolor="#ddd">연락처</th>
			<td>
				<!-- name은 dto에 있는 것과 반드시 같아야한다 -->
				<input type="text" name="hp" class="form-control" value="${dto.hp }">
			</td>
		</tr>
		<tr>
			<th width="130" bgcolor="#ddd">생년월일</th>
			<td>
				<!-- name은 dto에 있는 것과 반드시 같아야한다 -->
				<input type="text" name="birthday" class="form-control" value="${dto.birthday }">
			</td>
		</tr> 
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-info" 
				style="width: 120px;">수정</button>
				
				<button type="button" class="btn btn-info" style="width: 120px;" 
				onclick="location.href='list'">목록</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>