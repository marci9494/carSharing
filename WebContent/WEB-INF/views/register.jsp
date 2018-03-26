<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<link rel="stylesheet" type="text/css"
	href="/carSharing/html/css/register.css" media="screen" />

<jsp:include page="/theme/html/header.jsp" />

<body>

	<div class="banner-wrapper">
		<img class="banner" alt="Banner" src="/carSharing/html/img/header.jpg">
		<div id="header-content">
			<h1 id="header-content-text">Registrierung</h1>
		</div>
	</div>



	<div class="content-wrapper">

		<h2>Logindaten</h2>
		<form action="register" method="post" id="upload-form"
			enctype="multipart/form-data" accept-charset="ISO-8859-1">
			<div class="formular-wrapper">
				<label for="email">Email</label> <br> <input type="email"
					name="email" id="email" placeholder="Geben Sie bitte Ihre Email an"
					size="30" maxlength="30" required>
			</div>
			<div class="formular-wrapper">
				<ul class="formular_ul">
					<li class="formular_li"><label for="passwort">Passwort</label>
						<br> <input type="password" name="passwort" id="passwort"
						placeholder="Bitte geben Sie ein Passwort ein" size="30"
						maxlength="30" required></li>

					<li class="formular_li"><label for="passwort">Passwort
							bestätigen</label> <br> <input type="password"
						name="confirm_passwort" id="confirm_passwort"
						placeholder="Bitte bestätigen Sie Ihr Passwort" size="30"
						maxlength="30" required></li>
				</ul>
			</div>

			<br> <br>
			<div class="formular-wrapper">
				<h2>Persönliche Daten</h2>
			</div>

			<div class="formular-wrapper">
				<label>Anrede: </label> <br> <select name="anrede">
					<option value="0">Frau</option>
					<option value="1">Herr</option>
				</select>
			</div>

			<div class="formular-wrapper">
				<ul class="formular_ul">
					<li class="formular_li"><label for="vorname">Vorname</label> <br>
						<input type="text" name="vorname" id="vorname"
						placeholder="Ihr Vorname" size="30" maxlength="30"></li>
					<li class="formular_li"><label for="nachname">Nachname</label>
						<br> <input type="text" name="nachname" id="nachname"
						placeholder="Ihr Nachname" size="30" maxlength="30"></li>
				</ul>
			</div>
			<br>
			<div class="formular-wrapper">
				<ul class="formular_ul">
					<li class="formular_li"><label class="strass" for="strasse">Straße</label>
						<br> <input type="text" name="strasse" id="strasse"
						placeholder="Ihre Straße" size="40"></li>
					<li class="formular_li"><label for="hausnummer">Hausnummer</label>
						<br> <input type="text" name="hausnummer" id="hausnummer"
						placeholder="Ihre Hausnummer" size="6" maxlength="8"></li>
				</ul>
			</div>
			<br>
			<div class="formular-wrapper">
				<ul class="formular_ul">
					<li class="formular_li"><label for="postleitzahl">Postleitzahl</label>
						<br> <input type="text" name="postleitzahl" id="postleitzahl"
						placeholder="Ihre PLZ" size="5" maxlength="30"></li>
					<li class="formular_li"><label for="stadt">Stadt</label> <br>
						<input type="text" name="stadt" id="stadt"
						placeholder="Ihr Wohnort" size="30"></li>
				</ul>
			</div>
			<br> <br>
			<div class="formular-wrapper">
				<label for="land">Land</label> <br> <input type="text"
					name="land" id="land" value="Deutschland" size="30">

			</div>
			<br>
			<div class="formular-wrapper">
				<label for="geburtsdatum">Geburtsdatum</label> <br> <input
					type="date" name="geburtsdatum" id="geburtsdatum" size="30">
			</div>
			<br>
			<div class="formular-wrapper">
				<label>Bild oder Scan Ihres Personalausweis (Bild- oder
					PDF-Datei)</label><br> <input name="personalausweis" type="file"
					size="50" accept="image/*,application/pdf"> </label>
			</div>
			<br>

			<div class="formular-wrapper">
				<h2>Kreditkarteninformationen</h2>
			</div>
			<div class="formular-wrapper">
				<ul class="formular_ul">
					<li class="formular_li"><label for="kartennummer">Kreditkartennummer</label>
						<br> <input type="text" name="kartennummer" id="kartennummer"
						placeholder="11122233344555" size="16"></li>
					<li class="formular_li"><label for="valid">Gültig bis</label>
						<br> <input type="text" name="valid" id="valid"
						placeholder="MM/JJ" size="5"></li>
					<li class="formular_li"><label for="karteninhaber">Karteninhaber</label>
						<br> <input type="text" name="karteninhaber"
						id="karteninhaber" placeholder="Vor- und Nachname" size="30">
					</li>
				</ul>
			</div>

			<br> <br>

			<div class="formular-wrapper">
				<input type="submit" value="Registrieren" />
			</div>

		</form>

	</div>
	<script>
		var password = document.getElementById("passwort"), confirm_password = document
				.getElementById("confirm_passwort");

		function validatePassword() {
			if (password.value != confirm_password.value) {
				confirm_password
						.setCustomValidity("Die Passwörter stimmen nicht überein");
			} else {
				confirm_password.setCustomValidity('');
			}
		}

		password.onchange = validatePassword;
		confirm_password.onkeyup = validatePassword;

		function register() {

			var email = jQuery('#email').val();
			var vorname = jQuery('#vorname').val();
			var nachname = jQuery('#nachname').val();
			var strasse = jQuery('#strasse').val();
			var postleitzahl = jQuery('#postleitzahl').val();
			var stadt = jQuery('#stadt').val();
			var passwort = jQuery('#passwort').val();
			var file_data = jQuery('#personalausweis').prop('files')[0];
			var form_data = new FormData();
			var kartennummer = jQuery('#kartennummer').val();
			var valid = jQuery('#valid').val();
			var karteninhaber = jQuery('#karteninhaber').val();
			form_data.append('file', file_data);
			alert(form_data)
			//	jQuery.post("register", {
			//	email : email,
			//	vorname : vorname,
			//	nachname : nachname,
			//	strasse : strasse,
			//	postleitzahl : postleitzahl,
			//	stadt : stadt,
			//	passwort : passwort,
			//	form_data : form_data
			//	}, function(data, status) {
			//		if (data) {
			//			window.location.href = "home";
			//		} else {
			//POPUP anzeigen, email bereits vergeben
			//		}
			//	});

		}
	</script>
</body>


<jsp:include page="/theme/html/footer.html" />



</html>