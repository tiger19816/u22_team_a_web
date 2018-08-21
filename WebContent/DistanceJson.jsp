<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%
ArrayList<Map<String, String>> arr = (ArrayList<Map<String, String>>)request.getAttribute("result");
int cnt =0;
%>
[
<%for(Map<String,String> a:arr){%>
   <%if(cnt != 0){%>
      ,
   <%}%>
   {
   "point_no":"<%=a.get("point_no")%>"
   "title":"<%=a.get("title")%>"
   "money":"<%=a.get("money")%>"
   "place":"<%=a.get("place")%>"
   "latitude":"<%=a.get("latitude")%>"
   "longitude":"<%=a.get("longitude")%>"
   "content":"<%=a.get("content")%>"
   "phote":"<%=a.get("phote")%>"
   "target_money":"<%=a.get("target_money")%>"
   }
<%cnt++;%>
<%}%>
]