<%@page import="data.dto.ZipcodeDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소입력</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>

<style type="text/css">
	div.addr ul li{
		list-style: none;
		cursor: pointer;
	}
</style>

</head>
<body>
<%
	String key=request.getParameter("key");
	if(key==null)
	{%>
		<div style="margin: 10px 30px;"> <!-- 방식은 겟방식으로 뿌려줄예정. url굳이 안써도되게. -->
			<form action="addrcheck.jsp">
			<b>검색할 동을 입력해주세요
				<span style="color:red;">예:별내 또는 별내동</span>
			</b>
			<br><br>
			<input type="text" name="dong" class="form-control input-sm"
				style="width: 200px; float: left;"
				required="required" autofocus="autofocus"
				placeholder="동입력">
				
			<!-- hidden / 키값을 뭐든 보내야 else로 가죠 -->
			<input type="hidden" name="key" value="yes">
			<button type="submit" class="btn btn-info btn-sm"
			style="margin-left: 10px; width: 80px;">검색</button>
			</form>
		</div>
	<%}else{
		//동을 읽어서 해당 동에 대한 데이타를 받은 후
		//ul li를 이용해서 출력
		String dong=request.getParameter("dong");
		MemberDao dao=new MemberDao();
		List<ZipcodeDto> list=dao.getSearchDong(dong);
		%>
		<div class="addr">
		<div class=alert alert-info"
			style="text-align: center; font-weight: bold;">
			<%=dong%>검색결과</div>
		<ul>
		<%
		for(ZipcodeDto dto:list)
		{
			String addr=dto.getSido()+" "+dto.getGugun()+" "+dto.getDong()
				+" "+(dto.getRi()!=null?dto.getRi():"")+" "+
					(dto.getBunji()!=null?dto.getBunji():"");
			
			//부모프레임으로 보내는 용도의 주소
			String addr2=dto.getSido()+" "+dto.getGugun()+" "+dto.getDong()
				+" "+(dto.getRi()!=null?dto.getRi():"");
			
				%>
				<li class="addr" addr="<%=addr2%>"><%=addr%></li>
				<!--addr클래스 제이쿼리 이벤트 줘서 데이터 주기 위해 클래스 선언해줌  -->

		<%}
		%>
		</ul>
		</div>
		<div style="text-align: center; margin-bottom: 10px;">
		<button type="button" class="btn btn-danger btn-sm"
 			onclick="location.href='addrcheck.jsp'">다시입력</button>
 		</div>
		
		<%}
%>

<script type="text/javascript">
	$("li.addr").click(function(){
		var addr=$(this).attr("addr");
		//alert(addr);
		opener.mfrm.addr.value=addr;
		opener.mfrm.addrdetail.focus();
		window.close();
	});
</script>


</body>
</html>
		
