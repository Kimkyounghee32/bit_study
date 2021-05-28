<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.GuestDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
	span.fileadd,span.filedel{
		cursor: pointer;
		color: #2e8b57;
		font-size: 15pt;
	}
	
	table.glist{
		width: 500px;
		border: 2px solid gray;
		margin-bottom: 10px;		
	}
	
	table.glist span.day{
		float: right;
		color: #666;
		font-size: 0.8em;
	}
	
	span.photo img.photo{
		width: 70px;
		height: 70px;
		border: 2px solid green;
		border-radius:10px; 
		cursor: pointer;
		margin-right: 10px;
		margin-top: 10px;
	}
	
	span.next{float: right;}
	
	span.glyphicon-heart{
		color: red;
	}
	
	span.glyphicon-heart-empty{
		color: black;
	}
	
</style>
<script type="text/javascript">
	var idx=2;
	$(function(){
		$("span.fileadd").click(function(){
			if($("input.photo").length==5){
				alert("더는 추가할수 없습니다");
				return;
			}
			var tag='<br><input type="file" name="photo'+(idx++)
				+'" class="form-control photo">';
			$("span.filedel").after(tag);
		});
		$("span.filedel").click(function(){
			if($("input.photo").length==1){
				alert("더는 삭제할수 없습니다");
				return;
			}						
			$("input.photo").last().remove();			
		});
		
		//작은 이미지 클릭시 모달 다이얼로그 띄우기
		$("span.photo img.photo").click(function(){
			//클릭한 이미지의 이름 얻기
			var imgname=$(this).attr("src");
			//다이얼로그의 헤더에 넣어주기
			$("h4.imgname").text(imgname);
			$("div.modal-body img").attr("src",imgname);
			$("#myModal").modal();
		});
		
		//좋아요 이벤트
		$("span.heart").click(function(){
			var a=$(this).attr("class");
			var num=$(this).attr("num");
			
			if(a=='glyphicon glyphicon-heart heart')
				$(this).attr("class","glyphicon glyphicon-heart-empty heart");
			else
				$(this).attr("class","glyphicon glyphicon-heart heart");
			
			$.ajax({
				type:"get",
				dataType:"html",
				data:{"num":num},
				url:"guest/updatelikes.jsp",
				success:function(){
					//성공시 처리할 내용 없음
				}
			});
		});
	});
</script>
</head>
<body>
<form action="guest/addguest.jsp" method="post" enctype="multipart/form-data" class="form-inline">
	<table class="table table-bordered" style="width: 500px;border: 2px solid gray;">
		<tr>
			<td width="100" bgcolor="#ddd">작성자</td>
			<td>
				<input type="text" class="form-control input-sm"
				 style="width: 140px;" name="writer" required="required">
			</td>
		</tr>
		<tr>
			<td width="100" bgcolor="#ddd">사 진</td>
			<td>
				<input type="file" name="photo1" class="form-control photo">
				<span class="glyphicon glyphicon-plus-sign fileadd"></span>
				<span class="glyphicon glyphicon-minus-sign filedel"></span>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea name="content" class="form-control"
					style="width: 480px;height: 60px;"
					required="required"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-info"
				style="width: 130px;">방명록저장</button>
			</td>
		</tr>		
	</table>
</form>
<hr align="left" style="background-color: pink;width: 600px;height: 10px;">
<%
	GuestDao dao=new GuestDao();
	int total=dao.getTotalCount();
%>
<b>총 <%=total%> 개의 방명록 글이 있습니다</b>
<%
	//가져올 데이타의 시작번지 구하기
	int start=1;
	//페이지번호는 목록호출시 start=5 이런식으로 보내보자
	if(request.getParameter("start")!=null)
		start=Integer.parseInt(request.getParameter("start"));
	%>
	<!-- 페이징 -->
	<div style="width: 500px;">
		<span class="pre">
		<%
		if(start>1){
			String go="main.jsp?go=guest/guestlist.jsp?start="+(start-4);
			%>
			<button type="button" class="btn btn-success btn-sm"
			style="width: 100px;"
			onclick="location.href='<%=go%>'">이전페이지</button>
		<%}
		%>	
		</span>
		<span class="next">
		<%
		if((start+3)<total){
			String go="main.jsp?go=guest/guestlist.jsp?start="+(start+4);
			%>
			<button type="button" class="btn btn-success btn-sm"
			style="width: 100px;"
			onclick="location.href='<%=go%>'">다음페이지</button>
		<%}
		%>	
		</span>
	</div>	
	<%//해당 페이지에서 보여줄 목록(4개씩) 가져오기
	List<GuestDto> list=dao.getList(start);
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	for(GuestDto dto:list)
	{%>
		<table class="table table-striped glist">
			<tr>
				<td>
					<span class="writer"><b><%=dto.getWriter()%></b></span>
					<span class="day"><%=sdf.format(dto.getWriteday())%></span>
				</td>				
			</tr>
			<tr>
				<td>
					<!-- db 에 저장시 br 태그가 \n으로 저장됨.
					그래서 줄넘김을 하려면 pre태그에 출력하거나
					\n 을 다시 br 태그로 변경해서 출력하면 됨 -->
					<span class="content">
						<%=dto.getContent().replace("\n", "<br>") %>
					</span>
					<%
					//사진이 있는 경우에만 실행되는 부분
					if(!dto.getPhoto().equals("no"))
					{
						//,로 분리하기
						String []photo=dto.getPhoto().split(",");
					%>
						<br>
						<span class="photo">
						 <%
						 for(String myphoto:photo)
						 {%>
							<img src="save/<%=myphoto%>" class="photo"> 
						 <%}
						 %>
						</span>
					<%}
					%>					
				</td>
			</tr>
			<tr>
				<td>
					<span class="likes">
					<%
					 if(dto.getLikes()==1){%>
						<span class="glyphicon glyphicon-heart heart" 
							style="font-size: 1.3em;cursor: pointer;" 
							num="<%=dto.getNum()%>"></span>
					 <%}else{%>
					 	<span class="glyphicon glyphicon-heart-empty heart"
					 		style="font-size: 1.3em;cursor: pointer;" 
					 		num="<%=dto.getNum()%>"></span>						 
					 <%}
					%>
					</span>

					
					<span class="update" style="float: right;"> <!--컬러스타일은 여기서 안바뀜니다 아래 a태그에 줄게여  -->
						<%
						String mod="main.jsp?go=guest/updateform.jsp?num="
							+dto.getNum()+"&start="+start;
						%>
						<a href="<%=mod%>" style="color:black;">수정</a>
						<a href=""  style="color: black;"
						num="<%=dto.getNum()%>"
						class="del">삭제</a>
					</span>
				</td>
			</tr>		
		</table>		
	<%}
%>

 <!-- Modal:사진 클릭시 다이얼로그 형태로 보이게 하기 위한 코드 -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title imgname">Modal Header</h4>
        </div>
        <div class="modal-body">
          <img src="" style="max-width: 400px;">
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
  
   <!-- Modal:삭제 하기 위한 다이얼로그 코드 -->
  <div class="modal modal-sm fade" id="myDelModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">방명록글삭제</h4>
        </div>
        <div class="modal-body">
          <img src="image/ani12.gif" width="70" align="left">
          <button type="button" class="btn btn-danger btn-sm"
          	id="guestdel" num=""
          	data-dismiss="modal">삭제확인</button>
          	
         <button type="button" class="btn btn-default"
          data-dismiss="modal">삭제취소</button>          
        </div> 
       <div class="modal-footer">          
        </div>
       
      </div>
      
    </div>
  </div>

  
 
  <script type="text/javascript">
  	//삭제 모달 띄우기
  	$("span.update a.del").click(function(e) {
  	/// <!-- span.update a.del 스판의 업데이트 밑에 있는 a태그의 del -->
  		//기본 a태그의 이벤트 무효화
  		e.preventDefault();
  		//num 읽기
		var num=$(this).attr("num");
  		$("#guestdel").attr("num",num);
  		
  		$("#myDelModal").modal();
	})
	
	//삭제확인 버튼
	$("#guestdel").click(function () {
		//해당 버튼에서 num 읽기
		var num=$(this).attr("num");
		//alert(num);
		$.ajax({
			type:"get",
			dataType: "html",
			url:"guest/deleteguest.jsp",
			data:{"num":num},
			success:function(d){
				//현재페이지 새로고침
				location.reload();
				
			}
		})
		
	})
  
  
  </script>
 

 
  
</body>
</html>

