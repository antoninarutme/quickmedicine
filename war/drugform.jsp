<%@page import="dbManager.Drug" %>
<%@page import="dbManager.DataStoreDatabaseManager" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml" dir="rtl"><head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta name="keywords" content="">
<meta name="description" content="">
<link href="proba.css" rel="stylesheet" type="text/css">
</head>

<html>
<body>
<center>
	<form name="frm" action="SearchDrug" method="get">
	<h4><label for="nameField">שם התרופה:</label></h4>
    <input type="text" name="theNameField" id="nameField">
    <br />
    <h4><label for="quantityField">כמות בכדורים:</label></h4>
    <input type="text" name="theQuantityField" id="quantityField">
    <br />
    <input type="submit" value="בדיקה">
</form>
</center>


</body>
</html>