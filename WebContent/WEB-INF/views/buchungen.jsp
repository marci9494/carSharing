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

	</div>



	<c:choose>
		<c:when test="${ userEmail!=null}">
			<div class="logout">
				Herzlich Willkommen ${userEmail } <a href="/carsharing/logout">(Logout)</a>
			</div>
		</c:when>
		<c:otherwise>

		</c:otherwise>
	</c:choose>

	<div class="content-wrapper">
		<div id="header-content">
			<h1 id="header-content-text">Deine Buchungen</h1>
		</div>
		<div>Deine Buchungen</div>
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
						<td>${buchung.fahrzeug.hersteller.name}-
							${buchung.fahrzeug.modell}</td>
						<td>Befüll mich</td>
						<td>${buchung.status}-</td>
						<td><button>Stornieren</button></td>
						<c:if test="${ buchung.status == 'ABGESCHLOSSEN'}">
							<td><a href="/carSharing/bewerten?id=${buchung.id }"><button>Bewerten</button></a></td>
						</c:if>

					</tr>
				</c:forEach>
			<tbody>
		</table>
		<div>Buchungen für dein Fahrzeug</div>
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
						<td>${buchung.fahrzeug.hersteller.name}-
							${buchung.fahrzeug.modell}</td>
						<td>Befüll mich</td>
						<td>${buchung.status}-</td>
						<c:if test="${ buchung.status == 'ANGEFRAGT'}">
							<td><button onclick="buchungFreigeben('${buchung.id }')">Freigeben</button></td>
							<td><button onclick="buchungAblehnen('${buchung.id }')">Ablehnen</button></td>
						</c:if>
						<td><button>Bewerten</button></td>
					</tr>
				</c:forEach>
			<tbody>
		</table>
		<input type="hidden" class="userId" value="${user.id}"/>
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

					});
					window.location = "/carSharing/buchungen"
				}
			} else {
				alert("Bitte melden Sie sich an");
				window.location = "/carSharing/login"
			}
		}
	</script>
</body>
<jsp:include page="/theme/html/footer.html" />

</html>