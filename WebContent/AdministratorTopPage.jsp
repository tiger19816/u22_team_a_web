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
<style>
.row-eq-height {
	display: -webkit-flex; /* Safari */
	display: flex;
	flex-wrap: wrap;
	align-items: center;
}

.null {
	height: 40px;
}
</style>
<!--Bootstrap４に必要なCSSとJavaScriptを読み込み-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<div id ="userName">
		<p><%=name %></p>
	</div>
	
	<div id="logout">
		<a href ="./AdministratorLogOutServlet">ログアウト</a>
	</div>
	<a href="./CertainAmountAchievementListScreenServlet?flagNum=1">一定額達成リスト</a>
	<a href="./CertainAmountAchievementListScreenServlet?flagNum=3">目標額達成リスト</a>
</div>
</body>
</html>