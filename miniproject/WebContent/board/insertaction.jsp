<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="dao" class="data.dao.BoardDao"></jsp:useBean>
<jsp:useBean id="dto" class="data.dto.BoardDto"/> <!--이렇게 닫아줘도됩니다-->

<!-- 같은 이름의 데이타를 읽어서 자동으로 dto에 넣어준다 -->
<jsp:setProperty property="*" name="dto"/>
<%	
	//페이지 번호 읽기
	String pageNum=request.getParameter("pageNum");
	//db에 insert
	dao.insertBoard(dto);
	//게시글 목록페이지로 이동
	response.sendRedirect("../main.jsp?go=board/boardlist.jsp?pageNum="+pageNum);
%>
