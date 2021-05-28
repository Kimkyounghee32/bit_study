<%@page import="data.dao.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글엔코딩
	request.setCharacterEncoding("utf-8");
	
	//num,start,content 읽기
	String num=request.getParameter("num");
	String start=request.getParameter("start");
	String content=request.getParameter("content");
	
	//dao 선언후 수정
	GuestDao dao=new GuestDao();
	dao.updateGuest(num, content);
	
	//목록으로 이동
	String go="../main.jsp?go=guest/guestlist.jsp?start="+start;
	response.sendRedirect(go);
	
	
%>
