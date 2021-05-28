<%@page import="data.dto.AnswerDto"%>
<%@page import="data.dao.AnswerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//엔코딩
	request.setCharacterEncoding("utf-8");

	//idx,content 읽기
	String idx=request.getParameter("idx");
	String content=request.getParameter("content");
	System.out.println(idx);
	System.out.println(content);
	
	//dao선언 후 수정
	AnswerDao dao=new AnswerDao();
	
	//수정메서드 호출
	dao.updateAnswer(idx, content);
	
	//목록으로 이동
	response.sendRedirect("../main.jsp?go=board/answerlist.jsp");

%>