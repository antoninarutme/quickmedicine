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
	<form name="myForm" action="OpenSession" method="post">
	<h4><label for="idField"> : . ת . ז </label></h4>
    <input type="text" name="theIdField" id="idField">
    <br>
    <div id= "HMO">
    	<ul>
    	<li><input type="radio" name="theHmoField" id="prati" value="prati"><label for="prati"><img src="https://dl.dropboxusercontent.com/u/22885397/github/prati.png" alt="I'm sad" /></label></li>
		<li><input type="radio" name="theHmoField" id="Leumit" value="Leumit"><label for="Leumit"><img src="https://altor.super-pharm.co.il/SuperpharmQueues/Content/images/leumit_color.png" alt="I'm sad" /></label></li>
		<li><input type="radio" name="theHmoField" id="Clalit" value="Clalit"><label for="Clalit"><img src="https://altor.super-pharm.co.il/SuperpharmQueues/Content/images/clalit_color.png" alt="I'm sad" /></label></li>
		<li><input type="radio" name="theHmoField" id="Maccabi" value="Maccabi"><label for="Maccabi"><img src="https://dl.dropboxusercontent.com/u/22885397/github/macabi.png" alt="I'm sad" /></label></li>
		<li><input type="radio" name="theHmoField" id="Meuhedet" value="Meuhedet"><label for="Meuhedet"><img src="https://altor.super-pharm.co.il/SuperpharmQueues/Content/images/meuhedet_color.png" alt="I'm sad" /></label></li>
        <br>
         </ul>
     </div>
     <input type="submit" value="Open session">
</form>
</center>


</body>
</html>