<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="stylesheet" type="text/css" href="/carSharing/html/css/profil.css" media="screen" />
<jsp:include page="/theme/html/header.html" />
<style>
	<jsp:include page="/html/css/profil.css" />
</style>



<body>
	<div class="banner-wrapper">
		<img class="banner" alt="Banner"
		src="/carSharing/html/img/header.jpg">

	</div>

<main> 

<br>

				
				
			<div id="header-content" >
				<h1 id="header-content-text">Meine CarNow Accountdetails</h1>
			</div>
			
				
			<p> Hier findest du alle wichtigen Infos rund um deinen Account. Stell sicher, dass deine Angaben immer auf dem neusten Stand sind, damit deiner Nutzung von carNow nichts im Wege steht. 
			Solltest du Fragen haben, melde dich gern bei uns.</p>
			<div id="name-adress" class="name-adress">
			<h2> Persönliche Daten</h2>
			<span class="form-field-label">Anrede</span>
			<br><br><br><br>
			<span class="form-field-label">Vorname</span>
			<br><br><br><br>
			<span class="form-field-label">Nachname</span>
			<br><br><br><br>
			<span class="form-field-label">Adresse</span>
			<br><br><br><br>
			<span class="form-field-label">E-Mail-Adresse</span>
			<br><br><br><br>
			<span class="form-field-label">Mobilfunknummer</span>
			<br><br><br><br>
			<span class="form-field-label">Dein Passwort</span>
			<br><br><br><br>
			</div>
			 <button type="button" id="button--primary">Daten ändern</button>
			 <br><br><br><br>
			 <h2> Führerscheindaten</h2>
			 <p> Lade hier ein Foto von deinem Führerschein hoch, damit eine Nutzung von carNow möglich ist. </p>
			 <br>
			 <button type="button" id="button--primary">Hochladen</button>
			 <input name="datei" type="file" size="50" accept="text/*"> 
			 <br><br><br><br>
			 <h2> Kreditkarteninformationen</h2>
			 <span class="form-field-label">Anbieter</span>
			<br><br><br><br>
			<span class="form-field-label">Kartenummer</span>
			<br><br><br><br>
			<span class="form-field-label">Gültigkeit</span>
			<br><br><br><br>
			<span class="form-field-label">Prüfziffer</span>
			 <br><br><br><br>
			 <button type="button" id="button--primary">Daten ändern</button>
			 <br><br><br><br>
		</main> 


</body>
<jsp:include page="/theme/html/footer.html" />

<script src="/carSharing/html/js/profil.js"></script>




</html>
