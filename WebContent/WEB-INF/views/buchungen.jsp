<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="/carSharing/html/css/login.css" media="screen" />
<jsp:include page="/theme/html/header.jsp" />

<body>
<head>
<style>
table {
	overflow: hidden;
	text-align: center;
}

td, th {
	padding: 10px;
	outline: 0;
}
</style>



</head>


<body>
	<div class="banner-wrapper">
		<img class="banner" alt="Banner" src="/carSharing/html/img/header.jpg">
		<div id="header-content">
			<h1 id="header-content-text">Deine Buchungen</h1>
		</div>
	</div>




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
		<p>Hier kannst du deine Mietungen und Vermietungen einsehen, Autos
			zurückgeben und deine Buchung bewerten. Stelle immer sicher, dass
			deine Autos im richtigen Status stehen.</p>
		<br>
		<br>
		<h2>Deine Buchungen</h2>
		<table>
			<thead>
				<tr>
					<th></th>
					<th class="col">Start Datum</th>
					<th class="col">End Datum</th>
					<th class="col">Fahrzeug</th>
					<th class="col">Preis</th>
					<th class="col">Status</th>
					<th class="col"></th>
					<th class="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${myBuchungen}" var="buchung">
					<tr>
						<th class="row">Buchungsnummer ${buchung.id }</th>
						<td><fmt:formatDate pattern="dd.MM.yyyy"
								value="${buchung.startDatum }" /></td>
						<td><fmt:formatDate pattern="dd.MM.yyyy"
								value="${buchung.endDatum }" /></td>
						<td><c:out value="${buchung.fahrzeug.hersteller.name}" />- <c:out
								value="${buchung.fahrzeug.modell}" /></td>
						<td><c:out value="${buchung.price}" /> €</td>
						<td><c:out value="${buchung.status}" /></td>
						<c:if
							test="${ buchung.status != 'ABGESCHLOSSEN' && buchung.status != 'STORNIERT' && buchung.status != 'BEWERTET'  && buchung.status != 'ABGEHOLT'  }">
							<td><button onclick="buchungStornieren('${buchung.id }')">Stornieren</button></td>
						</c:if>
						<c:if
							test="${ buchung.status == 'ABGESCHLOSSEN' && buchung.status != 'BEWERTET' }">
							<td><a href="/carSharing/bewerten?id=${buchung.id }"><button>Bewerten</button></a></td>
						</c:if>
					</tr>
				</c:forEach>
			<tbody>
		</table>
		<br>
		<h2>Buchungen für dein Fahrzeug</h2>
		<table>
			<thead>
				<tr>
					<th></th>
					<th class="col">Start Datum</th>
					<th class="col">End Datum</th>
					<th class="col">Fahrzeug</th>
					<th class="col">Preis</th>
					<th class="col">Status</th>
					<th class="col"></th>
					<th class="col"></th>
					<th class="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${carsBuchungen}" var="buchung">
					<tr>
						<th class="row">Buchungsnummer ${buchung.id }</th>
						<td><fmt:formatDate pattern="dd.MM.yyyy"
								value="${buchung.startDatum }" /></td>
						<td><fmt:formatDate pattern="dd.MM.yyyy"
								value="${buchung.endDatum }" /></td>
						<td><c:out value="${buchung.fahrzeug.hersteller.name}" />- <c:out
								value="${buchung.fahrzeug.modell}" /></td>
						<td><c:out value="${buchung.price}" /> €</td>
						<td><c:out value="${buchung.status}" /></td>
						<c:if test="${ buchung.status == 'ANGEFRAGT'}">
							<td><button onclick="buchungFreigeben('${buchung.id }')">Freigeben</button></td>
							<td><button onclick="buchungStornieren('${buchung.id }')">Ablehnen</button></td>
						</c:if>
						<c:if test="${ buchung.status == 'FREIGEGEBEN'}">
							<td><button onclick="buchungAbgeholt('${buchung.id }')">Fahrzeug
									abgeholt</button></td>
						</c:if>
						<c:if test="${ buchung.status == 'ABGEHOLT'}">
							<td><a href="/carSharing/return_car?id=${buchung.id }"><button>Fahrzeugrückgabe</button></a></td>
						</c:if>
					</tr>
				</c:forEach>
			<tbody>
		</table>
		<input type="hidden" class="userId" value="${user.id}" />
	</div>
	<script>
		function buchungFreigeben(buchungId) {
			var abfrage = confirm("Wollen Sie das Fahrzeug wirklich zur miete freigeben?");
			if (abfrage == true) {
				var userId = jQuery('.userId').val();

				jQuery.post("buchungen", {
					action : "buchungFreigeben",
					buchungId : buchungId,
					userId : userId
				}, function(data, status) {
					location.reload();
				});

			} else {
				alert("Bitte melden Sie sich an");
				window.location = "/carSharing/login"
			}
		}
		function buchungAbgeholt(buchungId) {
			var abfrage = confirm("Wurde das Fahrzeug vom Mieter abgeholt?");
			if (abfrage == true) {
				var userId = jQuery('.userId').val();

				jQuery.post("buchungen", {
					action : "buchungAbgeholt",
					buchungId : buchungId,
					userId : userId
				}, function(data, status) {
					location.reload();
				});

			} else {
				alert("Bitte melden Sie sich an");
				window.location = "/carSharing/login"
			}
		}

		function buchungStornieren(buchungId) {
			var abfrage = confirm("Wollen Sie die Buchung wirklich stornieren?");
			if (abfrage == true) {
				var userId = jQuery('.userId').val();
				jQuery.post("buchungen", {
					action : "buchungStornieren",
					buchungId : buchungId,
					userId : userId
				}, function(data, status) {
					location.reload();
				});
			}

		}
	</script>
	</div>
</body>
<jsp:include page="/theme/html/footer.html" />

</html>