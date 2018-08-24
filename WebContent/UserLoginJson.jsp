<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String str = (String)request.getAttribute("result");
	String userId = (String)request.getAttribute("userId");
	String userName = (String)request.getAttribute("userName");
%>
{
	"result":<%= str %>,
	"userId":<%= userId %>,
	"userName":<%= userName %>
}