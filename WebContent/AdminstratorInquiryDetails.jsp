<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
   import = "hal.u22.works.team.a.administrator.AdminstratorInquiryInfo"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	AdminstratorInquiryInfo inquiry =(AdminstratorInquiryInfo)request.getAttribute("inquiry");

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>一定額達成詳細画面</title>
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
	<table class="table table-striped">
		<tr><th>日付</th><td><%=inquiry.getSendDate() %></td></tr>
		<tr><th>会員番号</th><td><%=inquiry.getMemberNo() %></td></tr>
		<tr><th>会員名</th><td><%=inquiry.getMemberName() %></td></tr>
		<tr><th>メールアドレス</th><td><%=inquiry.getMailAddress() %></td></tr>
		<tr><th>内容</th><td></td></tr>
		<tr><td><%=inquiry.getContent() %></td></tr>

	</table>
<div id ="backpage">
	<a href="javascript:history.back()">戻る</a>
</div>
</div>
</body>
</html>