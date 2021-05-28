<?xml version="1.0" encoding="UTF-8"?>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="data.dto.AnswerDto"%>
<%@page import="data.dao.MemberDao"%>
<%@page import="data.dao.AnswerDao"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<data>
<%
	String num=request.getParameter("num");
	AnswerDao adao=new AnswerDao();
	MemberDao mdao=new MemberDao();
	List<AnswerDto> list=adao.getAnswerList(num);
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	for(AnswerDto dto:list)
	{
		String name=mdao.getName(dto.getMyid());
	%>
	
	<answer idx="<%=dto.getIdx()%>" num="<%=dto.getNum()%>">
	<content><%=dto.getContent()%></content>
	<myid><%=dto.getMyid()%></myid>
	<name><%=name%></name>
	<writeday><%=sdf.format(dto.getWriteday())%></writeday>
	</answer>
	<%}
%>	
</data>