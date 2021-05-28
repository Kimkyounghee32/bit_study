<%@page import="data.dao.MemberDao"%>
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
	//로그인 상태냐 아니냐는 얘로만 나타낼거예요
	if(loginok==null)//로그인 상태가 아닐경우 로그인 창을 띄운다
	{%>
		<button class="btn btn-success" style="width: 120px; margin-left: 100px;"
			onclick="location.href='login/loginform.jsp'">로그인</button>
	<%}else{ //로그인ok상태가 되었을 경우, 아이디와 이름을 얻고 회원명과 로그아웃 버튼을 띄운다
		
		MemberDao dao=new MemberDao();
		//세션에 저장된 아이디 얻기
		String id=(String)session.getAttribute("mid");
		
		//id에 해당하는 이름 얻기
		String name=dao.getName(id);
		%>
		
		<b><%=name%>님</b>
		<button class="btn btn-default" 
			style="width: 120px; margin-left: 30px;"
			onclick="location.href='login/logoutaction.jsp'">로그아웃</button>
	<%}
%>
</body>
</html>