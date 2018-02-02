<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>

	<jsp:include page="/theme/css/main.css" />
	input	{	padding-left: 1em;
				height:	15px;	
				border-bottom: 1px dotted #666666;
				border-top: 0px;
				border-left: 0px;
				border-right: 0px;}	
	label	{	padding-left: 5em;
				margin: 0 auto;
  			  	margin-top: 1em;
				margin-bottom:.5em;	}
	  
	hr { 		width: 50%; 
    			height: 1px; 
    			margin: 0 auto;
    			color: grey;
    			background: #1f7cdf;	} 
</style>
<jsp:include page="/theme/html/header.html" />


<body>

<p>Registrierung</p>

<form action="" id="user">

    <label for="email">Email</label>
    <input type="email" name="email" id="email" size="30" maxlength="30" style="height:40px"> 
    
    <br> <br>
 
    <label for="passwort">Passwort</label>  
    <input type="password" name="passwort" id="passwort" size="30" maxlength="30" style="height:40px">
	
	<label for="passwort">Passwort bestätigen</label>  
    <input type="password" name="passwort" id="passwort" size="30" maxlength="30" style="height:40px"> 
    
    <br> <br>
    <hr>
    <br>
  
    <label for="vorname">Vorname</label>
    <input type="text" name="vorname" id="vorname" size="30" maxlength="30" style="height:40px">
  
    <label for="nachname">Nachname</label>
    <input type="text" name="nachname" id="nachname" size="30" maxlength="30" style="height:40px">
  
  	<br> <br>
  	
  	<label for="strasse">Straße</label>
    <input type="text" name="strasse" id="strasse" size="30" maxlength="30" style="height:40px">
  	
  	<label for="hausnummer">Hausnummer</label>
    <input type="text" name="hausnummer" id="hausnummer" size="30" maxlength="8" style="height:40px">
  	
  	<br><br>

  	<label for="postleitzahl">Postleitzahl</label>
    <input type="text" name="strasse" id="strasse" size="30" maxlength="30" style="height:40px">
  	
  	<label for="stadt">Stadt</label>
    <input type="text" name="stadt" id="stadt" size="30" maxlength="8" style="height:40px">
  	
  	<label for="geburtsdatum">Geburtsdatum</label>
    <input type="date" name="geburtsdatum" id="geburtsdatum" size="30" style="height:40px">
  	
  
</body>
<jsp:include page="/theme/html/footer.html" />

</html>