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
<form action="upload2" method="post" class="form-inline"
   enctype="multipart/form-data">
	<table class="table table-bordered" style="width: 400px;">
		<caption><b>다른 폴더의 여러개 이미지 업로드</b></caption>
		<tr>
			<th bgcolor="orange" width="100">이름</th>
			<td>
				<input type="text" name="name" class="form-control">
			</td>
		</tr>
		<tr>
			<th bgcolor="orange" width="100">사진1</th>
			<td>
				<input type="file" class="form-control" name="photo">
			</td>
		</tr>
		<tr>
			<th bgcolor="orange" width="100">사진2</th>
			<td>
				<input type="file" class="form-control" name="photo">
			</td>
		</tr>
		<tr>
			<th bgcolor="orange" width="100">사진3</th>
			<td>
				<input type="file" class="form-control" name="photo">
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-info">
				업로드하기</button>				
			</td>
		</tr>
	</table>
</form>
</body>
</html>
