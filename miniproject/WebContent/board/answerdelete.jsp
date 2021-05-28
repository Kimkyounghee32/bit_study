<%@page import="data.dao.AnswerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String idx=request.getParameter("idx");
	String pageNum=request.getParameter("pageNum");
	AnswerDao dao=new AnswerDao();
	dao.deleteAnswer(idx);
	
	response.sendRedirect("../main.jsp?go=board/answerlist.jsp?pageNum="+pageNum);
	
%>