<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml" dir="rtl">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>בית מרקחת</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link href="proba.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="navigation.jsp" %>
<div id="contactus">
		<div style="margin-bottom: 20px; padding-bottom: 15px; border-bottom: 1px solid #4AF4FE;">
			<h1 class="title">צור קשר</h1>
			<p><img src="https://dl.dropboxusercontent.com/u/22885397/github/logo.jpg" alt="" width="120" height="160" class="left"></p>
			</div>
			<div class="content">
<h3>טופס יצירת קשר</h3>
<div class="contact_form">
    <div class="errors"></div>
    <div id="popup">
    <div style="margin:0 auto;width:140px;" id="success" class="success"></div>
    </div>
        
      <script type="text/javascript">
      //<![CDATA[
      
   	function EmptyTextValidator()	{
   	  var check = true;
   	
	check = check & checkField('form_first_name');
	check = check & checkField('form_last_name');
	check = check & checkField('form_email');
	check = check & checkField('form_subject');
         if(!check) {
            alert("נא למלא את כל שדות החובה");
         }
   		return (check) ? true : false;
   	}

   	function checkField(fieldId) {
   	  
   	  var field = document.getElementById(fieldId);
      if(!field) {return true;}
      if(field.disabled) {return true};
   	  switch (field.tagName){
   	  		case "INPUT":
   	  		case "TEXTAREA":
                if(field.type=="checkbox"){
                    var empty = !field.checked;
                }else{
                    var empty = (field.value == "");
                }
                break;
   	  		case "SELECT":
   	  			var empty = !parseInt(field.options[field.selectedIndex].value);
   	  			break;
   	  }
   		if (empty) {
   			field.focus();
            if("checkbox" == field.type){
                document.getElementById("label_"+field.id).style.border = "1px red solid";
            }else{
                field.style.border = "1px red solid";
            }
   			return false;
   		}
	   	field.style.border = "1px #BBBBBB solid";
   		return true;
   	}
   	
      //]]>
      </script>    <form method="post" action="" onsubmit="return EmptyTextValidator();">
        <input type="hidden" name="backUrl" value="http://www.do-be.co.il/inner.php?dyn_id=8" id="form_backUrl">        <div class="label">שם פרטי<span class="needed">*</span></div>
        <div><input type="text" name="first_name" value="" id="form_first_name" maxlength="255" keyev="true" style="background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAABHklEQVQ4EaVTO26DQBD1ohQWaS2lg9JybZ+AK7hNwx2oIoVf4UPQ0Lj1FdKktevIpel8AKNUkDcWMxpgSaIEaTVv3sx7uztiTdu2s/98DywOw3Dued4Who/M2aIx5lZV1aEsy0+qiwHELyi+Ytl0PQ69SxAxkWIA4RMRTdNsKE59juMcuZd6xIAFeZ6fGCdJ8kY4y7KAuTRNGd7jyEBXsdOPE3a0QGPsniOnnYMO67LgSQN9T41F2QGrQRRFCwyzoIF2qyBuKKbcOgPXdVeY9rMWgNsjf9ccYesJhk3f5dYT1HX9gR0LLQR30TnjkUEcx2uIuS4RnI+aj6sJR0AM8AaumPaM/rRehyWhXqbFAA9kh3/8/NvHxAYGAsZ/il8IalkCLBfNVAAAAABJRU5ErkJggg==); padding-right: 0px; background-attachment: scroll; cursor: auto; background-position: 100% 50%; background-repeat: no-repeat no-repeat;"></div>
        <div class="label">שם משפחה<span class="needed">*</span></div>
        <div><input type="text" name="last_name" value="" id="form_last_name" maxlength="255"></div>
        <div class="label">אימייל<span class="needed">*</span></div>
        <div><input type="text" name="email" value="" id="form_email" maxlength="255"></div>
        <div class="label">טלפון</div>
        <div><input type="text" name="phone" value="" id="form_phone" maxlength="255"></div>
        <div class="label">נושא ההודעה<span class="needed">*</span></div>
        <div><input type="text" name="subject" value="" id="form_subject" maxlength="255"></div>
        <div class="label">פרטי ההודעה</div>
        <div><textarea type="text" name="body" id="form_body" onkeyup="maxlength('form_body', 'form_body_cnt', 1000)"></textarea> <div class="tcount"><span id="form_body_cnt">0</span>/1000</div></div>
        <div><input type="submit" value="שלך"></div>
    
    </form>
    <div class="clear-divs"></div>
</div>
</div>
            </div>

	</div>
</body>
</html>