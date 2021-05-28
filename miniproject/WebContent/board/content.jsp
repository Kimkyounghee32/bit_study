<%@page import="data.dao.MemberDao"%>
<%@page import="java.io.File"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.BoardDto"%>
<%@page import="data.dao.BoardDao"%>
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
	img.myphoto{
		width: 80px;
		height: 80px;
		border: 1px solid gray;
		border-radius: 100px;
	}
	
	span.day{
		float: right;
		color: silver;
		line-height: 90px;/* border 내 글자 위치 중간줄로 */
	}
	
	button.btncontent {
		width: 100px;
	}
	
	div.alist{
		margin-left: 100px;
		margin-top: 10px;
		width: 600px;
	}
	
	span.aday{
		float: right;
		color: orange;
		font-size: 9pt;
	}
	
	span.adel{
		color:red;
		margin-left: 3px;
		cursor: pointer;
	}
	
	span.amod{
		color: blue;
		margin-left: 10px;
		cursor: pointer;
	}

</style>
<%
	//로그아웃시에도 아이디가 세션에 있기 때문에 게시글에서 수정삭제가 보인다.
	//로그인한 상태인지 확인
	String loginok=(String)session.getAttribute("loginok");

%>
<script type="text/javascript">

	//댓글 출력하는 함수
	function list()
	{
		
		$("#add").show();
		$("#up").hide();
		var num=$("#num").val();
		$.ajax({
			type:"get", //post : 웹브라우저에서 웹서버에 데이타를 전달(전달되는 데이터가 보이지 않는다)
			dataType:"xml", //dataType : 서버가 리턴하는 데이터 타입 (xml, json, script, html)
			url:"board/answerlist.jsp", //url : 데이터를 전송할 URL
			data:{"num":num}, //data : 서버에 전송할 데이터, key/value 형식의 객체
			success:function(data){ //success : ajax통신에 성공했을 때 호출될 이벤트 핸들러
				var su=$(data).find("answer").length;
				$("span.su").text(su);
				
				var s="";
				$(data).find("answer").each(function (i,element) {
					var n=$(this);
					var idx=n.attr("idx");
					var myid=n.find("myid").text();
					var content=n.find("content").text();
					var name=n.find("name").text();
					var writeday=n.find("writeday").text();
					
					s+=name+"("+myid+"):"+content+"<span class='aday'>";
					s+=writeday;
					var login="<%=loginok%>";
					console.log(login);
					//댓글도 로그인 상태에만 본인이 쓴 댓글에 한해서
					//수정 삭제 아이콘이 보이도록 한다
					
					//로그인한 아이디 얻기
					var logid=$("#myid").val();//로그아이디는 인풋타입이니까 val()추가
					console.log(logid);
					
					if(login=='yes'&& logid==myid){ //로그인한아이디가 글쓴사람아이디와 같으면
							s+="<span class='amod glyphicon glyphicon-pencil' idx="+idx+"></span>";
							s+="<span class='adel glyphicon glyphicon-remove' idx="+idx+"></span>";
					}
					s+="</span><br>"
					$("div.alist").html(s);
				})
			}
		})
	}
			 
	
	
	$(function(){
		list(); //처음 시작시 댓글 일단 출력
		
		var a;
		
		//댓글 추가 이벤트
		$("#btnadd").click(function(){
			var num=$("#num").val();
			var myid=$("#myid").val();
			var acontent=$("#acontent").val();
			if(acontent.length==0){
				alert("댓글 내용을 입력 후 확인을 눌러주세요");
				return;
			}
			
			$.ajax({
				type:"post", //post : 웹브라우저에서 웹서버에 데이타를 전달(전달되는 데이터가 보이지 않는다)
				dataType:"html", //dataType : 서버가 리턴하는 데이터 타입 (xml, json, script, html)
				url:"board/insertanswer.jsp", //url : 데이터를 전송할 URL
				data:{"num":num,"myid":myid,"content":acontent}, //data : 서버에 전송할 데이터, key/value 형식의 객체
				success:function(d){ //success : ajax통신에 성공했을 때 호출될 이벤트 핸들러
					//목록 다시 출력 
					list();
					//입력값 지우기
					$("#acontent").val("");
				}
				
			})
		})
		
		$(document).on("click","span.adel", function() {
			var idx=$(this).attr("idx");
			//alert(idx);
			 $.ajax({
				type:"get",
				dataType: "html",
				url:"board/answerdelete.jsp",
				data:{"idx":idx},
				success:function(d){
					//현재페이지 새로고침
					location.reload();
					
				}
			})
		})
		
		
		$(document).on("click", "span.amod",function(){
			//수정할 idx의 속성에서 가져오기
			$("#add").hide();
			$("#up").show();
			var idx=$(this).attr("idx");
			a=idx;
			$.ajax({
				type:"get",
				url:"board/answergetdata.jsp",
				dataType:"xml",
				data:{"idx":idx},
				success:function(data){
					var content=$(data).find("content").text();
					//수정폼태그안에 넣어준다
					$("#ucontent").val(content);
			}
		}); 
	});
				
		$(document).on("click", "#btnu", function(){
			var data=$("#ucontent").val();
			var idx=a;
			//console.log(data);
			$.ajax({
				type:"post",
				dataType:"html",
				url:"board/answerupdateaction.jsp",
				data:{"content":data,"idx":idx},
				success:function(data){
					list();
				}
			});		
		});
	})

</script>
</head>
<body>
<%
	//key,num,pageNum
	String key=request.getParameter("key");
	String num=request.getParameter("num");
	String pageNum=request.getParameter("pageNum");
	
	BoardDao dao=new BoardDao();
	//목록에서 클릭시에만 조회수 증가
	if(key!=null)
		dao.updateReadcount(num);
	
	//dto
	BoardDto dto=dao.getData(num);
	
	//날짜타입
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	
	//이미지출력을 하는데 개인톰켓서버로 올린건 다른사람이 볼수 없으므로
	//해당이미지가 없을 경우 임시 이미지 출력하기
	String realPath=getServletContext().getRealPath("/");
	System.out.println(realPath);
	//사진경로 얻어오기
	MemberDao mdao=new MemberDao();
	String myPhoto=mdao.getPhoto(dto.getMyid());//id를 보내면 그 아이디에 해당하는 photo가 넘어온다
	System.out.println(myPhoto);
	File photo=new File(realPath+"\\"+myPhoto); //합치면 실제경로가됨
	
	//작성자 이름 얻어오기
	String name=mdao.getName(dto.getMyid());


%>

<table class="table table-bordered" style="width: 600px; margin-left: 100px">
	<caption><b>게시글 확인</b></caption>
	<tr>
		<td>
		<%
		//서버에 해당 이미지가 있는 경우 그 이미지를 뿌려주고 이름이랑 아이디도 뿌려줌
		if(photo.exists()){
			%>
			<img src="<%=myPhoto%>" class="myphoto">
		<%}else{
		//서버에 파일 객체가 존재하지 않을 경우 다른이미지로 대체
			
		%>
			<img src="image/18.png" class="myphoto">
		<%}
		%>
		  <b><%=name%>(<%=dto.getMyid()%>)</b> 
		  <!-- //이름이랑 아이디 db는 같은곳에 저장되어있으므로 하단에서 같이 뿌려줌-->
		  <span class="day">
		  	<%=sdf.format(dto.getWriteday())%>
		  </span>
		  
		</td>
	</tr>
	<tr height="100" valign="top">
		<td>
		<h2 style="color:green;"><%=dto.getSubject()%></h2>
		<%
		if(dto.getContent()==null){%>
			<h3>내용없음</h3>
		<%}else{%>
			<%=dto.getContent().replace("\n","<br>")%>
		<%}
		%>
		<br><br>
		<b>조회&nbsp;<%=dto.getReadcount()%></b>
		<b style="margin-left: 10px;">댓글<span class="su">0</span></b>
		</td>
	</tr>
	<tr>
		<td align="right">
			<button type="button" class="btncontent btn btn-info btn-sm"
			onclick="location.href='main.jsp?go=board/writeform.jsp'">글쓰기</button>
			<!--onclick 일때는 location.href 넣어줘야함 -->
			<%
				//널이아니면 읽어들여야하는것들 다 써주자
				String reple="main.jsp?go=board/writeform.jsp?num="
					+dto.getNum()+"&reg="+dto.getReg()+"&restep="+
					dto.getRestep()+"&relevel="+dto.getRelevel()
					+"&pageNum="+pageNum;
			%>
			<button type="button" class="btncontent btn btn-info btn-sm"
			onclick="location.href='<%=reple%>'">답글쓰기</button>
			
			
			<button type="button" class="btncontent btn btn-info btn-sm"
			onclick="location.href='main.jsp?go=board/boardlist.jsp?pageNum=<%=pageNum%>'">목록</button>
			
			
			<%
				String mod="main.jsp?go=board/boardupdateform.jsp?num="
					+dto.getNum()+"&pageNum="+pageNum;
				String del="board/boarddelete.jsp?num="
					+dto.getNum()+"&pageNum="+pageNum; 
				//delete는 경로에서 메인을 통할 필요가 없음. 보여줄게 없기 때문에->바로 삭제할 예정.
			%>
			
			<%
				//세션에서 로그인한 아이디를 얻는다
				String myid=(String)session.getAttribute("mid");
				
				//로그인한 아이디와 dto의 아이디가 같을 경우 수정, 삭제 버튼이 보이도록한다
				//널이 있을때(로그인안했을때) 이퀄쓰면 nullpointexception 나오므로 조건추가(myid!=null)
				if(myid!=null && loginok!=null && myid.equals(dto.getMyid()))
				{
					
			%>
			
			<button type="button" class="btncontent btn btn-info btn-sm"
			onclick="location.href='<%=mod%>'" idx="">수정</button>
			
			<button type="button" class="btncontent btn btn-info btn-sm"
			id="boarddel" num="" onclick="location.href='<%=del%>'">삭제</button>	

			<%} %>
		</td>
	</tr>
</table>
<script type="text/javascript">
	//삭제버튼이벤트
	$("#boarddel").click(function () {
		var num=$(this).attr("num");
		alert(num);
		$.ajax({
			type:"get",
			dataType: "html",
			url:"board/boarddelete.jsp",
			data:{"num":num},
			success:function(d){
				
			}
		})
		
	})
</script>

		<input type="hidden" name="myid" id="myid" value="<%=myid%>">
		<input type="hidden" name="num" id="num" value="<%=num%>">
<%
	//댓글 입력창은 로그인한 상태에서만 보이도록한다(입력창만! 댓글 목록은 로그아웃상태에서도 보임)
	if(loginok!=null)
	{%>
		<div style="width:600px; margin-left: 100px;" class="form-inline">
			
			<div id="add">
			<input type="text" class="form-control" style="width: 500px;"
				id="acontent" placeholder="댓글을 입력해주세요">
			<button type="button" class="btn btn-warning btn-sm"
			id="btnadd">확인</button>
			</div>
			<div id="up">
			<input type="text" class="form-control" style="width: 500px;"
				id="ucontent" placeholder="수정할 댓글을 입력해주세요">
			<button type="button" class="btn btn-warning btn-sm"
			id="btnu">수정</button>
			</div>
				
		</div>
	<%}
%>
<div class="alist"></div>

</body>
</html>