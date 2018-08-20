<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%
ArrayList<Map<String, String>> arr = (ArrayList<Map<String, String>>)request.getAttribute("result");
System.out.println();
int cnt = 0;
%>
[
<% for(Map<String, String> rec : arr){
	System.out.println(rec.get("title"));
	if(cnt != 0) {%>
		,
	<% } %>
	{
		"point_no" : "<%= rec.get("point_no") %>",
		"title" : "<%= rec.get("title")%>",
		"money" : "<%= rec.get("money")%>",
		"place" : "<%= rec.get("place")%>",
		"latitude" : "<%= rec.get("latitude")%>",
		"lngitude" : "<%= rec.get("longitude")%>",
		"content" : "<%= rec.get("content")%>",
		"phote" : "<%= rec.get("phote")%>",
		"target_money" : "<%= rec.get("target_money")%>",
	}
<%cnt++;
} %>
]