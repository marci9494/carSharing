<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="/carSharing/html/css/bewerten.css" media="screen" />
<jsp:include page="/theme/html/header.jsp" />

<div class="banner-wrapper">
	<img class="banner" alt="Banner" src="/carSharing/html/img/header.jpg">
	<div id="header-content">
		<h1 id="header-content-text">Deine Bewertung</h1>
	</div>
</div>
<br>


<body>
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


		<p>
			Auf CarNow kannst du Nutzer bewerten und ihnen noch zusätzliche
			Nachrichten schreiben.<br> Bitte bewerte deinen Vertragspartner
			auf einer fairen Basis!
		</p>
		<br>
		<h5>Daten des zu bewertenden Autos im Überblick</h5>

		<span class="form-field-label"> Marke:
			${buchung.fahrzeug.hersteller.name} </span> <br> <br> <br> <br>
		<span class="form-field-label"> Modell:
			${buchung.fahrzeug.modell} </span> <br> <br> <br> <br> <span
			class="form-field-label"> Farbe:
			${buchung.fahrzeug.farbe.name} </span> <br> <br> <br> <br>
		<span class="form-field-label"> Sitzplätze:
			${buchung.fahrzeug.sitzplaetze} </span> <br>
		<h2>Deine Bewertung</h2>
		<form action="bewerten" method="post" accept-charset="ISO-8859-1">
			<div>
				<label>Zustand Fahrzeugs</label> <br> <select id="zustand"
					name="zustand">
					<option value="1">sehr schlecht</option>
					<option value="2">schlecht</option>
					<option value="3">gut</option>
					<option value="4">sehr gut</option>
				</select>
			</div>
			<br>
			<div>
				<label>Freundlichkeit</label> <br> <select id="freundlichkeit"
					name="freundlichkeit" style="margin-bottom: 10px;">
					<option value="1">sehr schlecht</option>
					<option value="2">schlecht</option>
					<option value="3">gut</option>
					<option value="4">sehr gut</option>
				</select>
			</div>
			<br>
			<div>
				<label>Bezahlvorgang</label> <br> <select id="zahlen"
					name="zahlen" style="margin-bottom: 10px;">
					<option value="1">sehr schlecht</option>
					<option value="2">schlecht</option>
					<option value="3">gut</option>
					<option value="4">sehr gut</option>
				</select>
			</div>
			<br>
			<div>
				<label>Sonstiges:</label><br>
				<textarea name="kommentar" cols="35" rows="4"></textarea>
			</div>
			<div style="margin-top: 10px;">
				<input type="hidden" name="userId" value="${user.id}" /> <input
					type="hidden" name="buchungsId" value="${buchung.id}" /> <input
					style="width: 100px;" type="submit" value="Speichern" />
			</div>
		</form>
	</div>
</body>
<script>
	function bewerten(buchungsId) {
		jQuery.post("bewerten", {
			action : "bewerten",
			buchungId : buchungId,

		}, function(data, status) {
			location.reload();
		});
	}
</script>

<jsp:include page="/theme/html/footer.html" />


<script src="/carSharing/html/js/home.js"></script>

<script></script>


</html>
