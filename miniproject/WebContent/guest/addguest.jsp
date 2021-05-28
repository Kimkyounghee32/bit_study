<%@page import="data.dao.GuestDao"%>
<%@page import="data.dto.GuestDto"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//실제 저장되는 save 폴더의 경로
	String realPath=getServletContext().getRealPath("/save");
	System.out.println(realPath);
	
	//업로드 파일의 사이즈
	int uploadSize=1024*1024*2;//2mb까지 허용
	
	MultipartRequest multi=null;
	String photo="";
	try{
		multi=new MultipartRequest(request,realPath,uploadSize,"utf-8",
				new DefaultFileRenamePolicy());
		//작성자, 내용 먼저 읽기
		String writer=multi.getParameter("writer");
		String content=multi.getParameter("content");
		//업로드한 파일들 얻기
		Enumeration en=multi.getFileNames();
		while(en.hasMoreElements())
		{
			//file태그의 실제 name 가져오기
			String name=(String)en.nextElement();
			//업로드된 실제 파일명 얻기
			String uploadFile=multi.getFilesystemName(name);
			if(uploadFile!=null){
				photo+=uploadFile+",";
			}
		}
		//마지막 컴마 제거(단 길이가 0인경우는 no 라고 저장하자)
		if(photo.length()>0)
			photo=photo.substring(0,photo.length()-1);
		else
			photo="no";
		
		//dto 에 데이타 넣기
		GuestDto dto=new GuestDto();
		dto.setWriter(writer);
		dto.setContent(content);
		dto.setPhoto(photo);
		
		//dao 선언
		GuestDao dao=new GuestDao();
		
		//insert 메서드 호출
		dao.insertGuest(dto);
		
		//메인페이지에 guestlist 출력하도록 이동
		response.sendRedirect("../main.jsp?go=guest/guestlist.jsp");		
		
	}catch(Exception e){
		System.out.println("업로드 오류:"+e.getMessage());
	}
%>
