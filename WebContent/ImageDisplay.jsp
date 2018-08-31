<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("img");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="initial-scale=1.0">
<style>
	* {
		margin : 0;
		padding : 0;
		background-color: transparent;
	}
	html, body {
		width : 100%;
		height : 100%;
	}
	p {
		display: flex;
		justify-content: center;
		align-items: center;
		width : 100%;
		height : 100%;
	}
	img {
		max-width : 100%;
		max-height: 100%;
	}
</style>
</head>
<body>
	<p><img alt="画像" src="./<%= name %>"></p>
</body>
</html>