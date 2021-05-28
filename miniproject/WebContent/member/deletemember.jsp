<%@page import="java.io.File"%>
<%@page import="com.sun.xml.internal.bind.v2.runtime.Location"%>
<%@page import="data.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//루트(/) 의 서버에 배포된 실제 폴더구하기
	String path=getServletContext().getRealPath("/");
	System.out.println(path);
	//num 읽기
	String num=request.getParameter("num");
	//num에 해당하는 photo 값 얻기
	MemberDao dao=new MemberDao();
	String photo=dao.getData(num).getPhoto();
	//photo의 실제 경로를 save 폴더일 경우에만 해당 이미지 삭제
	if(photo.startsWith("save")){
		File file=new File(path+"\\"+photo);
		file.delete();
	}
	//num에 해당하는 db데이타 삭제
	dao.deleteMember(num);
	
	//로그인시 저장한 세션도 삭제
	session.removeAttribute("loginok");
	session.removeAttribute("mid");
	session.removeAttribute("saveid");
	
	//deletesuccess.jps로 이동(main통하지 않고 전체페이지로 출력)
	response.sendRedirect("deletesuccess.jsp"); 
	
	
%>