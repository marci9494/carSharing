<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="/carSharing/html/css/profil.css" media="screen" />
<jsp:include page="/theme/html/header.jsp" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<style>
<
jsp
:include
 
page
 
="/
html
/css/profil
.css
"/
>
</style>

<link rel="shortcut icon" href="/carSharing/theme/img/tablogo.png">
<link rel="icon" href='/carSharing/theme/img/tablogo.png'>



<body>
	<div class="banner-wrapper">
		<img class="banner" alt="Banner" src="/carSharing/html/img/header.jpg">
		<div id="header-content">
			<h1 id="header-content-text">Profil</h1>
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

		<p>Hier findest du alle wichtigen Infos rund um deinen Account.
			Stell sicher, dass deine Angaben immer auf dem neusten Stand sind,
			damit deiner Nutzung von carNow nichts im Wege steht. Solltest du
			Fragen haben, melde dich gern bei uns.</p>
		<form method="post" action="profil" id="update-form"
			accept-charset="ISO-8859-1">
			<div id="name-adress" class="name-adress">
				<h2>Persönliche Daten</h2>


				<br> <span class="form-field-label">Anrede</span> <br>
				<p style='margin-left: 25px'>${user.anrede}</p>
				<br> <span class="form-field-label">Vorname</span> <br>
				<p class="editable" id=daten>${user.vorname}</p>
				<input id="vorname" class="editableInput" type='text'
					style='display: none' name="vorname" value="${user.vorname}" /> <br>
				<span class="form-field-label"> Nachname</span> <br>
				<p class="editable" id=daten>${user.nachname}</p>
				<input id="nachname" class="editableInput" type='text'
					style='display: none' name="nachname" value="${user.nachname}" />
				<br> <span class="form-field-label">Ort</span> <br>
				<p class="editable" id=daten>${user.ort}</p>
				<input id="ort" class="editableInput" type='text'
					style='display: none' name="ort" value="${user.ort}" /> <br>
				<span class="form-field-label">PLZ</span> <br>
				<p class="editable" id=daten>${user.plz}</p>
				<input id="plz" class="editableInput" type='text'
					style='display: none' name="plz" value="${user.plz}" /> <br>
				<span class="form-field-label">Straße</span> <br>
				<p class="editable" id=daten>${user.strasse}</p>
				<input id="strasse" name="strasse" class="editableInput" type='text'
					style='display: none' value="${user.strasse}" /> <br> <span
					class="form-field-label">Hausnummer</span> <br>
				<p class="editable" id=daten>${user.hausnummer}</p>
				<input id="hausnummer" name="hausnummer" class="editableInput"
					type='text' style='display: none' value="${user.hausnummer}" /> <br>
				<span class="form-field-label">E-Mail-Adresse</span> <br>
				<p class="editable" id=daten>${user.email}</p>
				<input id="emailAdresse" name="email" class="editableInput"
					type='text' style='display: none' value="${user.email}" /> <br>
				<br>
			</div>


			<br> <br>
			<h2>Kreditkarteninformationen</h2>
			<span class="form-field-label">Kartennummer</span> <br>
			<p class="editable" id=daten>${kreditkarte.kartennummer}</p>
			<input id="kartennummer" name="kartennummer" class="editableInput"
				type='text' style='display: none'
				value="${kreditkarte.kartennummer}" /> <span
				class="form-field-label">Gültig bis</span> <br>
			<p class="editable" id=daten>${kreditkarte.valid}</p>
			<input id="valid" name="valid" class="editableInput" type='text'
				style='display: none' value="${kreditkarte.valid}" /> <span
				class="form-field-label">Karteninhaber</span> <br>
			<p class="editable" id=daten>${kreditkarte.inhaber}</p>
			<input id="karteninhaber" name="karteninhaber" class="editableInput"
				type='text' style='display: none' value="${kreditkarte.inhaber}" />
			<br> <br> <br> <br>
			<div class="form-group" id="credit_cards">
				<img src="/carSharing/html/img/visa.jpg" id="visa"> <img
					src="/carSharing/html/img/mastercard.jpg" id="mastercard"> <img
					src="/carSharing/html/img/amex.jpg" id="amex">
			</div>
			<br> <br> <input type="hidden" name="userId"
				value="${user.id}" /> <input type="submit" style="display: none;"
				id="save-button" value="Speichern" />
		</form>
		<button onclick="edit()" id="edit-button">Ändern</button>

		<br> <br> <br> <br>


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
</script>



</html>
