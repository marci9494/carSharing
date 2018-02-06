<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<Style> 
<jsp:include page="/theme/css/main.css" />
<jsp:include page="/html/css/register.css" />
</Style>

<jsp:include page="/theme/html/header.html" />


<body>

<p>Registrierung</p>


<form method="post" enctype="multipart/form-data" id="user">


<h1> Logindaten </h1>

	<div class="wrapper">
    <label for="email">Email</label>
    <input type="email" name="email" id="email"
   		placeholder="Geben Sie bitte Ihre Email an" size="30" maxlength="30" required> 
	</div>
   
 	<div class="wrapper">
    <label for="passwort">Passwort</label>  
    <input type="password" name="passwort" id="passwort" 
    	placeholder="Bitte geben Sie ein Passwort ein" size="30" maxlength="30" required>
	
	<label for="passwort">Passwort bestätigen</label>  
    <input type="password" name="passwort" id="passwort" 
    	placeholder="Bitte bestätigen Sie Ihr Passwort" size="30" maxlength="30" required> 
    </div>
	
	<br>
	<div class="wrapper">
    <h1>Persönliche Daten</h1>
    </div>
    
   	<div class="wrapper">
    <label>Anrede:
    <select name="anrede">
      <option>Frau</option>
      <option>Herr</option>
    </select>
    </div>
  
   	<div class="wrapper">
    <label for="vorname">Vorname</label>
    <input type="text" name="vorname" id="vorname" 
    	placeholder="Ihr Vorname" size="30" maxlength="30" required>

    <label for="nachname">Nachname</label>
    <input type="text" name="nachname" id="nachname" 
    	placeholder="Ihr Nachname" size="30" maxlength="30" required>
  	</div>
  	
  	<div class="wrapper">
  	<label class="strass" for="strasse">Straße</label>
    <input type="text" name="strasse" id="strasse" 
    	placeholder="Ihre Straße" size="40" maxlength="30" required>

  	<label for="hausnummer">Hausnummer</label>
    <input type="text" name="hausnummer" id="hausnummer" 
    	placeholder="Ihre Hausnummer" size="6" maxlength="8" required>
  	</div>
  	
	<div class="wrapper">
  	<label for="postleitzahl">Postleitzahl</label>
    <input type="text" name="strasse" id="strasse" 
    	placeholder="Ihre Postleitzahl" size="5" maxlength="30" required>

  	<label for="stadt">Stadt</label>
    <input type="text" name="stadt" id="stadt" 
    	placeholder="Ihr Wohnort" size="30" maxlength="8" required>
   	</div>
    
    <div class="wrapper">
    <label for="land">Land</label>
    <input type="text" name="land" id="land" value="Deutschland" size="30" maxlength="8" required>
  	</div>

  	<div class="wrapper">
  	<label for="geburtsdatum">Geburtsdatum</label>
    <input type="date" name="geburtsdatum" id="geburtsdatum" size="30" required>
  	</div>
  	<br><br>
  	
  	<div class="wrapper">
  	<label>Bild oder Scan Ihres Personalausweis
    <input name="datei" type="file" size="50" accept="text/*" required> 
  	</label>  
  	</div>
  	<br>
  	<div class="wrapper">
  	 <label>Bild oder Scan Ihres Führerscheins
    <input name="datei" type="file" size="50" accept="text/*" required> 
  	</label> 
  	</div>
  
   	<div class="submit">
  	<button type="submit" class="send_reg" name="submit" id="send_reg">Weiter</button>	
	</div>
 </form> 	
</body>
<jsp:include page="/theme/html/footer.html" />

</html>