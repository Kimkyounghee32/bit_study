<%@page import="data.dao.BoardDao"%>
<%@page import="data.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num=request.getParameter("num");
	String pageNum=request.getParameter("pageNum");
	BoardDao dao=new BoardDao();
	dao.deleteBoard(num);
	
	response.sendRedirect("../main.jsp?go=board/boardlist.jsp?pageNum="+pageNum);
%>