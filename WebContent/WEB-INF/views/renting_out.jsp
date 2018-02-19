<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="/carSharing/html/css/renting_out.css" media="screen" />
<jsp:include page="/theme/html/header.html" />
<style>
<jsp:include page="/html/css/renting_out.css" />
<jsp:include page="/theme/css/main.css" />
</style>

<body>
	<div class="banner-wrapper">
		<img class="banner" alt="Banner"
		src="/carSharing/html/img/header.jpg">
	</div>
<main>
//nur anzeigen wenn angemeldet
	<div class="logout">Herzlich Willkommen ${userEmail } <a href="/carsharing/Logout">(Logout)</a></div>

	<div id="header-content" >
		<h1 id="header-content-text">Auto&shyvermietung</h1>
	</div>
	<div>
	<h5>Autodaten im Überblick</h5>
		<p>
			<span class="form-field-label">Marke: ${car.marke}</span>
			<br><br><br><br>
			<span class="form-field-label">Modell: ${car.modell}</span>
			<br><br><br><br>
			<span class="form-field-label">Farbe: ${car.farbe}</span>
			<br><br><br><br>
			<span class="form-field-label"> Sitzplätze: ${car.sitzplätze}</span>
		</p>
	</p>
	</div>
	<div>
		<h5>Vermietungs&shyzeitraum</h5>
		<p>Gib hier den Zeitraum an, in dem du dein Auto anderen Nutzern zur Verfügung stellen willst.
			<br><br>
			<label><input type="date" value="von" /></label> -
			<label><input type="date" value="bis" /></label>
			<br><br>
			<button type="button" id="button--primary">Auto vermieten</button>
			<br><br>
		</p>
	</div>
</main>
</body>

<jsp:include page="/theme/html/footer.html" />
</html>