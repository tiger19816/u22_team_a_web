<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="hal.u22.works.team.a.web.entities.Posts"%>
<%@ page import="java.util.*" %>
<%
ArrayList<Posts> postsList = (ArrayList<Posts>)request.getAttribute("LIST");
%>
{
	"assistsList":[
		<% for(int i=0; i<postsList.size(); i++){ %>
		{
			"postNo":"<%= postsList.get(i).getNo() %>",
			"postTitle":"<%= postsList.get(i).getTitle() %>",
			"postPhoto":"<%= postsList.get(i).getPhoto() %>",
			"postMoney":"<%= postsList.get(i).getMoney() %>",
			"postDate":"<%= postsList.get(i).getDate() %>",
			"postStatus":"<%= postsList.get(i).getStatus() %>"
		}<% if(i != (postsList.size()-1)){ %>,<% } %>
		<% } %>
	]
}