<%@page import="java.util.ArrayList"%><%@page import="java.util.Map"%><%@page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<% ArrayList<Map<String, String>> arr = (ArrayList<Map<String, String>>)request.getAttribute("result");
int cnt =0; %>
[<%for(Map<String,String> a : arr){%><%if(cnt != 0){%>,<%}%>
   {
   "no":"<%=a.get("no")%>",
   "member_no":"<%=a.get("member_no")%>",
   "category_no":"<%=a.get("category_no")%>",
   "post_date":"<%=a.get("post_date")%>",
   "post_money":"<%=a.get("post_money")%>",
   "place":"<%=a.get("place")%>",
   "latitude":"<%=a.get("latitude")%>",
   "longitude":"<%=a.get("longitude")%>",
   "title":"<%=a.get("title")%>",
   "content":"<%=a.get("content")%>",
   "photo":"<%=a.get("photo")%>",
   "target_money":"<%=a.get("target_money")%>",
   "cleaning_flag":"<%=a.get("cleaning_flag")%>"
   }<%cnt++;%>
<%}%>]