<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<link rel="stylesheet" href="css/style1.css">
</head>
<%
	//go 를 읽어서 널일경우 body.jsp 를 include
	//널이 아닐경우 해당 파일을 include
	String body="layout/body.jsp";
	String go=request.getParameter("go");//경로 포함한 파일명  //null이 아닐때는 body가 경로가 되어서 화면에 뿌려짐
	if(go!=null)
		body=go;	
%>
<body>
<div class="main">
	<div class="title">
		<jsp:include page="layout/title.jsp"/>
	</div>
	<div class="login">
		<jsp:include page="login/loginmain.jsp"/>
	</div>
	<div class="menu">
		<jsp:include page="layout/menu.jsp"/>
	</div>
	<div class="info">
		<jsp:include page="layout/info.jsp"/>
	</div>
	<div class="body">
		<jsp:include page="<%=body%>"/>
	</div>
</div>

</body>
</html>
