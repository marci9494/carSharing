<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="/carSharing/html/css/cars_detail.css" media="screen" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<jsp:include page="/theme/html/header.jsp" />

<body>
	<div class="banner-wrapper">
		<img class="banner" alt="Banner" src="/carSharing/html/img/header.jpg">

	</div>

	<div id="header-content">
		<h1 id="header-content-text">Meine CarNow Fahrzeuge</h1>
	</div>
	
<div class="content-wrapper">
	<div id=hallo>
		<c:choose>
			<c:when test="${ user!=null}">
				<div class="logout">
					Herzlich Willkommen ${user.vorname} ${user.nachname} <a href="/carsharing/logout">(Logout)</a>
				</div>
				<input type="hidden" class="userEmail" value="${userEmail}" />
			</c:when>
			<c:otherwise>
        			Herzlich Willkommen
    			</c:otherwise>
		</c:choose>
	</div>

		<p>Hier findest du alle wichtigen Infos rund um dein zum Mieten
			freigegebenen Fahrzeuge. Stell sicher, dass die Angaben zum Fahrzeug
			immer auf dem neusten Stand sind, damit deiner Nutzung von carNow
			nichts im Wege steht. Solltest du Fragen haben, melde dich gern bei
			uns.</p>
		<div id="name-adress" class="name-adress">
			<h2>Fahrzeuge</h2>


			<br> <span class="form-field-label">Marke</span> <br>
			<p class="editable" id=daten>${fahrzeug.hersteller.name}</p>
			<input id="marke" class="editableInput" type='text'
				style='display: none' name="marke"
				value="${fahrzeug.hersteller.name}" /> <br> <span
				class="form-field-label"> Modell</span> <br>
			<p class="editable" id=daten>${fahrzeug.modell}</p>
			<input id="modell" class="editableInput" type='text'
				style='display: none' name="modell" value="${fahrzeug.modell}" /> <br>
			<span class="form-field-label">Farbe</span> <br>
			<p class="editable" id=daten>${fahrzeug.farbe.name}</p>
			<input id="farbe" class="editableInput" type='text'
				style='display: none' name="ort" value="${fahrzeug.farbe.name}" />
			<br> <span class="form-field-label">Sitzplätze</span> <br>
			<p class="editable" id=daten>${fahrzeug.sitzplaetze}</p>
			<input id="sitzplaetze" class="editableInput" type='text'
				style='display: none' name="sitzplaetze"
				value="${fahrzeug.sitzplaetze}" /> <br> <span
				class="form-field-label">Leistung</span> <br>
			<p class="editable" id=daten>${fahrzeug.leistung}</p>
			<input id="leistung" name="leistung" class="editableInput"
				type='text' style='display: none' value="${fahrzeug.leistung}" /> <br>
		</div>


		<br> <span class="form-field-label">Tagespreis </span><br>
		<p id="daten">Aktuell: ${fahrzeug.tagespreis}€</p>

		<div class="slidecontainer">
			<input type="range" min="1" max="100" value="12" class="slider"
				id="basispreis_range">
		</div>


		<span>Neuer Startpreis: </span> <span id="basispreis"></span> <span>€</span>

		<script>
			var slider = document.getElementById("basispreis_range");
			var output = document.getElementById("basispreis");
			output.innerHTML = slider.value; // Display the default slider value

			// Update the current slider value (each time you drag the slider handle)
			slider.oninput = function() {
				output.innerHTML = this.value;
			}
		</script>

		<br> <br> <span class="form-field-label">Kilometerpreis
		</span><br>
		<p id="daten">Aktuell: ${fahrzeug.kilometerpreis}€</p>
		<div class="slidecontainer">
			<input type="range" min="0.00" max="40" value="2.50" step=0.10
				class="slider" id="kilometer_range">
		</div>


		<span> Neuer Preis pro Kilometer: </span> <span id="kilometerpreis"></span>
		<span>€</span>

		<script>
			var sliderk = document.getElementById("kilometer_range");
			var outputk = document.getElementById("kilometerpreis");
			outputk.innerHTML = sliderk.value; // Display the default slider value

			// Update the current slider value (each time you drag the slider handle)
			sliderk.oninput = function() {
				outputk.innerHTML = this.value;
			}
		</script>
		<br> <br> <br>

	<button onclick="edit()" id="edit-button">Ändern</button>

	<button onclick="jQuery('#update-form').submit()"
		style="display: none;" id="save-button">Speichern</button>
	<br>
	<br>
	<br>
	<br>
	<div id="vermieten">
		<h2>Vermietungs&shyzeitraum</h2>
		<p>
			Gib hier den Zeitraum an, in dem du dein Auto anderen Nutzern zur
			Verfügung stellen willst. <br>
			<c:forEach items="${fahrzeug.vermietZeitraeume}" var="vermietZeitraum">
				<div class="vermietzeitraum">
					<label><input class="startDate" type="date" value="${vermietZeitraum.startDate }"/></label> - <label>
						<input class="endDate" type="date" value="${vermietZeitraum.endDate }"/>
					</label> <a onclick="addVermietZeitraum()">Zusaetzlicher
						vermietzeitraum</a><a onclick="deleteVermietZeitraum('${vermietZeitraum.id }')">Loeschen</a>

				</div>
			</c:forEach>
			 <c:if test = "${empty fahrzeug.vermietZeitraeume}">>
			 				<div class="vermietzeitraum">
					<label><input class="startDate" type="date" /></label> - <label>
						<input class="endDate" type="date" />
					</label> <button onclick="addVermietZeitraum()"> <i class="material-icons">add</i>  </button>
					<br>
					
				</div>
			 </c:if>
			<button onclick="saveVermietzeitraum('${fahrzeug.id}')">Auto
				vermieten</button>
				
			<br> <br>
		</p>
	</div>
	</div>
	</div>
	
	<div class="cloneVermietZeitraum" style="display: none;">
		<label><input class="startDate" type="date" /></label> - <label>
			<input class="endDate" type="date" />
		</label> <button onclick="addVermietZeitraum()"> <i class="material-icons">add</i>  </button>
		<br>
		<br>
	</div>

</body>
<jsp:include page="/theme/html/footer.html" />


<script type="text/javascript">
	function edit() {
		jQuery('#save-button').show();
		jQuery('#edit-button').hide();
		jQuery('.editableInput').show();
		jQuery('.editable').hide()
	}

	function update() {

		var marke = jQuery('#marke').val();
		var modell = jQuery('#modell').val();
		var farbe = jQuery('#farbe').val();
		var sitzplaetze = jQuery('#sitzplaetze').val();
		var leistung = jQuery('#leistung').val();

		console.log(passwort);
		jQuery.post("update", {
			marke : marke,
			modell : modell,
			farbe : farbe,
			sitzplatze : sitzplatze,
			leistung : leistung,
		}, function(data, status) {
			if (data) {
				window.location.href = "'/carSharing/cars';";
			} else {
				//POPUP anzeigen, email bereits vergeben
			}
		});
	}

	function addVermietZeitraum() {
		var div = jQuery(".cloneVermietZeitraum").clone();
		div.removeClass("cloneVermietZeitraum");
		div.addClass('vermietzeitraum');
		jQuery('.vermietzeitraum').last().after(div);
		div.show();

	}

	function saveVermietzeitraum(carId) {
		var vermietZeitraeume = [];
		jQuery('.vermietzeitraum').each(function(index) {
			console.log("schleife!!!")
			var vermietzeitraum = {
				startDate : jQuery(this).find('.startDate').val(),
				endDate : jQuery(this).find('.endDate').val()
			}
			vermietZeitraeume.push(vermietzeitraum);
		});
		console.log(JSON.stringify(vermietZeitraeume));
		console.log(jQuery().serialize(vermietZeitraeume));
		jQuery.post("cars_detail", {
			action : "saveVermietzeitraum",
			carId : carId,
			vermietZeitraeume : JSON.stringify(vermietZeitraeume)
		}, function(data, status) {

			aler("Vermietzeiträume gespeichert")

		});
	}
</script>

</html>
