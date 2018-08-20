<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String[] str = (String[])request.getAttribute("result");
%>
[
{
	<%= str[0] %>,
	"title":<%= str[1]%>
	"money":
	"place":
	"latitude":
	"longitude":
	"content":
	"photo":
	"target_money":
}
]