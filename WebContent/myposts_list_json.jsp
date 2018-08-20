<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entities.*" %>
<%@ page import="java.util.*" %>
<%
ArrayList<Posts> postsList = (ArrayList<Posts>)request.getAttribute("LIST");
%>
{
	"postsList":[
		<% for(int i=0; i<postsList.size(); i++){ %>
		{
			"postTitle":"<%= postsList.get(i).getTitle() %>",
			"postPhoto":"<%= postsList.get(i).getPhoto() %>",
			"postMoney":"<%= postsList.get(i).getMoney() %>",
			"postDate":"<%= postsList.get(i).getDate() %>",
			"postStatus":"<%= postsList.get(i).getStatus() %>"
		}<% if(i != (postsList.size()-1)){ %>,<% } %>
		<% } %>
	]
}