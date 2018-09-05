<%@page import="hal.u22.works.team.a.administrator.AdministratorLoginError"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	AdministratorLoginError error = (AdministratorLoginError)request.getAttribute("error");
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理者ログイン画面</title>
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
<div class="row">
<form action ="AdministratorLoginServlet" method="post">
<table>

	<tr><th>ID</th><td><input type="text" class="form-control"  name ="id" value="<%= error.GetId()%>"></td></tr>
	<tr><th>PassWord</th><td><input type="password" class="form-control" name="pass"></td></tr>
	<tr><td colspan="2"><%=error.GetErrorLog() %></td></tr>
	<tr><td colspan="2"><input type="submit" class="btn btn-primary" value="ログイン"></td></tr>
	
</table>
</form>
</div>
</div>
</body>
</html>