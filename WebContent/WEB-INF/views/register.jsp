<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>

	<jsp:include page="/theme/css/main.css" />
	input	{	height:	15px;	
				border-bottom: 1px dotted #666666;
				border-top: 0px;
				border-left: 0px;
				border-right: 0px;}	
	label	{	margin: 0 auto;

	  
	hr { 		width: 50%; 
    			height: 1px; 
    			margin: 0 auto;
    			color: grey;
    			background: #1f7cdf;	} 
    			
    div.1 	{		background:	#ff3fb8;
    				border-color:        grey;	}	
    
</style>
<jsp:include page="/theme/html/header.html" />


<body>

<p>Registrierung</p>



<form method="post" enctype="multipart/form-data" id="user">

    <label for="email">Email</label>
    <input type="text" name="email" id="email" size="30" maxlength="30" style="height:40px"> 

    
    <br> <br>
 
    <label for="passwort">Passwort</label>  
    <input type="password" name="passwort" id="passwort" size="30" maxlength="30" style="height:40px">
	
	<label for="passwort">Passwort bestätigen</label>  
    <input type="password" name="passwort" id="passwort" size="30" maxlength="30" style="height:40px"> 
    
    <br> <br>
    
    <label>Anrede:
    <select name="anrede" size="1">
      <option>Frau</option>
      <option>Mann</option>
    </select>
    
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
  	
  	<br><br>
  	
  	<label for="geburtsdatum">Geburtsdatum</label>
    <input type="date" name="geburtsdatum" id="geburtsdatum" size="30" style="height:40px">
  	
  	<br><br>
  	
  	<label>Wählen Sie ein Bild oder Scan Ihres Personalausweis von Ihrem Rechner aus.
    <input name="datei" type="file" size="50" accept="text/*"> 
  	</label>  
  	
  	<br>
  	
  	 <label>Wählen Sie ein Bild oder Scan Ihres Führerscheins von Ihrem Rechner aus.
    <input name="datei" type="file" size="50" accept="text/*"> 
  	</label> 
  	
 </form> 	
</body>
<jsp:include page="/theme/html/footer.html" />

</html>