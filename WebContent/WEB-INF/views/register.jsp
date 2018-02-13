<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="/carSharing/html/css/register.css" media="screen" />

<jsp:include page="/theme/html/header.html" />


<body>

	<div class="banner-wrapper">
		<img class="banner" alt="Banner"
		src="/carSharing/html/img/header.jpg">

	</div>
	
			<div id="header-content" >
				<h1 id="header-content-text">Registrierung</h1>
			</div>

		<h2>Logindaten</h2>

		<div class="wrapper">
			<label for="email">Email</label> <input type="email" name="email"
				id="email" placeholder="Geben Sie bitte Ihre Email an" size="30"
				maxlength="30" required>
		</div>

		<div class="wrapper">
			<label for="passwort">Passwort</label> <input type="password"
				name="passwort" id="passwort"
				placeholder="Bitte geben Sie ein Passwort ein" size="30"
				maxlength="30" required> <label for="passwort">Passwort
				bestätigen</label> <input type="password" name="passwort"
				id="confirm_passwort"
				placeholder="Bitte bestätigen Sie Ihr Passwort" size="30"
				maxlength="30" required>
		</div>


		<br>
		<div class="wrapper">
			<h2>Persönliche Daten</h2>
		</div>

		<div class="wrapper">
			<label>Anrede: <select name="anrede">
					<option>Frau</option>
					<option>Herr</option>
			</select>
		</div>

		<div class="wrapper">
			<label for="vorname">Vorname</label> <input type="text"
				name="vorname" id="vorname" placeholder="Ihr Vorname" size="30"
				maxlength="30"> <label for="nachname">Nachname</label> <input
				type="text" name="nachname" id="nachname" placeholder="Ihr Nachname"
				size="30" maxlength="30">
		</div>

		<div class="wrapper">
			<label class="strass" for="strasse">Straße</label> <input type="text"
				name="strasse" id="strasse" placeholder="Ihre Straße" size="40"
				maxlength="30"> <label for="hausnummer">Hausnummer</label> <input
				type="text" name="hausnummer" id="hausnummer"
				placeholder="Ihre Hausnummer" size="6" maxlength="8">
		</div>

		<div class="wrapper">
			<label for="postleitzahl">Postleitzahl</label> <input type="text"
				name="postleitzahl" id="postleitzahl"
				placeholder="Ihre Postleitzahl" size="5" maxlength="30"> <label
				for="stadt">Stadt</label> <input type="text" name="stadt" id="stadt"
				placeholder="Ihr Wohnort" size="30" maxlength="8">
		</div>

		<div class="wrapper">
			<label for="land">Land</label> <input type="text" name="land"
				id="land" value="Deutschland" size="30" maxlength="8">
		</div>

		<div class="wrapper">
			<label for="geburtsdatum">Geburtsdatum</label> <input type="date"
				name="geburtsdatum" id="geburtsdatum" size="30">
		</div>
		<br> <br>

		<div class="wrapper">
			<label>Bild oder Scan Ihres Personalausweis <input
				name="datei" type="file" size="50" accept="text/*">
			</label>
		</div>
		<br>
		<div class="wrapper">
			<label>Bild oder Scan Ihres Führerscheins <input name="datei"
				type="file" size="50" accept="text/*">
			</label>
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

				console.log(passwort);
				jQuery.post("register", {
					email : email,
					vorname : vorname,
					nachname : nachname,
					strasse : strasse,
					postleitzahl : postleitzahl,
					stadt : stadt,
					passwort : passwort
				}, function(data, status) {
					if(data){
						window.location.href = "home";
					}
				});
			}
		</script>

		<div class="submit">
			<button class="send_reg"  onclick="register()">Weiter</button>
		</div>
</body>
<jsp:include page="/theme/html/footer.html" />

</html>