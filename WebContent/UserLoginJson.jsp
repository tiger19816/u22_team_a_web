<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String str = (String)request.getAttribute("result");
	String userId = (String)request.getAttribute("userId");
%>
{
	"result":<%= str %>,
	"userId":<%= userId %>
}