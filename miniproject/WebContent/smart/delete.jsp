<%@page import="data.dao.SmartDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num=request.getParameter("num");
	String pageNum=request.getParameter("pageNum");
	
	SmartDao dao=new SmartDao();
	dao.deleteSmart(num);
	
	String path="../main.jsp?go=smart/smartlist.jsp?pageNum="+pageNum;
	response.sendRedirect(path);	
%>