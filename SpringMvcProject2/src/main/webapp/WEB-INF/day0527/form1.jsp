<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form1</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
<form action="read1" method="post" class="form-inline">
	<table class="table table-bordered" style="width: 300px;">
		<caption><b>폼 데이터 각각 읽기</b></caption>
		<tr>
			<th bgcolor="orange" width="100">이름</th>
			<td>
				<input type="text" name="name" class="form-control">
			</td>
		</tr>
		<tr>
			<th bgcolor="orange" width="100">성별</th>
			<td>
				<div class="form-group">
					<input type="radio" name="gender" class="form-control" 
					value="남자" checked="checked">남자
					<input type="radio" name="gender" class="form-control" 
					value="여자" checked="checked">여자
				</div>
			</td>
		</tr>
		<tr>
			<th bgcolor="orange" width="100">입사일</th>
			<td>
					<input type="date" name="ipsa" class="form-control" 
					value="2020-10-10">
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