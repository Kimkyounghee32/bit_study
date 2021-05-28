<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.SmartDto"%>
<%@page import="data.dao.SmartDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>


</head>
<body>
<%
	String num=request.getParameter("num");
	String pageNum=request.getParameter("pageNum");
	if(pageNum==null)
		pageNum="1";
	String key=request.getParameter("key");
	
	//key가 널이 아닌 경우 조회수 1증가
	SmartDao dao=new SmartDao();
	
	if(key!=null)
		dao.updateReadcount(num);
	
	//dto가져오기
	SmartDto dto=dao.getData(num);
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
%>

<table class="table table-bordered" style="width: 600px; margin-left: 100px;">
	<caption>내용확인</caption>
	<tr>
		<td>
			<b><%=dto.getWriter()%></b>
			<span style="color:gray; float: right;">
				<%=sdf.format(dto.getWriteday())%>
			</span>
		</td>
	</tr>
		<tr>
		<td>
			<b style="font-size: 23pt;"><%=dto.getSubject()%></b>
			<span style="color:gray; float: right;">
				조회<%=dto.getReadcount()%>
			</span>
		</td>
	</tr>
	<tr>
		<td>
			<%=dto.getContent().replace("\n", "<br>") %>
		</td>
	</tr>
	<tr>
		<td align="right">
			<button type="button" class="btn btn-info btn-sm"
				style="width: 100px;"
				onclick="location.href='main.jsp?go=smart/smartform.jsp'">글쓰기</button>
			
			<button type="button" class="btn btn-info btn-sm"
				style="width: 100px;"
				onclick="location.href='main.jsp?go=smart/smartlist.jsp?pageNum=<%=pageNum%>'">목록</button>
				
			<button type="button" class="btn btn-info btn-sm"
					style="width: 100px;"
					onclick="location.href='main.jsp?go=smart/updateform.jsp?num=<%=num%>&pageNum=<%=pageNum%>'">수정</button>

			<button type="button" class="btn btn-info btn-sm"
					style="width: 100px;"
					onclick="location.href='smart/delete.jsp?num=<%=num%>&pageNum=<%=pageNum%>'">삭제</button>

		</td>
	</tr>
</table>
</body>
</html>