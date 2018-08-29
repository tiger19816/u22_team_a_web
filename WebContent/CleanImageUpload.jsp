<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ page import = "java.util.ArrayList"%>
<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

ArrayList<String[]> supplierList = (ArrayList<String[]>)request.getAttribute("supplierList");
ArrayList<String[]> projectsList = (ArrayList<String[]>)request.getAttribute("projectsList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="CleanImageUploadServlet" method="post" enctype="multipart/form-data">
業者
<select name = "supplierNo">
	<% for(String[] supplier : supplierList){%>
			<option value = <%=supplier[0]%>><%=supplier[1]%></option>
	<%}%>
</select><br>

プロジェクト番号
<select name = "projectNo">
	<% for(String[] project : projectsList){%>
			<option value = <%=project[0]%>><%=project[1]%></option>
	<%}%>
</select><br>
<input type="file" name="fileName" id="inputphoto" size="50" accept="image/jpeg,image/png">
<button type="submit" id="sbbutton">投稿する</button>
</form>
</body>
</html>