<%@page import="data.dao.MemberDao"%>
<%@page import="data.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<!-- member form은 include되는 거기때문에 위에 두개 링크 없어도 자동으로 부트스트랩 적용된다 -->

<style type="text/css">
	table.member{
		width: 500px;
		border: 2px solid gray;
		margin: 0 auto;
		margin-top: 100px;
	}

</style>
<script type="text/javascript">
	$(function(){
		$("#btnsubmit").click(function(){			
			if(mfrm.mid.value.length==0){
				alert("아이디 입력버튼을 눌러주세요");
				return false;//action 호출 안됨
			}
			if(mfrm.addr.value.length==0){
				alert("주소검색 버튼을 눌러주세요");
				return false;//action 호출 안됨
			}
		});
	});
</script>
</head>
<body>
<form action="member/addmember.jsp" method="post" 
	enctype="multipart/form-data" class="form-inline" name="mfrm"><!--가로방향으로 나오게 폼인라인 추가/ 폼이름으로부터 접근해서 name에 접근할거기 때문에 네임줍니다-->
	<table class="table table-bordered member" > <!--멤버클래스 추가-->
		<caption><b>가입</b></caption>
		<tr>
			<td bgcolor="#f0fff0" width="120">아이디</td>
			<td>
				<input type="text" class="form-control iput-sm"
					style="width: 120px; background-color: #eee;"
					readonly="readonly" name="mid" required="required"> <!--제이쿼리로 할일 있으면 id도 생성해야한다/ name 잘 적었는지 확인  -->
				<button type="button" class="btn btn-danger btn-sm"
					onclick="openId()">아이디 입력</button><!--호출은 자바스크립트 일반 사용자함수이기때문에 "openId()"이렇게만 넣어도 됩니다.  -->
			</td>
		</tr>
		<tr>
			<td bgcolor="#f0fff0" width="120">비밀번호</td>
			<td>
				<input type="password" class="form-control iput-sm"
					style="width: 120px;"
						name="pass" required="required"> <!--제이쿼리로 할일 있으면 id도 생성해야한다/ name 잘 적었는지 확인  -->
			</td>
		</tr>
		<tr>
			<td bgcolor="#f0fff0" width="120">이  름</td>
			<td>
				<input type="text" class="form-control iput-sm"
					style="width: 120px;"
						name="name" required="required"> <!--제이쿼리로 할일 있으면 id도 생성해야한다/ name 잘 적었는지 확인  -->
			</td>
		</tr>
		<tr>
			<td bgcolor="#f0fff0" width="120">사  진</td>
			<td>
				<input type="file" name="photo" class="form-control"
					style="width: 200px;"
					onchange="readImage(this)">
				<img alt="" src="image/03.png" width="60" border="1"
					id="showimg" title="기본이미지">
				<script type="text/javascript">
				//미리보기 기능추가
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
			<td bgcolor="#f0fff0" width="120">핸드폰</td>
			<td>
				<input type="text" class="form-control iput-sm"
					style="width: 200px;"
						name="hp" required="required"> <!--제이쿼리로 할일 있으면 id도 생성해야한다/ name 잘 적었는지 확인  -->
			</td>
		</tr>
		<tr>
			<td bgcolor="#f0fff0" width="120">주  소</td>
			<td>
				<input type="text" class="form-control iput-sm"
					style="width: 200px; background-color: #eee;"
						name="addr" required="required"
						readonly="readonly"> <!--제이쿼리로 할일 있으면 id도 생성해야한다/ name 잘 적었는지 확인  -->
				
				<button type="button" class="btn btn-success btn-sm"
					onclick="openAddr()">주소검색</button><!--호출은 자바스크립트 일반 사용자함수이기때문에 "openAddr()"이렇게만 넣어도 됩니다.  -->
				<br>
				<input type="text" name="addrdetail"
				class="form-control input-sm"
				style="width: 300px;" placeholder="동호수 또는 번지 입력">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<button type="submit" class="btn btn-info" 
			style="width: 150px;" id="btnsubmit">회원가입신청</button>
			</td>
		</tr>
	</table>
</form>


<script type="text/javascript">
	function openId() 
	{
		window.open("member/idcheck.jsp","",
				"left=100px, top=100px, width=500px, height=200px");
	}
	
	function openAddr() 
	{
		window.open("member/addrcheck.jsp","",
				"left=100px, top=100px, width=400px, height=400px");
	}

</script>
</body>
</html>