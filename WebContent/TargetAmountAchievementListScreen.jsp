<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "hal.u22.works.team.a.achievement.list.screen.AchievementListScreenInfo"
    import="java.util.ArrayList"
    %>
<!DOCTYPE html>
<%
	ArrayList<AchievementListScreenInfo> arrayAchive= (ArrayList<AchievementListScreenInfo>)request.getAttribute("arrayAchive");
%>
<html lang="ja">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>Insert title here</title>

</head>
<body>

<div class="container">
	<table>

		<thead>
			<tr>
				<th>タイトル</th>
				<th>場所</th>
				<th>投稿日付</th>
				<th>詳細</th>
			</tr>
		</thead>

		<tbody>
		<%for(AchievementListScreenInfo achive : arrayAchive){%>
			<tr>
				<td><%=achive.getTitle() %></td>
				<td><%=achive.getPlace() %></td>
				<td><%=achive.getPostDate() %></td>
				<td><a href="./CertainAmountAchievementDetailScreenServlet?flagNum=3&no=<%=achive.getNo() %>">確認</a></td>
			</tr>	
		<%}%>
		</tbody>

	</table>
	
	<div id ="backpage">
		<a href="javascript:history.back()">[戻る]</a>
	</div>
</div>
</body>
</html>