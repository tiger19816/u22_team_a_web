<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList"%>
<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

ArrayList<String[]> supplierList = (ArrayList<String[]>)request.getAttribute("supplierList");
ArrayList<String[]> projectsList = (ArrayList<String[]>)request.getAttribute("projectsList");

for(int i = 0; i < supplierList.size();i++){

	String[] supplier = supplierList.get(i);
	System.out.println(supplier[0] + ":" + supplier[1]);

}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title><style>
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
<form action="CleanImageUploadServlet" method="post" enctype="multipart/form-data">
<p style="margin-top:20px;">業者</p>
<select name = "supplierNo" class="form-control">
	<% for(String[] supplier : supplierList){%>
			<option value = <%=supplier[0]%>><%=supplier[1]%></option>
	<%}%>
</select><br>

<p>プロジェクト番号</p>
<select name = "projectNo" class="form-control">
	<% for(String[] project : projectsList){%>
			<option value = <%=project[0]%>><%=project[1]%></option>
	<%}%>
</select><br>
<input type="file" name="fileName" id="inputphoto" size="50" accept="image/jpeg,image/png">
<button type="submit" id="sbbutton" class="btn btn-primary">投稿する</button>
</form>
</div>
</div>
</body>
</html>