<%@page import="dbManager.Drug" %>
<%@page import="dbManager.DataStoreDatabaseManager" %>
<%@page import="java.io.BufferedReader" %>
<%@page import="java.io.IOException" %>
<%@page import="java.io.InputStream" %>
<%@page import="java.io.InputStreamReader" %>
<%@page import="java.io.PrintWriter" %>
<%@page import="java.util.LinkedList" %>
<%@page import="java.net.*" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml" dir="rtl"><head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta name="keywords" content="">
<meta name="description" content="">
<link href="proba.css" rel="stylesheet" type="text/css">
</head>

<html>
<body>

<% LinkedList<String> druglist = new LinkedList<String>();
try {
	URL url = new URL("https://dl.dropboxusercontent.com/u/22885397/github/drug%20list.txt");
	InputStream ins = url.openStream();
	InputStreamReader insr = new InputStreamReader (ins);
	BufferedReader br = new BufferedReader (insr);
	try
		{
		   String line = br.readLine();
		   while (line != null) {
		        druglist.add(line);
		        line = br.readLine();
		        if (line != null)
		       		line = br.readLine();
		   }
		   br.close();
		   insr.close();
		 }
	catch (IOException exception)
		{
		   System.out.println ("Reading error " + exception.getMessage());
		}
}
catch (MalformedURLException e) {}
catch (IOException e) {} %>

	<center>
	<%@ include file="myorder.jsp" %>
	<form name="frm" action="SearchDrug" method="get">
	<h4><label for="nameField">שם התרופה:</label></h4>
	
    <select name = "theNameField">
    	<% for (int i=0; i<druglist.size(); i++) { %>
    		<option value="<%=druglist.get(i)%>"><%= druglist.get(i) %></option>
    	<% } %>
    </select>
    
    <!-- <input type="submit" name="complete" value="השלם">  -->
    
    <br />
    <h4><label for="quantityField">כמות בכדורים:</label></h4>
    <input type="text" name="theQuantityField" id="quantityField">
    <br />
    <input type="submit" name="search" value="הוסף">
</form>
	</center>
</body>
</html>