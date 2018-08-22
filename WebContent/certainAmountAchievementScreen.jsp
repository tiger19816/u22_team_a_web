<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "hal.u22.works.team.a.achievement.list.screen.AchievementListScreenInfo"
     import="java.util.ArrayList"
    import= "hal.u22.works.team.a.web.entities.Page"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	ArrayList<AchievementListScreenInfo> arrayAchive= (ArrayList<AchievementListScreenInfo>)request.getAttribute("arrayAchive");
	Page p = (Page)request.getAttribute("PAGE");
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
	<table class="table table-striped" <%if(p.getMarginFlg()){ %>style="margin-bottom : <%=p.getMargin() %>px"<%} %>>	
			<thead>
				<tr>
					<th>タイトル</th>
					<th>場所</th>
					<th>投稿日付</th>
					<th>目標金額設定</th>
				</tr>
			</thead>
			<tbody>
			<%for(AchievementListScreenInfo achive : arrayAchive){%>
				<tr>
					<td><%=achive.getTitle() %></td>
					<td><%=achive.getPlace() %></td>
					<td><%=achive.getPostDate() %></td>
					<td><a href="./CertainAmountAchievementDetailScreenServlet?flagNum=1&no=<%=achive.getNo() %>">目標金額設定</a></td>
				</tr>	
			<%}%>
			</tbody>
		</table>
		<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
		<%if(p.getBackF()){%>
			<li class="page-item">
				<a class="page-link" href="./Index?id=<%=p.getNextPage()-1 %>" aria-label="前">
		       		<span aria-hidden="true">&laquo;</span>
		       		<span class="sr-only">前</span>
		    		</a> 
		    </li>
		<%} %>
			<%if(p.getMinF()){%><li class="page-item"><a class="page-link" href="./Index?id=1">1..</a></li><%} %>
			<li <%=(p.getOneFlg())%>><a class="page-link" href="./Index?id=<%=p.getOne() %>"><%=p.getOne() %></a></li>
			<%if(p.getPage() >= 2){%><li <%=(p.getTwoFlg())%>><a class="page-link" href="./Index?id=<%=p.getTwo() %>"><%=p.getTwo() %></a></li><%} %>
			<%if(p.getPage() >= 3){%><li <%=(p.getThreeFlg())%>><a class="page-link" href="./Index?id=<%=p.getThree() %>"><%=p.getThree() %></a></li><%} %>
			<%if(p.getPage() >= 4){%><li <%=(p.getFourFlg())%>><a class="page-link" href="./Index?id=<%=p.getFour() %>"><%=p.getFour() %></a></li><%} %>
			<%if(p.getPage() >= 5){%><li <%=(p.getFiveFlg())%>><a class="page-link" href="./Index?id=<%=p.getFive() %>"><%=p.getFive() %></a></li><%} %>
			<%if(p.getMaxF()){%><li class="page-item"><a class="page-link" href="./Index?id=<%=p.getPage() %>">..<%=p.getPage() %></a></li><%} %>
			<%if(p.getNextF()){%>
			<li class="page-item">
		      <a class="page-link" href="./Index?id=<%=p.getNextPage()+1 %>" aria-label="次">
		        <span aria-hidden="true">&raquo;</span>
		        <span class="sr-only">次</span>
		      </a>
		    </li>
		    <%} %>
		</ul>
	</nav>
		<div id ="backpage">
			<a href="javascript:history.back()">戻る</a>
		</div>
</div>
</body>
</html>