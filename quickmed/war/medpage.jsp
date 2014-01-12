<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>medPage</title>
    <link href="proba.css" rel="stylesheet" type="text/css">
  </head>

  <body bgcolor="#99CCCC"
		bgimage: url("https://mail.google.com/mail/u/1/?ui=2&ik=ef47f35f33&view=att&th=141e45b211cb65a5&attid=0.1&disp=thd&realattid=f_hn4a4yfa0&zw")>
    <%@ include file="navigation.jsp" %>
    <br>
    <br>
    <h1><center>בבקשה הכנס את הנתונים הבאים:</center></h1>
    
    <p>
	</p>

     <%@ include file="drugform.jsp" %>
     <%
	if (session.getAttribute("userName") != null) {
		%> <form action="setorder.jsp">
    <input type="submit" value="המשך להזמנת תור">
	</form> <%
	} %>
	
  </body>
</html>