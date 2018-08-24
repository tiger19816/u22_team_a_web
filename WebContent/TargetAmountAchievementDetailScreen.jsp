<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
   import = "hal.u22.works.team.a.achievement.list.screen.AchievementListScreenInfo"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	AchievementListScreenInfo achivement =(AchievementListScreenInfo)request.getAttribute("achive");	
	
%>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<form action ="./CertainAmountAchievementDetailScreenInsertServlet" method="post">
	<table class="table table-striped">
		<tr><th> タイトル</th><td><%=achivement.getTitle() %></td></tr>
		<tr><th>場所</th><td><%=achivement.getPlace() %></td></tr>
		<tr><th>投稿日</th><td><%=achivement.getPostDate() %></td></tr>
		<tr><th>内容</th><td><%=achivement.getContent() %></td></tr>
		<tr><th>写真</th><td><%=achivement.getPhoto() %></td></tr>
		<tr><th>集計金額</th><td><%=achivement.getPostMoney() %></td></tr>
		<tr><th>目標金額</th><td><%=achivement.getTargetMoney() %>
		<tr><th>掃除の依頼</th><td><input type="submit" class="btn btn-primary" value="依頼する"></td></tr>
	</table>
	<input type="hidden" name="flagNum" value="3" >
	<input type="hidden" name="no" value="<%= achivement.getNo() %>">
<div id ="backpage">
	<a href="javascript:history.back()">戻る</a>
</div>	
</form>

</div>
</body>
</html>