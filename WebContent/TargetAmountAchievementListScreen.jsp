<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "hal.u22.works.team.a.achievement.list.screen.AchievementListScreenInfo"
    import="java.util.ArrayList"
    import= "hal.u22.works.team.a.web.entities.Page"
    %>
<!DOCTYPE html>
<%
	ArrayList<AchievementListScreenInfo> arrayAchive= (ArrayList<AchievementListScreenInfo>)request.getAttribute("arrayAchive");
	Page p = (Page)request.getAttribute("PAGE");
%>
<html lang="ja">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
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
	<table class="table table-striped" <%if(p.getMarginFlg()){ %>style="margin-bottom : <%=p.getMargin() %>px"<%} %>>
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
				<td><a href="./CertainAmountAchievementDetailScreenServlet?flagNum=3&no=<%=achive.getNo() %>&flagNum=1">確認</a></td>
			</tr>	
		<%}%>
		</tbody>
	</table>
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
		<%if(p.getBackF()){%>
			<li class="page-item">
				<a class="page-link" href="./CertainAmountAchievementListScreenServlet?id=<%=p.getNextPage()-1 %>&flagNum=1" aria-label="前">
		       		<span aria-hidden="true">&laquo;</span>
		       		<span class="sr-only">前</span>
		    		</a> 
		    </li>
		<%} %>
			<%if(p.getMinF()){%><li class="page-item"><a class="page-link" href="./CertainAmountAchievementListScreenServlet?id=1&flagNum=1">1..</a></li><%} %>
			<li <%=(p.getOneFlg())%>><a class="page-link" href="./CertainAmountAchievementListScreenServlet?id=<%=p.getOne() %>&flagNum=1"><%=p.getOne() %></a></li>
			<%if(p.getPage() >= 2){%><li <%=(p.getTwoFlg())%>><a class="page-link" href="./CertainAmountAchievementListScreenServlet?id=<%=p.getTwo() %>&flagNum=1"><%=p.getTwo() %></a></li><%} %>
			<%if(p.getPage() >= 3){%><li <%=(p.getThreeFlg())%>><a class="page-link" href="./CertainAmountAchievementListScreenServlet?id=<%=p.getThree() %>&flagNum=1"><%=p.getThree() %></a></li><%} %>
			<%if(p.getPage() >= 4){%><li <%=(p.getFourFlg())%>><a class="page-link" href="./CertainAmountAchievementListScreenServlet?id=<%=p.getFour() %>&flagNum=1"><%=p.getFour() %></a></li><%} %>
			<%if(p.getPage() >= 5){%><li <%=(p.getFiveFlg())%>><a class="page-link" href="./CertainAmountAchievementListScreenServlet?id=<%=p.getFive() %>&flagNum=1"><%=p.getFive() %></a></li><%} %>
			<%if(p.getMaxF()){%><li class="page-item"><a class="page-link" href="./CertainAmountAchievementListScreenServlet?id=<%=p.getPage() %>&flagNum=1">..<%=p.getPage() %></a></li><%} %>
			<%if(p.getNextF()){%>
			<li class="page-item">
		      <a class="page-link" href="./CertainAmountAchievementListScreenServlet?id=<%=p.getNextPage()+1 %>&flagNum=1" aria-label="次">
		        <span aria-hidden="true">&raquo;</span>
		        <span class="sr-only">次</span>
		      </a>
		    </li>
		    <%} %>
		</ul>
	</nav>
	
	<div id ="backpage">
		<a href="./AdministratorTopServlet">戻る</a>
	</div>
	
</div>
</body>
</html>