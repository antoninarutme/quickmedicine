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
	<%@ include file="myorder.jsp" %>
	<form name="frm" action="SearchDrug" method="get">
	<h4><label for="nameField">�� ������:</label></h4>
    <input type="text" name="theNameField" id="nameField">
    <input type="submit" name="complete" value="����">
    <br />
    <h4><label for="quantityField">���� �������:</label></h4>
    <input type="text" name="theQuantityField" id="quantityField">
    <br />
    <input type="submit" name="search" value="����">
</form>
	</center>
</body>
</html>