<%@page import="data.dao.GuestDao"%>
<%@page import="data.dto.GuestDto"%>
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
<%
	//num 읽기
	String num=request.getParameter("num");
	//수정 후 보던페이지로 가기 위해서 start도 읽는다
	String start=request.getParameter("start");
	//num에 해당하는 dto 얻기
	GuestDao dao=new GuestDao();
	GuestDto dto=dao.getData(num);
	
%>

<!-- 수정폼에서는 히든이 제일 중요. 
값을 바로 보낼 수 없으니까 폼으로 보냈다가 업데이트 액션으로 보내준다??? 
자바스크립트 명령어는 그냥써도 되요. 파일보낼때만 로케이션.href씁니다-->

<div class="update">
	<form action="guest/updateaction.jsp" method="post">
		
		<!-- hidden  -->
		<input type="hidden" name="num" value="<%=num%>">
		<input type="hidden" name="start" value="<%=start%>">
		
		<table class="table table-bordered" style="width: 400px;">
			<caption><b>내용 수정</b></caption>
			<tr>
				<td>
					<textarea style="width: 390px; height: 100px;"
					 name="content" class="form-control"><%=dto.getContent() %></textarea>
				</td>
			</tr>
			<tr>
				<td align="center">
					<button type="submit" class="btn btn-info"
					style="width: 120px;">수정</button>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>