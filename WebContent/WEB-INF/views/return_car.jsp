<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="/carSharing/html/css/return_car.css" media="screen" />
<jsp:include page="/theme/html/header.jsp" />

<body>
	<!--Einbinden des Banners-->
	<div class="banner-wrapper">
		<img class="banner" alt="Banner" src="/carSharing/html/img/header.jpg">
		<!--Seitentitel auf Banner-->
		<div id="header-content">
			<h1 id="header-content-text">Autorückgabe</h1>
		</div>
	</div>



	<!--Content wrapper für gleiche Seitenabstände-->
	<div class="content-wrapper">

		<div id=hallo>
			<!--Prüfung ob User eingeloggt ist-->
			<!--Wenn ja: Begrüßung und Logout Option-->
			<!--Wenn nein: nur Begrüßung-->
			<c:choose>
				<c:when test="${ user!=null}">
					<div class="logout">
						Herzlich Willkommen ${user.vorname} ${user.nachname} <a
							href="/carSharing/logout">(Logout)</a>
					</div>
					<input type="hidden" class="userEmail" value="${userEmail}" />
				</c:when>
				<c:otherwise>
        			Herzlich Willkommen
    			</c:otherwise>
			</c:choose>
		</div>

		<p>Trage nun den aktuellen Kilometerstand deines Autos und
			eventuelle neu entstandene Schäden ein, bevor du das Auto als
			zurückgegeben annimmst.</p>

		<!--Autodaten des Zurückzugebenden Autos werden nochmals angezeigt-->
		<h5>Daten des Rückgabeautos im Überblick</h5>

		<span class="form-field-label"> Marke:
			${buchung.fahrzeug.hersteller.name} </span> <br>
		<br>
		<br>
		<br> <span class="form-field-label"> Modell:
			${buchung.fahrzeug.modell} </span> <br>
		<br>
		<br>
		<br> <span class="form-field-label"> Farbe:
			${buchung.fahrzeug.farbe.name} </span> <br> <br>
		<br>
		<br> <span class="form-field-label"> Sitzplätze:
			${buchung.fahrzeug.sitzplaetze} </span>

		<!-- Unsichtbares Feld, um später im Servlet die ID abrufen zu können-->
		<input type="hidden" id="buchungid" value="${buchung.id}" /> <br>
		<br>
		<br>


		<div>
			<!--User kann Mängel eingeben, die am Auto verursacht wurden-->
			<h5>Mängel</h5>
			Wurden während der Vermietung Mängel am Auto verursacht? Gib sie hier
			bitte ein. <br>
			<br>
			<textarea id="maengel" name="maengel" cols="35" rows="4"></textarea>
			<br>
		</div>

		<div>
			<!--Aktueller Kilometerstand nach Nutzung wird eingegeben-->
			<h5>Aktueller Kilometerstand</h5>
			<input type="text" name="kilometerstand" id="kilometerstand" size="5"><label>km</label>
			<br>
			<br>
		</div>

		<div>
			<!--Tatsächliches Rückgabedatum wird angegeben-->
			<h5>Rückgabedatum</h5>
			<input type="date" name="rueckgabdatum" id="rueckgabedatum" size="5"><label></label>
			<br>
			<br>
			<!--Button zur Rückgabe des Autos-->
			<button type="button" id="button--primary" onclick="returnCar()">Auto
				zurückgeben</button>
			<br>
		</div>


		<script>
			function returnCar() {
				//Daten werden aus den Eingabefeldern ausgelesen
				var maengel = jQuery('#maengel').val();
				var kilometerstand = jQuery('#kilometerstand').val();
				var buchungid = jQuery('#buchungid').val();
				var rueckgabedatum = jQuery('#rueckgabedatum').val();

				//Ausgelesene Daten werden gesetzt
				jQuery.post("return_car", {
					maengel : maengel,
					buchungid : buchungid,
					rueckgabedatum : rueckgabedatum,
					kilometerstand : kilometerstand
				//User wird nach Beendigung auf die Homeseite weitergeleitet
				}, function(data, status) {
					if (data) {
						window.location.href = "buchungen";
					} else {
						alert("Error. Bitte spaeter nochmals versuchen")
						window.location.href = "buchungen";
					}
				});
			}
		</script>
	</div>
</body>
<jsp:include page="/theme/html/footer.html" />
</html>