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

  <body bgcolor="#99CCCC"
		bgimage: url("https://mail.google.com/mail/u/1/?ui=2&ik=ef47f35f33&view=att&th=141e45b211cb65a5&attid=0.1&disp=thd&realattid=f_hn4a4yfa0&zw")>

    <br>
    <br>
    <div id ="order">
    <%
	if (session.getAttribute("userName") == null) {
		%> <h1>You didn't open a session</h1> <%
	}
	else {
		int id = Integer.parseInt(session.getAttribute("userName").toString());
    	Order o = DataStoreDatabaseManager.getInstance().getOrderByClientID(id);
		LinkedList<OrderedDrug> list = o.getDrugs();
		%> <h13>Your order:</h13>
		
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
		</div>
  	</body>
</html>