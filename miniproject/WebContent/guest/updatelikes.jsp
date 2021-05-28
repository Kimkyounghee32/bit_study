<%@page import="data.dao.GuestDao"%>
<%@page import="data.dto.GuestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//num읽기
	String num=request.getParameter("num");
	//dao 선언
	GuestDao dao=new GuestDao();
	//num 에 해당하는 likes 값 반대로 변경(0->1,1->0)
	dao.updateLikes(num);
%>
