<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form2</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
<form action="read3" method="post" class="form-inline">
	<table class="table table-bordered" style="width: 300px;">
		<caption><b>폼 데이터 Map로 읽기</b></caption>
		<tr>
			<th bgcolor="orange" width="100">이름</th>
			<td>
				<input type="text" name="name" class="form-control">
			</td>
		</tr>
		<tr>
			<th bgcolor="orange" width="100">점수</th>
			<td>
				<div class="form-group">
					<input type="text" name="java" 
					class="form form-control input-sm" style="width: 50px;">
					<input type="text" name="html" 
					class="form form-control input-sm" style="width: 50px;">
					<input type="text" name="spring" 
					class="form form-control input-sm" style="width: 50px;">
				</div>
			</td>
		</tr>
		<tr>
			<th bgcolor="orange" width="100">키,몸무게</th>
			<td>
				<div class="form-group">
					<input type="text" name="height" 
					class="form form-control input-sm" style="width: 70px;"
					placeholder="키">
					<input type="text" name="weight" 
					class="form form-control input-sm" style="width: 70px;"
					placeholder="몸무게">
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-info">
				데이타전송</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>