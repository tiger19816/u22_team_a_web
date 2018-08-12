<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%
ArrayList<ArrayList<String>> arr = (ArrayList<ArrayList<String>>)request.getAttribute("result");
%>
[
<% for(ArrayList<String>rec:arr){%>

     <% for(String data : rec){%>
     <%=data %>
     <%} %>

<%} %>
]