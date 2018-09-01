<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String name = (String)request.getAttribute("name");
	String birthdate = (String)request.getAttribute("birthdate");
	String address = (String)request.getAttribute("address");
	String mail_address = (String)request.getAttribute("mail_address");
	String phone = (String)request.getAttribute("phone");

%>
{
	"name":"<%= name %>",
	"birthdate":"<%= birthdate %>",
	"address":"<%= address %>",
	"mail_address":"<%= mail_address %>",
	"phone":"<%= phone %>"
}