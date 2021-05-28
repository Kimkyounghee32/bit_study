<%@page import="data.dto.BoardDto"%>
<%@page import="data.dao.BoardDao"%>
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
	BoardDao dao=new BoardDao();
	BoardDto dto=dao.getData(num);
	
%>

<div class="update">
	<form action="board/boardupdateaction.jsp" method="post">
	
	<!-- hidden  -->
		<input type="hidden" name="num" value="<%=num%>">
		<input type="hidden" name="start" value="<%=start%>">
		
		<table class="table table-bordered" style="width: 600px;">
			<caption><b>수정</b></caption>
			<tr>
				<th width="100" bgcolor="#ccc">제목</th>
				<td>
					<input type="text" name="subject" class="form-control"
					style="width: 120px;" value="<%=dto.getSubject()%>">
				</td>
			</tr>
			<tr>
				<th width="100" bgcolor="#ccc">내용</th>
				<td>
					<textarea style="width: 390px; height: 100px;"
					 name="content" class="form-control" ><%=dto.getContent()%></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-info"
					style="width: 120px;">수정</button>
				</td>
			</tr>
		</table>
</form>
</div>

</body>
</html>