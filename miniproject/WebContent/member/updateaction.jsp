<%@page import="data.dto.MemberDto"%>
<%@page import="data.dao.MemberDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String realPath=getServletContext().getRealPath("/save");
	int uploadSize=1024*1024*2;//2mb
	
	MultipartRequest multi=null;
	try{
		multi=new MultipartRequest(request,realPath,uploadSize,
				"utf-8",new DefaultFileRenamePolicy());
		//dao 선언
		MemberDao dao=new MemberDao();
		//dto 선언
		MemberDto dto=new MemberDto();
		
		dto.setNum(multi.getParameter("num"));
		dto.setName(multi.getParameter("name"));
		dto.setHp(multi.getParameter("hp"));
		dto.setAddr(multi.getParameter("addr"));
		dto.setAddrdetail(multi.getParameter("addrdetail"));
		
		String photo=multi.getFilesystemName("photo");
		if(photo==null){
			//사진 선택 안한경우 기존의 photo 값을 그대로 다시 넣어준다
			String p=dao.getData(dto.getNum()).getPhoto();
			dto.setPhoto(p);
		}else
			dto.setPhoto("save/"+photo);//사진 선택한경우
			
		//db update
		dao.updateMember(dto);
		//성공후 이동
		response.sendRedirect("../main.jsp?go=member/memberlist.jsp");//멤버목록으로 이동		
		
	}catch(Exception e){
		System.out.println("업로드오류:"+e.getMessage());
	}

%>
