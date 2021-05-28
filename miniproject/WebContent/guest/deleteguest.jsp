<%@page import="java.io.File"%>
<%@page import="data.dao.GuestDao"%>
<%@page import="data.dto.GuestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	String num=request.getParameter("num");
	GuestDao dao=new GuestDao();
	
	//getData로 부터 photo를 얻는다 (photo)
	String photo=dao.getData(num).getPhoto();
	//photo 값이 no가 아닐 경우 ,로 분리해서 배열변수값을 얻는다(arrphoto)
	//save폴더의 서버에 배포된 실제경로를 구한다(realPath)
	//arrphoto로 반복문
	//File 객체를 생성(realFolder+"\\"+파일명) 후 delete() 메서드 실행하면
	//실제 경로에서 파일 삭제됩니다
	
	String realPath=getServletContext().getRealPath("/save");
	//System.out.println(realPath);
	
	if(!photo.equals("no")){
		//,로 분리하기
		String []arrphoto=photo.split(",");
		for(String f:arrphoto){
			File file=new File(realPath+"\\"+f);
			file.delete();
		}		
	}
	
	dao.deleteGuest(num);
%>