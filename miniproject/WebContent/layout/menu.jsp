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
<ul>
	<li>
		<a href="main.jsp">Home</a>
	</li>
	<li>
		<a href="main.jsp?go=member/memberform.jsp">회원가입</a>
	</li>
	<li>
		<a href="main.jsp?go=member/memberlist.jsp">회원명단</a>
	</li>
	<li>
		<a href="main.jsp?go=board/boardlist.jsp">게시판</a>
	</li>
	<li>
		<a href="main.jsp?go=smart/smartlist.jsp">Q&A게시판</a>
	</li>
	<li>
		<a href="main.jsp?go=guest/guestlist.jsp">방명록</a>
	</li>
</ul>
</body>
</html>