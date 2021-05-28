<%@page import="data.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//mid,pass,saveid 읽기
	String mid=request.getParameter("mid");
	String pass=request.getParameter("pass");
	String saveid=request.getParameter("saveid");//체크 안하면 null
	
	//dao 의 getLogin 호출
	//1인경우
	//세션저장후 main 페이지로 가기	
	//2인경우 '비밀번호가 맞지 않습니다' 경고후 이전페이지로 가기
	//2인경우 '가입되지 않은 아이디입니다' 경고후 이전페이지로 가기
	MemberDao dao=new MemberDao();
	int idx=dao.getLogin(mid, pass);
	
	if(idx==1)
	{
		//session 저장
		session.setAttribute("mid", mid);
		session.setAttribute("saveid", saveid==null?"no":"yes");
		session.setAttribute("loginok", "yes");
		session.setMaxInactiveInterval(60*60*8);//8시간 유지
		
		response.sendRedirect("../main.jsp");//메인페이지로 이동
	}else if(idx==2){%>
		<script type="text/javascript">
			alert("비밀번호가 맞지 않습니다");
			history.back();			
		</script>
	<%}
	else if(idx==3){%>
	<script type="text/javascript">
		alert("가입되지 않은 아이디입니다");
		history.back();			
	</script>
<%}
%>
