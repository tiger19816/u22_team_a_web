<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Boolean str = (Boolean)request.getAttribute("result");
	int userId = (Integer)request.getAttribute("userId");
%>
{
	"result":<%= str %>,
	"userId":<%= userId %>
}