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
	<form name="frm" action="InventoryServlet" method="post">
	<h4><label for="nameField">שם התרופה:</label></h4>
    <input type="text" name="theNameField" id="nameField">
    <br />
    <h4><label for="quantityField">כמות בכדורים:</label></h4>
    <input type="text" name="thequantityField" id="quantityField">
    <br />
    <h4><label for="theMeuhedetPriceField">מחיר מאוחדת:</label></h4>
    <input type="text" name="theMeuhedetPriceField" id="theMeuhedetPriceField">
    <br />
    <h4><label for="theMaccabiPriceField">מחיר מכבי:</label></h4>
    <input type="text" name="theMaccabiPriceField" id="theMaccabiPriceField">
    <br />
    <h4><label for="theClalitPriceField">מחיר כללית:</label></h4>
    <input type="text" name="theClalitPriceField" id="theClalitPriceField">
    <br />
    <h4><label for="theLeumitPriceField">מחיר לאומית:</label></h4>
    <input type="text" name="theLeumitPriceField" id="theLeumitPriceField">
    <br />
    <h4><label for="theHMOlessPriceField">מחיר פרטי:</label></h4>
    <input type="text" name="theHMOlessPriceField" id="theHMOlessPriceField">
    <br />
    <input type="submit" value="הכנס">
</form>
</center>
