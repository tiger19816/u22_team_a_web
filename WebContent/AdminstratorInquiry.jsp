<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "hal.u22.works.team.a.administrator.AdminstratorInquiryInfo"
    import="java.util.ArrayList"
    import= "hal.u22.works.team.a.web.entities.Page"%>

<!DOCTYPE html>
<%
	ArrayList<AdminstratorInquiryInfo> arrayInquiry= (ArrayList<AdminstratorInquiryInfo>)request.getAttribute("arrayInquiry");
	Page p = (Page)request.getAttribute("PAGE");
%>
<html lang="ja">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>お問い合わせリスト画面</title>
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
					<th>日付</th>
					<th>会員ID</th>
					<th>会員名</th>
					<th>内容</th>
				</tr>
			</thead>
			<tbody>
			<%for(AdminstratorInquiryInfo inquiry : arrayInquiry){%>
				<tr>
					<td><%=inquiry.getSendDate() %></td>
					<td><%=inquiry.getMemberNo() %></td>
					<td><%=inquiry.getMemberName() %></td>
					<td><a href="./AdminstratorInquiryServlet?flagNum=10&no=<%=inquiry.getSequence() %>">内容詳細</a></td>
				</tr>
			<%}%>
			</tbody>
		</table>
		<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
		<%if(p.getBackF()){%>
			<li class="page-item">
				<a class="page-link" href="./AdminstratorInquiryServlet?id=<%=p.getNextPage()-1 %>&flagNum=1" aria-label="前">
		       		<span aria-hidden="true">&laquo;</span>
		       		<span class="sr-only">前</span>
		    		</a>
		    </li>
		<%} %>
			<%if(p.getMinF()){%><li class="page-item"><a class="page-link" href="./AdminstratorInquiryServletServlet?id=1&flagNum=1">1..</a></li><%} %>
			<li <%=(p.getOneFlg())%>><a class="page-link" href="./AdminstratorInquiryServlet?id=<%=p.getOne() %>&flagNum=1"><%=p.getOne() %></a></li>
			<%if(p.getPage() >= 2){%><li <%=(p.getTwoFlg())%>><a class="page-link" href="./AdminstratorInquiryServlet?id=<%=p.getTwo() %>&flagNum=1"><%=p.getTwo() %></a></li><%} %>
			<%if(p.getPage() >= 3){%><li <%=(p.getThreeFlg())%>><a class="page-link" href="./AdminstratorInquiryServlet?id=<%=p.getThree() %>&flagNum=1"><%=p.getThree() %></a></li><%} %>
			<%if(p.getPage() >= 4){%><li <%=(p.getFourFlg())%>><a class="page-link" href="./AdminstratorInquiryServlet?id=<%=p.getFour() %>&flagNum=1"><%=p.getFour() %></a></li><%} %>
			<%if(p.getPage() >= 5){%><li <%=(p.getFiveFlg())%>><a class="page-link" href="./AdminstratorInquiryServlet?id=<%=p.getFive() %>&flagNum=1"><%=p.getFive() %></a></li><%} %>
			<%if(p.getMaxF()){%><li class="page-item"><a class="page-link" href="./AdminstratorInquiryServlet?id=<%=p.getPage() %>&flagNum=1">..<%=p.getPage() %></a></li><%} %>
			<%if(p.getNextF()){%>
			<li class="page-item">
		      <a class="page-link" href="./AdminstratorInquiryServlet?id=<%=p.getNextPage()+1 %>&flagNum=1" aria-label="次">
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