<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<%
	
	String name = (String)request.getAttribute("userName");

%>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div id ="userName">
		<p><%=name %></p>
	</div>
	
	<div id="logout">
		<a href ="./AdministratorLogOutServlet">ログアウト</a>
	</div>
	<a href="./CertainAmountAchievementListScreenServlet?flagNum=1">一定額達成リスト</a>
	<a href="./CertainAmountAchievementListScreenServlet?flagNum=3">目標額達成リスト</a>
	
	
</body>
</html>