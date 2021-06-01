<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic&family=Noto+Sans+KR:wght@300&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<style type="text/css">
	div.layout{
		border: 0px solid gray;
		font-family: 'Do Hyeon';
	}
	
	div.title{
		font-size: 30pt;
		text-align:  center;
	}
		
	div.menu{
		font-size: 25pt;
		text-align: center;
		font-weight: bold;
	}
	
	/* 레이아웃 밑에 있는 모든것들. 블랙으로되게 */
	div.layout a {
		color: black;
		text-decoration: none;
	}
	
	div.info{
		position: absolute;
		left: 30px;
		top: 200px;
		width: 140px;
		height: 230px;
		border: 2px solid gray;
		border-radius: 30px;
		text-align: center;
		font-size: 14pt;
		padding: 20px 20kpx;
	}
	
	div.main{
		position: absolute;
		left: 300px;
		top: 160px;
		width: 1000px;
		height: 700px;
		font-size: 15pt;
	}
		
		
</style>
</head>
<body>
<div class="layout title">
	<tiles:insertAttribute name="title"/>
</div>
<div class="layout menu">
	<tiles:insertAttribute name="menu"/>
</div>
<div class="layout info">
	<tiles:insertAttribute name="info"/>
</div>
<div class="layout main">
	<tiles:insertAttribute name="main"/>
</div>
</body>
</html>