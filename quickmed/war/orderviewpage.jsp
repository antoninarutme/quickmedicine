<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="dbManager.Order" %>
<%@page import="dbManager.OrderedDrug" %>
<%@page import="dbManager.DataStoreDatabaseManager" %>
<%@page import="java.util.List;" %>

<!doctype html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>medPage</title>
    <link href="proba.css" rel="stylesheet" type="text/css">
  </head>

  <body bgcolor="#99CCCC">
	<%@ include file="navigation.jsp" %>
    <br>
    <br>
    <div>
    <%
	if (session.getAttribute("userName") == null) {
		%> <h1><center>You didn't open a session</center></h1> <%
	}
	else {
		int id = Integer.parseInt(session.getAttribute("userName").toString());
    	Order o = DataStoreDatabaseManager.getInstance().getOrderByClientID(id);
		LinkedList<OrderedDrug> list = o.getDrugs();
		%> 
		<center>
		<h13>Your order:</h13>
		
		<table border="1">
		<tr>
        <th>name</th>
        <th>quantity</th>
        <th>price</th>
		</tr>
		<tr>
		<%for (OrderedDrug item : list) {%>
        	<td><%= item.name %></td>
        	<% System.out.println(item.name); %>
        	<td><%= item.quantity %></td>
        	<td><%= item.price %></td>
        	</tr>
        	<% } %> </table>
		<h13>Total price:<%= o.getPrice()%> </h13>
		<%
	} %> 
			</center>
		</div>
		
  	</body>
</html>