<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="/carSharing/html/css/cars_detail.css" media="screen" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<jsp:include page="/theme/html/header.jsp" />

<body>
	<div class="banner-wrapper">
		<img class="banner" alt="Banner" src="/carSharing/html/img/header.jpg">
		<div id="header-content">
			<h1 id="header-content-text">Meine CarNow Fahrzeuge</h1>
		</div>
	</div>



	<div class="content-wrapper">
		<div id=hallo>
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

		<p>Hier findest du alle wichtigen Infos rund um dein zum Mieten
			freigegebenen Fahrzeuge. Stell sicher, dass die Angaben zum Fahrzeug
			immer auf dem neusten Stand sind, damit deiner Nutzung von carNow
			nichts im Wege steht. Solltest du Fragen haben, melde dich gern bei
			uns.</p>
		<div id="name-adress" class="name-adress">
			<h2>Fahrzeuge</h2>


			<br> <span class="form-field-label">Marke</span> <br>
			<p>
				<c:out value="${fahrzeug.hersteller.name}" />
			</p>
			<input id="marke" type='text' style='display: none' name="marke"
				value="${fahrzeug.hersteller.name}" /> <br> <span
				class="form-field-label"> Modell</span> <br>
			<p>
				<c:out value="${fahrzeug.modell}" />
			</p>
			<br> <span class="form-field-label">Farbe</span> <br>
			<p>
				<c:out value="${fahrzeug.farbe.name}" />
			</p>
			<br> <span class="form-field-label">Sitzplätze</span> <br>
			<p>
				<c:out value="${fahrzeug.sitzplaetze}" />
			</p>
			<br> <span class="form-field-label">Leistung</span> <br>
			<p>
				<c:out value="${fahrzeug.leistung}" />
			</p>
			<br>
		</div>


		<br> <span class="form-field-label">Tagespreis </span><br> <input
			type="text" name="tagespreis" id="tagespreis"
			placeholder="${fahrzeug.tagespreis}" value="${fahrzeug.tagespreis}"
			size="5" required> <label>€</label>
		<p id="daten">Aktuell: ${fahrzeug.tagespreis}€</p>


		<button onclick="update('${fahrzeug.id}')" id="save-button">Speichern</button>
		<br> <br> <br> <br>

		<div id="vermieten">
			<h2>Vermietungs&shyzeitraum</h2>
			<p>
				Gib hier den Zeitraum an, in dem du dein Auto anderen Nutzern zur
				Verfügung stellen willst. <br>
				<c:forEach items="${fahrzeug.vermietZeitraeume}"
					var="vermietZeitraum" varStatus="loop">
					<div class="vermietzeitraum">
						<label><input class="startDate" type="date"
							value="${vermietZeitraum.startDate }" /></label> - <label> <input
							class="endDate" type="date" value="${vermietZeitraum.endDate }" />
						</label>
						<c:if test="${loop.last}">
							<button class="addVermietzeitraum" onclick="addVermietZeitraum()">
								<i class="material-icons">add</i>
							</button>

						</c:if>
						<button
							onclick="deleteVermietZeitraum('${vermietZeitraum.id }');addVermietZeitraum();jQuery(this).parent().remove();addVermietZeitraum();">
							<i class="material-icons">delete</i>
						</button>
					</div>
				</c:forEach>
				<c:if test="${empty fahrzeug.vermietZeitraeume}">
					<div class="vermietzeitraum">
						<label><input class="startDate" type="date" /></label> - <label>
							<input class="endDate" type="date" />
						</label>
						<button class="addVermietzeitraum" onclick="addVermietZeitraum()">
							<i class="material-icons">add</i>
						</button>


					</div>
				</c:if>
				<button onclick="saveVermietzeitraum('${fahrzeug.id}')">
					Auto vermieten</button>


			</p>
		</div>
	</div>

	<div class="cloneVermietZeitraum" style="display: none;">
		<label><input class="startDate" type="date" /></label> - <label>
			<input class="endDate" type="date" />
		</label>
		<button class="addVermietzeitraum" onclick="addVermietZeitraum()">
			<i class="material-icons">add</i>
		</button>
		<button onclick="jQuery(this).parent().remove()">
			<i class="material-icons">delete</i>
		</button>

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

	function deleteVermietZeitraum(id) {

		jQuery.post("cars_detail", {
			action : "delete",
			id : id
		}, function(data, status) {

		});
	}

	function update(carId) {

		var tagespreis = jQuery('#tagespreis').val();
		var kilometerpreis = jQuery('#kilometerpreis').val();

		jQuery.post("cars_detail", {
			action : "update",
			tagespreis : tagespreis,
			kilometerpreis : kilometerpreis,
			carId : carId
		}, function(data, status) {
			if (data) {
				window.location.href = "/carSharing/cars";
			} else {
				//POPUP anzeigen, email bereits vergeben
			}
		});
	}

	function addVermietZeitraum() {
		jQuery('#vermieten').find('.addVermietzeitraum').remove();
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
			alert("Vermietzeitraeume wurden gespeichert");
		});
	}
</script>

</html>
