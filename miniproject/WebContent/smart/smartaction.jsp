<%@page import="data.dto.SmartDto"%>
<%@page import="data.dao.SmartDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	request.setCharacterEncoding("utf-8");
	SmartDao dao=new SmartDao();

	SmartDto dto=new SmartDto();
	dto.setWriter(request.getParameter("writer"));
	dto.setSubject(request.getParameter("subject"));
	dto.setContent(request.getParameter("content"));
	
	dao.insertSmart(dto);
	
	//추가 후 목록으로 이동
	//response.sendRedirect("../main.jsp?go=smart/smartlist.jsp");
	
	//추가 후 방금 입력한 글에 대한 내용보기 페이지로 이동되도록 해주세요
	//방금 추가된 시퀀스 값 얻기
	int num=dao.getMaxNum();
	response.sendRedirect("../main.jsp?go=smart/smartcontent.jsp?num="+num);

%>