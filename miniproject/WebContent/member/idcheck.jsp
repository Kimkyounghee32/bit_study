<%@page import="data.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디입력</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
<%
 	String key=request.getParameter("key"); //처음 호출 시 null 값
 	if(key==null){
 		//널값일경우에는 폼을 나타내고
 		//키값을 안보내면 널이 된다.
 		//폼과 액션을 같이 쓸때 이렇게 코드짠다.
 		//404오류뜨면 경로보고 앞에 'member/'붙일지 '..'붙일지 보면됨
 	%>
 		<div style="margin: 10px 30px;">
 		<form action="idcheck.jsp" method="post" class="form-inline">
 			<b>아이디를 입력해주세요</b><br>
 			<input type="text" name="mid" class="form-control"
 			style="width: 130px;" float="left;" autofocus="autofocus"
 			required="required" placeholder="아이디입력">
 			
 			<input type="hidden" name="key" value="yes">
 			<button type="submit" class="btn btn-success btn-sm"
 				style="margin-left: 10px;">
 				중복체크</button>
 		</form>
 		</div>
 	<%}else{
 		//action처리
 		String mid=request.getParameter("mid");
 		//dao 선언 후 아이디가 db에 존재하는지 확인
 		MemberDao dao=new MemberDao();
 		boolean b=dao.isIdCheck(mid);
 		if(b){
 			//존재하는 경우
 			%>
 			<div style="margin: 10px 30px;">
 			<h6><%=mid %>는 이미 가입된 아이디 입니다</h6>
 			<img src="../image/08.png" width="60" align="left">
 			
 			<button type="button" class="btn btn-danger btn-sm"
 			onclick="location.href='idcheck.jsp'">다시입력</button>
 			</div>
 			
 		<%}else{
 			//존재하지 않는 경우
 			%>
 			<div style="margin: 10px 30px;">
 			<b><%=mid%>는 사용가능한 아이디 입니다</b>
 			<br>
 			<img src="../image/07.png" width="60" align="left">
 			
 			<button type="button" class="btn btn-infos btn-sm"
 			onclick="saveid('<%=mid%>')">적용하기</button>
 			<!-- 사용가능한 아이디 확인 후 적용하기 누르면 부모창으로 이동 -->
 			
 			<button type="button" class="btn btn-danger btn-sm"
 			onclick="location.href='idcheck.jsp'">다시입력</button>
 			</div>	
 		<%}
 	}
%>

<script type="text/javascript">
	function saveid(id) {
		alert(id);//아이디가 제대로 넘어오는지만 확인
		
		//부모창 : opener
		//자식창에 값주려면 : 오프너.폼이름.각각의네임.벨류=??; 이런식으로 접근하여 벨류주면 된다
		opener.mfrm.mid.value=id;
		//현재창은 닫기
		window.close();
	}

</script>
</body>
</html>