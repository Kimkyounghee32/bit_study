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
<form action="insert" method="post" enctype="multipart/form-data">
	<table class="table table-bordered" style="width: 400px;">
		<caption><b>상품 정보 입력</b></caption>
		<tr>
			<th width="130" bgcolor="#ddd">상품명</th>
			<td>
				<!-- name은 dto에 있는 것과 반드시 같아야한다. 안그럼 널값들어감-->
				<input type="text" name="sangpum" class="form-control" placeholder="상품명">
			</td>
		</tr>
		<tr>
			<th width="130" bgcolor="#ddd">상품사진</th>
			<td>
				<!-- name은 dto에 있는 것과 반드시 같아야한다. 안그럼 널값들어감-->
				<input type="file" name="upload" class="form-control">
			</td>
		</tr>
		<tr>
			<th width="130" bgcolor="#ddd">가격</th>
			<td>
				<!-- name은 dto에 있는 것과 반드시 같아야한다. 안그럼 널값들어감-->
				<input type="text" name="price" class="form-control" placeholder="상품가격">
			</td>
		</tr>
		<tr>
			<th width="130" bgcolor="#ddd">색상</th>
			<td>
				<!-- name은 dto에 있는 것과 반드시 같아야한다. 안그럼 널값들어감-->
				<input type="color" name="color" class="form-control" value="#dddddd">
			</td>
		</tr>
		<tr>
			<th width="130" bgcolor="#ddd">입고일</th>
			<td>
				<!-- name은 dto에 있는 것과 반드시 같아야한다. 안그럼 널값들어감-->
				<input type="date" name="ipgoday" class="form-control" value="2021-01-01">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-info" 
				style="width: 120px;">상품저장</button>
				
				<button type="button" class="btn btn-info" style="width: 120px;" 
				onclick="location.href='list'">목록</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>