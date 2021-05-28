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
	String loginok=(String)session.getAttribute("loginok");
	if(loginok==null)
	{%>
		<script type="text/javascript">
			alert("글을 쓰려면 먼저 로그인을 해주세요");
			history.back();
		</script>
	<%}else{
		//답글일 경우 4가지 읽기
		String num=request.getParameter("num");
		String reg=request.getParameter("reg");
		String restep=request.getParameter("restep");
		String relevel=request.getParameter("relevel");
		String pageNum=request.getParameter("pageNum");
		
		if(num==null){  //integer로 바꿀때 널포인트익셉션이나 넘버포맷익셉션 오류 막기 위해 0으로선언			
			num="0";
			reg="0";
			restep="0";
			relevel="0";
			pageNum="1";
		}
		%>
		
		<!-- 
		//널일때 0으로 넘겼으니까 답글일땐 그때그때값들어가고 원글일때 0으로 넘어감. 
		//자바빈즈 사용해서 자동으로 넘길거라. -->
	
	
		<form action="board/insertaction.jsp" method="post"> <!--post = 웹 브라우저가 웹 서버에 데이터를 전달하기 위해서 사용  -->
		<input type="hidden" name="num" value="<%=num %>"> <!--value는 스트링,인티저 상관없음 -->
		<input type="hidden" name="reg" value="<%=reg %>">
		<input type="hidden" name="restep" value="<%=restep %>">
		<input type="hidden" name="relevel" value="<%=relevel %>">
		<input type="hidden" name="pageNum" value="<%=pageNum %>">
		
		
		<table class="table table-bordered" style="width: 500px;">
			<%
				//세션에서 아이디 얻어오기
				String myid=(String)session.getAttribute("mid");
			%>
			<caption><b><%=num.equals("0")?"글쓰기":"답글쓰기" %></b></caption>
			<tr>
				<th width="100" bgcolor="#ccc">아이디</th>
				<td>
					<input type="text" name="myid" class="form-control"
					readonly="readonly" style="width: 120px;"
					value="<%=myid%>">
				</td>
			</tr>
				<tr>
				<th width="100" bgcolor="#ccc">제목</th>
				<td>
					<input type="text" name="subject" class="form-control"
					style="width: 120px;">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea name="content" class="form-control"
					style="width: 450px; height: 120px;"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-default"
					style="width: 120px;">저장하기</button>
				</td>
			</tr>
		</table>
		</form>
	<%}	
%>
	
	
</body>
</html>