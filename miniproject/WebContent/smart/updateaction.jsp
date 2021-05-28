<%@page import="data.dto.SmartDto"%>
<%@page import="data.dao.SmartDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	request.setCharacterEncoding("utf-8");
	//num,pagenum 읽기
	String num=request.getParameter("num");
	String pageNum=request.getParameter("pageNum");
	
	SmartDao dao=new SmartDao();

	SmartDto dto=new SmartDto();
	dto.setNum(num);
	dto.setWriter(request.getParameter("writer"));
	dto.setSubject(request.getParameter("subject"));
	dto.setContent(request.getParameter("content"));
	
	dao.updateSmart(dto);
	//수정후 내용보기 페이지로 이동
		String path="../main.jsp?go=smart/smartcontent.jsp?num="+num
				+"&pageNum="+pageNum;
		response.sendRedirect(path);	


%>