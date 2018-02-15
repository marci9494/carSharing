<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="stylesheet" type="text/css" href="/carSharing/html/css/cars.css" media="screen" />
<jsp:include page="/theme/html/header.html" />
<style>
	<jsp:include page="/html/css/cars.css" />
</style>



<body>
	<div class="banner-wrapper">
		<img class="banner" alt="Banner"
		src="/carSharing/html/img/header.jpg">

	</div>

<main> 

<br>

				
				
			<div id="header-content" >
				<h1 id="header-content-text">Meine CarNow Fahrzeuge</h1>
			</div>
			
				
			<p> Hier findest du alle wichtigen Infos rund um deine zum Mieten freigegebenen Fahrzeuge. Stell sicher, dass die Angaben zum Fahrzeug immer auf dem neusten Stand sind, damit deiner Nutzung von carNow nichts im Wege steht. 
			Solltest du Fragen haben, melde dich gern bei uns.</p>
			<div id="name-adress" class="name-adress">
			<h2> Fahrzeuge</h2>
			<div id = "box">
			<span class="form-field-label">Marke</span>
			<br><br>
			
			<br><br>
			<span class="form-field-label">Modell</span>
			<br><br>
			<div id="daten" class="daten">
			
			</div>
			<br><br>
			<span class="form-field-label">Kilometerstand</span>
			<br><br>
			<div id="daten" class="daten">
			
			</div>
			<br><br>
			<span class="form-field-label">Farbe</span>
			<br><br><br><br>
			<span class="form-field-label"> Sitzplätze</span>
			<br><br><br><br>
			<span class="form-field-label">Leistung</span>
			<br><br><br><br>
			<span class="form-field-label">Bewertung (?)</span>
			<br>
			</div>
			</div>
			 <button type="button" id="button--primary">Daten ändern</button>
			 <br><br><br><br>
			 <h2> Fahrzeugschein</h2>
			 <p> Lade hier ein Foto mit Vorder- und Rückseite von deinem Fahrzeugschein hoch, damit eine Nutzung von carNow möglich ist. </p>
			 <br>
			 <div class="file-upload btn btn-primary">	
			 <span>Hochladen</span>  
			<input class="upload" type="file"></div> //Anzeige, welche Datei hochgeladen wurde?
			 <br><br><br><br>
		</main> 


</body>
<jsp:include page="/theme/html/footer.html" />

<script src="/carSharing/html/js/profil.js"></script>




</html>
