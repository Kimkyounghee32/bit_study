<%@page import="data.dto.MemberDto"%>
<%@page import="data.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>

<style type="text/css">
	table.member{
		width: 500px;
		border: 2px solid gray;
		margin:0 auto;
		margin-top: 100px;
	}	
</style>
<script type="text/javascript">
	$(function(){
		$("#btnsubmit").click(function(){
			
			if(mfrm.addr.value.length==0){
				alert("주소검색 버튼을 눌러주세요");
				return false;//action 호출 안됨
			}
		});
	});
</script>
</head>
<%
	//num 읽기
	String num=request.getParameter("num");
	//dao 에서 num 에 해당하는 dto 얻기
	MemberDao dao=new MemberDao();
	MemberDto dto=dao.getData(num);
%>
<body>
<form action="updateaction.jsp" method="post" 
	enctype="multipart/form-data"  class="form-inline" name="mfrm"	>
	<!-- hidden -->
	<input type="hidden" name="num" value="<%=num%>">
	
	<table class="table table-bordered member">
		<caption><b>회원 정보 수정</b></caption>
		<tr>
			<td bgcolor="##66cdaa" width="120">아이디</td>
			<td>
				<b><%=dto.getMid()%></b>
			</td>
		</tr>
		
		<tr>
			<td bgcolor="##66cdaa" width="120">이 름</td>
			<td>
				<input type="text" class="form-control input-sm"
					style="width: 120px;"
					 name="name" required="required"
					 value="<%=dto.getName()%>">				
			</td>
		</tr>
		<tr>
			<td bgcolor="##66cdaa" width="120">사 진</td>
			<td>
				<input type="file" name="photo" class="form-control"
					style="width: 200px;"
					onchange="readImage(this)">
				<img src="../<%=dto.getPhoto()%>" width="60" border="1"
					id="showimg" title="기본이미지"> 	
				<script type="text/javascript">
				//미리보기 기능 추가
				function readImage(tag)
				{
					if(tag.files[0]){
						var reader=new FileReader();
						reader.onload=function(e){
							$("#showimg").attr("src",e.target.result);
						}
						reader.readAsDataURL(tag.files[0]);
					}
				}
				</script>			
			</td>
		</tr>
		<tr>
			<td bgcolor="##66cdaa" width="120">핸드폰</td>
			<td>
				<input type="text" class="form-control input-sm"
					style="width: 200px;"
					 name="hp" required="required"
					 value="<%=dto.getHp()%>">				
			</td>
		</tr>
		<tr>
			<td bgcolor="##66cdaa" width="120">주 소</td>
			<td>
				<input type="text" class="form-control input-sm"
					style="width: 250px;background-color: #eee;"
					 name="addr" required="required"
					 readonly="readonly"
					 value="<%=dto.getAddr()%>">
			
				<button type="button" class="btn btn-success btn-sm"
					onclick="openAddr()">주소검색</button>	
				<br>
				<input type="text" name="addrdetail" 
				class="form-control input-sm"
				style="width: 300px;" placeholder="동호수 또는 번지 입력"
				value="<%=dto.getAddrdetail()%>">			
			</td>
		</tr>
		<tr>
			<td  colspan="2" align="center">
				<button type="submit" class="btn btn-info"
				 style="width: 150px;" id="btnsubmit">회원정보수정</button>
			</td>
		</tr>
	</table>
</form>

<script type="text/javascript">
  
  function openAddr()
  {
	  window.open("addrcheck.jsp","",
			  "left=100px,top=100px,width=400px,height=400px");
  }
</script>
</body>
</html>
