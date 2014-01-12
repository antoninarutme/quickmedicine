<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="dbManager.Order" %>
<%@page import="dbManager.OrderedDrug" %>
<%@page import="dbManager.DataStoreDatabaseManager" %>
<%@page import="java.util.Calendar" %>
<%@page import="java.util.TimeZone" %>

<!doctype html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>setOrder</title>
    <link href="proba.css" rel="stylesheet" type="text/css">
  </head>

  <body bgcolor="#99CCCC"
		bgimage: url("https://mail.google.com/mail/u/1/?ui=2&ik=ef47f35f33&view=att&th=141e45b211cb65a5&attid=0.1&disp=thd&realattid=f_hn4a4yfa0&zw")>
    <%@ include file="navigation.jsp" %>
    <% int id = Integer.parseInt(session.getAttribute("userName").toString()); 
  	Order o = DataStoreDatabaseManager.getInstance().getOrderByClientID(id);
  	Calendar now = Calendar.getInstance(TimeZone.getTimeZone("GMT+2:00"));
  	int hour = now.get(Calendar.HOUR_OF_DAY); 
  	int date = now.get(Calendar.DATE);
  	int currentDay = now.get(Calendar.DAY_OF_WEEK);
  	int lastPharmaHour = 20;
%>

    
    <br>
    <br>
    <center><h4>Your order will be ready on <%= o.printDate()%></h4></center>
	<center>
		<form name="sethours" action="SetOrder" method="post">
			<select name = "theHourField">
			<% if (date == o.date) {
					if (currentDay == 6)
						lastPharmaHour = 12;
					for (int i=hour+1; i<=lastPharmaHour; i++) { %>
						<option value="<%=i%>"><%= "" + i + ":00 - " + (i+1) + ":00" %></option>
					<%}
				}
				else {
					if (currentDay+1 == 6)
						lastPharmaHour = 12;
					for (int i=8; i<=lastPharmaHour; i++) { %>
						<option value="<%=i%>"><%= "" + i + ":00 - " + (i+1) + ":00" %></option>
					<%}
				}%>
			</select>
   			 <input type="submit" value="המשך">
		</form>
	</center>
</body>
</html>