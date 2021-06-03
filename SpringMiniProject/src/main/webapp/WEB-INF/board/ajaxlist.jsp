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
	img.photo{
		width: 210px;
		height: 220px;
		margin-left: 10px;
		border: 2px solid gray;
		border-radius: 10px;
		box-shadow:  3px 3px 3px gray;
		cursor: pointer;
		
	}
	
	span.day{
		color:gray;
		font-size: 0.8em;
	
	}
	
	div.list2 {
	 
	 width: 800px;
	 margin-top: 10px;
	 border : 1px solid gray;
	 cursor: pointer;
	}
	
	
	div.list2 pre{
	 
	 border: none;
	 background-color: white;
	 color: blue;
	 font-weight: bold;
	}
	
	div.detail{
		position: absolute;
		left: 1000px;
		top: 100px;
	}
	
	img.detailphoto{
		max-width: 200px;
		margin-top: 10px;		
	}

	
</style>
<script type="text/javascript">
$(function(){
	   list1();
	   $("#list1").click(function(){
	      list1();
	   });

		
	   $("#list2").click(function() {
		   $("#list2").css("color","red");
		   $("#list1").css("color","black");
		   $.ajax({
			   type: "get",
			   url:"../ajax/list2",
			   dataType: "json",
			   success: function(data) {  //dto 데이터가 들어옴
				   var s="<b>"+data.length+"개의 자료가 있습니다</b><br>";
				   $.each(data,function(i,a){
						var photo=a.uploadname.split(",");
						console.dir(photo);
						s+="<div class='list2'>"
						s+="<span class='title'>제목:"+a.subject+"</span><br>";
						s+="<span class='writer'>작성자:"+a.writer+"</span><br>";
						s+="<span class='writeday'>작성일:"+a.writeday+"</span><br>";
						s+="<span class='content'><pre>"+a.content+"</pre></span><br>";
						s+="</div>";
				   });
				   $("#showboard").html(s);
				
				}
		   });   
	   });
});
	  

function list1() 
{
	$("#list1").css("color","red");
	$("#list2").css("color","black");
	
	$.ajax({
		type: "get",
		url: "../ajax/list1",
		dataType: "json",
		success:function(data){
			var s="<b>"+data.length+"개의 자료가 있습니다<b><br>";
			s+="<table class='photob'>";
			s+="<tr>";
			$.each(data,function(i,a){
				var photo=a.uploadname.split(",");
				console.dir(photo);
				s+="<td align='center'>";
				s+="<img class='photo' src='../image/"+photo[0]+"' num="+a.num+"><br>";
				s+="제목:"+a.subject+"(사진 총"+photo.length+"개)<br>";
				s+="작성자:"+a.writer+"<br>";
				s+="<span class='day'>작성일:"+a.writeday+"</span><br><br>"
				s+="</td>";
				
				if((i+1)%3==0)
					s+="</tr><tr>";
			});
			s+="</table>"
			$("#showboard").html(s);

		}
	});
}

	//사진에 마우스 올렸을때 이벤트
	$(document).on("mouseover","img.photo",function(){		
		var num=$(this).attr("num");
		$.ajax({
			type:"get",
			url:"../ajax/detail",
			dataType:"json",
			data:{"num":num},
			success:function(data){
				var s="제목:"+data.subject+"<br>";
				s+="<pre>"+data.content+"</pre>";
				var photo=data.uploadname.split(",");
				$.each(photo,function(i,p){
					s+="<img src='../image/"+p+"' class='detailphoto'><br>";
				});
				
				$("div.detail").html(s).show('fast');
				
			}
		});
	});
	$(document).on("mouseout","img.photo",function(){
		$("div.detail").html("").hide();	
	});


</script>
</head>
<body>
<div class="alert alert-info" style="font-size: 20px; font-weight: bold; width: 1200px;">
Ajax로 Board목록 출력하기
	<span class="glyphicon glyphicon-th-large" id="list1"
	style="margin-left: 700px; cursor: pointer;"></span>
	
	<span class="glyphicon glyphicon-th-list" id="list2"
	style="margin-left: 3px; cursor: pointer;"></span>
</div>

<div id="showboard"></div>
<div class="detail"></div>

</body>
</html>