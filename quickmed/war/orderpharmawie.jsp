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
    <div id = "order">
	<h13>Your orders:</h13>
	<% DataStoreDatabaseManager datastore = DataStoreDatabaseManager.getInstance();
	   List<Order> list = DataStoreDatabaseManager.getInstance().getAllOrders();%>
	<table border="1">
	<tr>
    <th>order id</th>
    <th>date</th>
    <th>from hour</th>
    <th>to hour</th>
    </tr>
	<tr>
	<%for (Order item : list ) {%>
    	<td><%= item.orderID %></td>
    	<td><%= item.printDate() %></td>
    	<td><%= item.from_hour %></td>
    	<td><%= item.to_hour %></td>
    	</tr>
    	<% } %> </table> 
	</div>
		
  </body>
</html>