<%@page import="data.dto.MemberDto"%>
<%@page import="data.dao.MemberDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String realPath=getServletContext().getRealPath("/save");
	int uploadSize=1024*1024*2; //2mb
	
	MultipartRequest multi=null;
	try{
	multi=new MultipartRequest(request,realPath,uploadSize,
			"utf-8",new DefaultFileRenamePolicy());
	//dao선언
	MemberDao dao=new MemberDao();
	//dto선언
	MemberDto dto=new MemberDto();
	
	dto.setMid(multi.getParameter("mid"));
	dto.setName(multi.getParameter("name"));
	dto.setPass(multi.getParameter("pass"));
	dto.setHp(multi.getParameter("hp"));
	dto.setAddr(multi.getParameter("addr"));
	dto.setAddrdetail(multi.getParameter("addrdetail"));
	
	String photo=multi.getFilesystemName("photo");
	if(photo==null)
		dto.setPhoto("image/04.png"); //사진 선택한 경우 //required 안줬기때문에 사진 안넣어도 에러 안남
	else
		dto.setPhoto("save/"+photo); //사진 선택한 경우
		
	//db insert
	dao.insertMember(dto);
	//성공 후 이동
	response.sendRedirect("../main.jsp"); //메인페이지로이동
	
	}catch(Exception e){
		System.out.println("업로드 오류:"+e.getMessage()); //콘솔에 에러 확인하기 위한 코드
	}
	
%>