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
	<table class="table table-bordered" style="width: 400px;">
		<caption><b>차 정보 수정</b></caption>
		<tr>
			<th width="130" bgcolor="#ddd">자동차명</th>
			<td>
				<!-- name은 dto에 있는 것과 반드시 같아야한다 -->
				<input type="text" name="carname" class="form-control" value="${dto.carname }">
			</td>
		</tr>
		<tr>
			<th width="130" bgcolor="#ddd">단   가</th>
			<td>
				<!-- name은 dto에 있는 것과 반드시 같아야한다 -->
				<input type="text" name="carprice" class="form-control" value="${dto.carprice }">
			</td>
		</tr>
		<tr>
			<th width="130" bgcolor="#ddd">색   상</th>
			<td>
				<!-- name은 dto에 있는 것과 반드시 같아야한다 -->
				<input type="color" name="carcolor" class="form-control" value="${dto.carcolor }">
			</td>
		</tr>
		<tr>
			<th width="130" bgcolor="#ddd">구입일</th>
			<td>
				<!-- name은 dto에 있는 것과 반드시 같아야한다 -->
				<input type="date" name="carguip" class="form-control" value="${dto.carguip }">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-info" 
				style="width: 120px;">JPA수정</button>
				
				<button type="button" class="btn btn-info" style="width: 120px;" 
				onclick="location.href='list'">목록</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>