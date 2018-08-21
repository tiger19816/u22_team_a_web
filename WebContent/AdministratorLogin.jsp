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
<title>Insert title here</title>
</head>
<body>
<form action ="AdministratorLoginServlet" method="post">
<table>
	<tr><th>ID</th><td><input type="text" name ="id" value="<%= error.GetId()%>"></td></tr>
	<tr><th>PassWord</th><td><input type="text" name="pass"></td></tr>
	<tr><td colspan="2"><%=error.GetErrorLog() %></td></tr>
	<tr><td colspan="2"><input type="submit" value="ログイン"></td></tr>
	
</table>
</form>
</body>
</html>