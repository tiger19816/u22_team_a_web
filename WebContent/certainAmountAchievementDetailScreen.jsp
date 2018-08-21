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
</head>
<body>
<form action ="./CertainAmountAchievementDetailScreenInsertServlet" method="post">
	<table>
		<tr><th> タイトル</th><td><%=achivement.getTitle() %></td></tr>
		<tr><th>場所</th><td><%=achivement.getPlace() %></td></tr>
		<tr><th>投稿日</th><td><%=achivement.getPostDate() %></td></tr>
		<tr><th>内容</th><td><%=achivement.getContent() %></td></tr>
		<tr><th>写真</th><td><%=achivement.getPhoto() %></td></tr>
		<tr><th>集計金額</th><td><%=achivement.getPostMoney() %></td></tr>
		<tr><th>目標金額の設定</th><td><input type="text" name="money"></td></tr>
	</table>
	<input type="hidden" name="flagNum" value="1" >
	<input type="hidden" name="no" value="<%= achivement.getNo() %>">
	<input type="submit" value="目標金額の登録">
</form>

<div id ="backpage">
	<a href="javascript:history.back()">戻る</a>
</div>
</body>
</html>