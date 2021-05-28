<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//loginok 세션에서 제거
	session.removeAttribute("loginok");
	//main으로 이동
	response.sendRedirect("../main.jsp");
%>