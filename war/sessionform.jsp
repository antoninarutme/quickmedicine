<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="drugAlert.js"></script>

<html xmlns="http://www.w3.org/1999/xhtml" dir="rtl"><head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta name="keywords" content="">
<meta name="description" content="">
<link href="proba.css" rel="stylesheet" type="text/css">

</head>

<html>
<body>
<center>
	<form name="myForm" action="OpenSession" method="post">
	<h4><label for="idField"> : . ת . ז </label></h4>
    <input type="text" name="theIdField" id="idField">
    <br>
    <div id="menu">
    	<input type="radio" name="theHmoField" class="prati" value="prati">פרטית
		<input type="radio" name="theHmoField" id="leumit" value="leumit">
		<label for="leumit"><img src="https://altor.super-pharm.co.il/SuperpharmQueues/Content/images/leumit_color.png" alt="I'm sad" /></label>
		<input type="radio" name="theHmoField" id="klalit" value="klalit">
		<label for="klalit"><img src="https://altor.super-pharm.co.il/SuperpharmQueues/Content/images/clalit_color.png" alt="I'm sad" /></label>
		<input type="radio" name="theHmoField" id="macabi" value="macabi">
		<label for="macabi"><img src="data:image/jpeg;base64,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" alt="I'm sad" /></label>
		<input type="radio" name="theHmoField" id="meuhedet" value="meuhedet">
		<label for="meuhedet"><img src="https://altor.super-pharm.co.il/SuperpharmQueues/Content/images/meuhedet_color.png" alt="I'm sad" /></label>
        <br>
     </div>
     <input type="submit" value="Open session">
</form>
</center>


</body>
</html>