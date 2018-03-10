<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="/carSharing/html/css/home.css" media="screen" />
<jsp:include page="/theme/html/header.jsp" />

<body>

	<div class="banner-wrapper">
		<img class="banner" alt="Banner" src="/carSharing/html/img/header.jpg">
	</div>
	
	<div id="header-content">
		<h1 id="header-content-text">Herzlich Willkommen</h1>
	</div>
	<div class="content-wrapper">
	<div id=hallo>
	<!--Prüfung ob User eingeloggt ist-->
			<!--Wenn ja: Begrüßung und Logout Option-->
			<!--Wenn nein: nur Begrüßung-->
		<c:choose>
			<c:when test="${ user!=null}">
				<div class="logout">
					Herzlich Willkommen ${user.vorname} ${user.nachname} <a href="/carSharing/logout">(Logout)</a>
				</div>
				<input type="hidden" class="userEmail" value="${userEmail}" />
			</c:when>
			<c:otherwise>
        			Herzlich Willkommen
    			</c:otherwise>
		</c:choose>
	</div>
	<br>
		<p>Autos privat, sicher und schnell zur Miete anzubieten und unterschiedlichen Menschen mit unterschiedlichsten Autos eine Plattform für die Vermietung zu bieten, das ist schon seit 2018 unser Ziel.</p>
		<br><br><br>
		<div class="search-overlay">
			Jetzt Autos in der Nähe finden<br> <input type="text"
				class="plzInput" /> <select class="distanceSelect">
				<option value="10">10Km</option>
				<option value="20">20Km</option>
			</select> <span>Von</span><input class="startDate" type="date" /> <span>Bis</span><input
				class="endDate" type="date" />
			<button type="button" onclick="searchCar(null,null)">Suchen</button>
		</div>

		<div class="filter-wrapper">
			<div class="filters">
				<div class="fahrzeugfilter fahrzeugkategorie">
					<b>Kategorie</b><br>
					<c:forEach items="${kategories}" var="kategorie">
						<a onclick="searchCar('kategorie','${kategorie.id }')">${kategorie.name }</a>
						</br>
					</c:forEach>
				</div>
				<div class="fahrzeugfilter fahrzeugfarbe">
					<b>Farbe</b><br>
					<c:forEach items="${farben}" var="farbe">
						<a>${farbe.name }</a>
						<br>
					</c:forEach>
				</div>
				<div class="fahrzeugfilter fahrzeugausstattung">
					<b>Ausstattung</b><br>
					<c:forEach items="${ausstattungen}" var="ausstattung">
						<a>${ausstattung.name }</a>
						<br>
					</c:forEach>
				</div>

			</div>

		</div>
		<div class="foundCars"></div>
		<div style="clear: both;"></div>


		<div id="dummyCarWrapper" class="carWrapper" style="display: none">
			<div class="carPicture">
				<img alt="" src="" class="carImg">
			</div>
			<div class="carDetails">
				<div class="bezeichnung">
					<span class="herstellerBezeichnung"></span><span
						class="modellBezeichnung"></span>
				</div>
				<div class="distanceWrapper">
					<span class="standort"></span> - <span class="entfernung"></span><span>Km</span>
				</div>
			</div>
			<div style="float: right; margin-right: 10px;">
				<button type="button" onclick="rentCar(this)">Mieten</button>
				<input type="hidden" class="carId" />
			</div>
			<div style="clear: both"></div>

		</div>
	</div>
</body>
<jsp:include page="/theme/html/footer.html" />

<script src="/carSharing/html/js/home.js"></script>

<script>
	function searchCar(filterType, filterId) {
		console.log("SearchCar!!")
		var plz = jQuery('.plzInput').val();
		var distance = jQuery('.distanceSelect').val();
		var startDate = jQuery('.startDate').val();
		var endDate = jQuery('.endDate').val();

		jQuery.post("home", {
			action : "searchCar",
			plz : plz,
			distance : distance,
			startDate : startDate,
			endDate : endDate,
			filterType : filterType,
			filterId : filterId
		}, function(data, status) {
			for (var i = 0; i < data.length; i++) {
				for (var r = 0; r < data[i].fahrzeug.length; r++) {
					var carWrapper = jQuery('#dummyCarWrapper').clone();
					carWrapper.removeAttr('id');
					carWrapper.find('.modellBezeichnung').text(
							data[i].fahrzeug[r].modell);
					carWrapper.find('.standort').text(data[i].ort);
					carWrapper.find('.entfernung').text(data[i].distance);
					carWrapper.find('.carImg').attr(
							'src',
							'data:image/png;base64,'
									+ data[i].fahrzeug[r].fahrzeugBildString);
					carWrapper.find('.carId').val(data[i].fahrzeug[r].id);
					carWrapper.show();
					jQuery('.foundCars').append(carWrapper);

					carWrapper.find('')

				}
			}
			jQuery('.filters').show();
			jQuery('.foundCars').append(jQuery('<div>').css('clear', 'both'));

		});
	}

	function rentCar(button) {
		var carId = jQuery(button).parent().find('.carId').val();
		var userEmail = jQuery('.userEmail').val();
		if (userEmail) {

			var abfrage = confirm("Wollen Sie das Fahrzeug wirklich zur miete anfragen?");
			if (abfrage == true) {
				//TODO statische variablen ersetzen!!!!!
				var startDate = jQuery('.startDate').val();
				var endDate = jQuery('.endDate').val();

				jQuery.post("home", {
					action : "rentCar",
					carId : carId,
					userEmail : userEmail,
					startDate : startDate,
					endDate : endDate
				}, function(data, status) {

				});
				window.location = "/carSharing/buchungen"
			}
		}else{
			alert("Bitte melden Sie sich an");
			window.location = "/carSharing/login"
		}
	}
</script>


</html>
