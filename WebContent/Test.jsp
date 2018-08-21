<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String str = (String)request.getAttribute("result");
%>
{
	"result":<%= str %>
}