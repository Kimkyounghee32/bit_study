<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="data.dto.MemberDto"%>
<%@page import="data.dto.GuestDto"%>
<%@page import="data.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원명단</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
 	div.memberlist table{
 		width: 1000px;
 		border: 2px solid gray;
 	}
 	
 	figure.photo img{
 		width: 70px;
 		height: 70px;
 		border: 1px solid gray;
 	}
 		
</style>
</head>
<%
	MemberDao dao=new MemberDao();
	List<MemberDto> list=dao.getMemberList();
%>
<body>
<div class="memberlist">
	<b>총 <%=list.size()%> 명의 멤버가 있습니다.</b> 
	<!--total dao에 따로 선언안하고 list.size()로 총 회원수 출력가능. 대신 int 선언해주기 -->
	<br>
	<table class="table table-dordered">
		<caption><b>전체 회원 명단</b></caption>
		<tr bgcolor="#ccc">
			<th width="50">번호</th>
			<th width="100">아이디</th>
			<th width="100">회원명</th>
			<th width="150">핸드폰</th>
			<th width="300">주소</th>
			<th width="150">가입일</th>
			<th>관리</th>
		</tr>
		<%
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		int i=1;
		for(MemberDto dto:list)
		{%>
			<tr align="center">
				<td><%=i++%></td>
				<td><%=dto.getNum()%></td>
				<td>
					<figure class="photo">
						<img src="<%=dto.getPhoto()%>" class="img-circle">
						<figcaption><%=dto.getName()%></figcaption>
					</figure>
				</td>
				<td><%=dto.getHp() %></td>
				<td>
					<%=dto.getAddr()+" "+dto.getAddrdetail()%>
				</td>
				<td>
					<%=sdf.format(dto.getGaipday())%></td>
				<td>
					<%
					String loginok=(String)session.getAttribute("loginok");
					String mid=(String)session.getAttribute("mid");
					
					//로그인한 본인꺼만 나오도록
					if(loginok!=null && dto.getMid().equals(mid)){
						/*세션에 있는 mid와 dto에 있는 mid가 같을 경우  */
					%>
					<button type="button" class="btn btn-info btn-xs"
					onclick="location.href='member/memberupdateform.jsp?num=<%=dto.getNum()%>'">수정</button>

					<button type="button" class="btn btn-danger btn-xs"
					    onclick="fundel(<%=dto.getNum()%>)">삭제</button>
					<%}else {%>
						<h5>권한없음</h5>
					<%}%>
				</td>
			</tr>
		<%} 
		%>
	</table>
</div>
<script type="text/javascript">
	//삭제 버튼 이벤트
	function fundel(num){
		//	alert(num);
		$("#btnmdel").attr("num",num);
		$("#memberDelModal").modal();
	}
</script>

<!-- Modal -->
  <div class="modal fade" id="memberDelModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">회원탈퇴</h4>
        </div>
        <div class="modal-body">
          <p>회원 탈퇴를 원하면 아래 [탈퇴확인] 버튼을 눌러주세요</p>
          <button type="button" class="btn btn-danger" 
          style="width: 150px;" id="btnmdel" num="" 
          data-dismiss="modal">탈퇴확인</button>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>


<script type="text/javascript">
	$("#btnmdel").click(function () {
		//버튼에 있는 num 읽어오기
		var num=$(this).attr("num");
		//이동
		location.href="member/deletemember.jsp?num="+num;
	})
</script>

</body>
</html>