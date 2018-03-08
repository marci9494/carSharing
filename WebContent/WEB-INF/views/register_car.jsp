<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="/carSharing/html/css/register_car.css" media="screen" />

<jsp:include page="/theme/html/header.jsp" />

<body>

	<div class="banner-wrapper">
		<img class="banner" alt="Banner" src="/carSharing/html/img/header.jpg">

	</div>

	<div id="header-content">
		<h1 id="header-content-text">Fahrzeugregistrierung</h1>
	</div>
	<div class="content-wrapper">
		<div id=hallo>
			<c:choose>
				<c:when test="${ user!=null}">
					<div class="logout">
						Herzlich Willkommen ${user.vorname} ${user.nachname} <a
							href="/carsharing/logout">(Logout)</a>
					</div>
					<input type="hidden" class="userEmail" value="${userEmail}" />
				</c:when>
				<c:otherwise>
        			Herzlich Willkommen
    			</c:otherwise>
			</c:choose>
		</div>
		<form action="register_car" method="post" id="upload-form"
			enctype="multipart/form-data">
			<br> <br> <label>Kfz-Kennzeichen</label><br>
			<div class="kennzeichen-wrapper">
				<img class="kennzeichen_img" alt="Kennzeichen"
					src="/carSharing/html/img/kennzeichen.jpg"> <span id="span1">
					<input type="text" name="kennzeichen_1" id="kennzeichen_1"
					placeholder="HH" maxlength="3">
				</span> <span id="span2"> <input type="text" name="kennzeichen_2"
					id="kennzeichen_2" placeholder="XX" maxlength="2" required>
				</span> <span id="span3"> <input type="int" name="kennzeichen_3"
					id="kennzeichen_3" placeholder="1234" maxlength="4" required>
				</span>
			</div>

			<div class="formular-wrapper">
				<ul class="formular_ul">
					<li class="formular_li"><label>Automarke</label> <br> <select
						id="marke">
							<c:forEach items="${hersteller}" var="item">
								<option value="${item}">${item}</option>
							</c:forEach>
					</select></li>

					<li class="formular_li"><label for="modell">Modell</label><br>
						<input type="text" name="modell" id="modell"
						placeholder="z.B. Astra" size="30" maxlength="30" required></li>
					<ul>
			</div>
			<br>
			<div class="formular-wrapper">
				<ul class="formular_ul">
					<li class="formular_li"><label for="baujahr">Baujahr</label><br>
						<input type="int" name="baujahr" id="baujahr"
						placeholder="z.B. 2012" size="10" maxlength="4" required></li>
					<li class="formular_li"><label for="laufleistung">Laufleistung
							in km</label><br> <input type="int" name="laufleistung"
						id="laufleistung" placeholder="z.B. 148000" size="20"
						maxlength="6" required></li>
				</ul>
			</div>

			<br> <br>

			<div class="formular-wrapper">
				<h2>Leistung</h2>
			</div>

			<div class="formular-wrapper">
				<ul class="formular_ul">
					<li class="formular_li"><label for="ps">PS</label><br> <input
						type="int" name="leistung" id="leistung" placeholder="z.B. 122"
						size="10" maxlength="3" required></li>
					<li class="formular_li"><label>Kraftstoff</label><br> <select
						id="kraftstoff" name="kraftstoff">
							<option value="1">Benzin</option>
							<option value="2">Diesel</option>
							<option value="3">Elektro</option>
							<option value="4">Hybrid</option>
							<option value="5">Erdgas</option>
							<option value="6">sonstige</option>
					</select></li>
			</div>

			<div class="formular-wrapper">
				<h2>Ausstattung</h2>
			</div>

			<div class="formular-wrapper">
				<ul class="formular_ul">
					<li class="formular_li">
					<c:forEach items="${ausstattungen}" var="ausstattung">
							<label class="container">${ausstattung.name } <input type="checkbox" value="${ausstattung.id }"> <span
							class="checkmark"></span></label>
					</c:forEach>	
						</li>	
				</ul>
				
					
					<div style="float:left;">
						<label>Farbe des Fahrzeugs</label> <br>
							<select id="farbe" name="farbe">
								<option value="1">Grau</option>
								<option value="2">Rot</option>
								<option value="3">Schwarz</option>
								<option value="4">Weiß</option>
								<option value="5">sonstiges</option>
						
						</select> <br> <br> <label>Anzahl der Sitzplätze
								(inklusive Fahrersitz)</label> <br> <select id="sitzplaetze" name="sitzplaetze">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
	
						</select>
					</div>
					<div style="clear:both"></div>
			</div>

			<div class="formular-wrapper">
				<h2>Fotos</h2>
			</div>

			<div class="formular-wrapper">
				<label>Fügen Sie Bilder Ihres Fahrzeugs hinzu, um die
					Attraktivität Ihrer Anzeige zu erhöhen</label> <br> <input
					name="fahrzeugbild" type="file" size="50" accept="image/*">
				</label>
			</div>

			<div class="formular-wrapper">
				<h2>Fahrzeugschein</h2>
			</div>

			<div class="formular-wrapper">
				<label>Laden Sie bitte ein Bild Ihres Fahrzeugscheins
					(Zulassungsbescheinigung Teil I) hoch</label> <br> <input name="datei"
					type="file" size="50" accept="image/*">
			</div>

			<div class="formular-wrapper">
				<h2>Preis und Konditionen</h2>
			</div>

			<div class="formular-wrapper">
				<p>Hier kannst du eingeben, wie viel dein Fahrzeug pro Tag
					kostet. Pro Tag sind 100 Kilometer frei. Du kannst angeben, wie
					viel jeder zusätzliche Kilometer kostet.</p>
			</div>

			<div class="formular-wrapper">

				<label>Tagespreis</label>
				<br>
				<input type="text" name="tagesPreisInput" id="tagesPreisInput" placeholder="5,30" size ="5" required> <label>€</label>

<!-- 				<div class="slidecontainer">
					<input type="range" min="1" max="100" value="12" class="slider"
						id="tagespreis_range">
				</div>
				
				<span>Tagespreis:</span> <span id="tp_span"></span> <span>€</span>

				<script>
					var slider = document.getElementById("tagespreis_range");
					var outputTagespreis = document.getElementById("tp_span");
					outputTagespreis.innerHTML = slider.value; // Display the default slider value

					// Update the current slider value (each time you drag the slider handle)
					slider.oninput = function() {
						outputTagespreis.innerHTML = this.value;
					}
				</script> -->
				
			</div>
			<br>
			<div class="formular-wrapper">

				<label>Kilometerpreis</label>
				<br>
				<input type="text" name="kilometerPreisInput" id="kilometerPreisInput" placeholder="5,30" size="5" required><label>€</label>

<!-- 				<div class="slidecontainer">
					<input type="range" min="0.00" max="40" value="2.50" step=0.10
						class="slider" id="kilometer_range">
				</div>
				
				<span>Preis pro Kilometer: </span> <span id="kp_span"></span> <span>€</span>

				<script>
					var sliderk = document.getElementById("kilometer_range");
					var outputKilometerpreis = document
							.getElementById("kp_span");
					outputKilometerpreis.innerHTML = sliderk.value; // Display the default slider value

					// Update the current slider value (each time you drag the slider handle)
					sliderk.oninput = function() {
						outputKilometerpreis.innerHTML = this.value;
					}
				</script> -->
			</div>
					
			
			<div class="formular-wrapper">

				<button onclick="jQuery('#upload-form').submit()">Weiter</button>
			</div>
			<input type="hidden" name="userId" value="${nutzer.id}" />
		</form>
	</div>


</body>
<jsp:include page="/theme/html/footer.html" />
</html>