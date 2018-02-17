<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="/carSharing/html/css/profil.css" media="screen" />
<jsp:include page="/theme/html/header.html" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<style>
<jsp:include page ="/html/css/profil.css"/>
<jsp:include page ="/theme/css/main.css"/>

</style>
<link rel="shortcut icon" href="/carSharing/theme/img/tablogo.png">
<link rel="icon" href='/carSharing/theme/img/tablogo.png'>



<body>
	<div class="banner-wrapper">
		<img class="banner" alt="Banner" src="/carSharing/html/img/header.jpg">

	</div>

	<main> <br>


	<div id="header-content">
		<h1 id="header-content-text">Meine CarNow Accountdetails</h1>
	</div>


	<p>Hier findest du alle wichtigen Infos rund um deinen Account.
		Stell sicher, dass deine Angaben immer auf dem neusten Stand sind,
		damit deiner Nutzung von carNow nichts im Wege steht. Solltest du
		Fragen haben, melde dich gern bei uns.</p>
	<div id="name-adress" class="name-adress">
		<h2>Persönliche Daten</h2>
		<p> Wenn du deine Daten ändern willst, so klicke auf diese und speichere sie zum Schluss </p>
		<span class="form-field-label">Anrede</span> <br>
		<br> //Zugriff auf Anrede auf DB funktioniert nicht? <br>
		<br> <span class="form-field-label">Vorname</span> <br>
		<br>
		<p class="editable">${nutzer.vorname}</p>
		<br>
		<br> <span class="form-field-label"> Nachname</span> <br>
		<br>
		<p class="editable">${nutzer.nachname}</p>
		<br>
		<br> <span class="form-field-label">Adresse</span> <br>
		<br>
		<p class="editable">
			${nutzer.strasse} ${nutzer.plz} ${nutzer.ort}
		</p>
		<br>
		<br> <span class="form-field-label">E-Mail-Adresse</span> <br>
		<br>
		<p class="editable">${nutzer.email}</p>
		<br>
		<br> <span class="form-field-label">Dein Passwort</span> <br>
		<br>
		<p class="editable">${nutzer.password}</p>	
		<br>
		<br>
	</div>
	<button id="button--primary" ">Speichern</button>
	<br>
	<br>
	<br>
	<br>

	</div>
	<br>
	<br>
	<br>
	<h2>Kreditkarteninformationen</h2>
	  <span class="form-field-label">Anbieter</span>
			<br><br><br><br>
			<span class="form-field-label">Kartenummer</span>
			<br><br><br><br>
			<span class="form-field-label">Gültigkeit</span>
			<br><br><br><br>
			<span class="form-field-label">Prüfziffer</span>
			 <br><br><br><br>
			 <div class="form-group" id="credit_cards">
				<img src="/carSharing/html/img/visa.jpg" id="visa"> <img
				src="/carSharing/html/img/mastercard.jpg" id="mastercard"> <img
				src="/carSharing/html/img/amex.jpg" id="amex">
				</div>
				<br><br><br><br>
			 <button type="button" id="button--primary">Daten ändern</button>
			 <br><br><br><br>
			 
	
		</div>
	</div>
	</main>


</body>
<jsp:include page="/theme/html/footer.html" />

<script src="/carSharing/html/js/profil.js"></script>
<script type="text/javascript">
$(function () {
    //Loop through all Labels with class 'editable'.
    $(".editable").each(function () {
        //alle label durchschauen
        var label = $(this);
 
        //textbox neben label
        label.after("<input type = 'text' style = 'display:none' />");
 
        //textbox ansprechen
        var textbox = $(this).next();
 
        //namensattribut von textbox festlegen
        textbox[0].name = this.id.replace("lbl", "txt");
 
        //wertzuweisung
        textbox.val(label.html());
 
        //bei klick auf label, verstecke label und zeige textbox
        label.click(function () {
            $(this).hide();
            $(this).next().show();
        });
 
        //wenn rausgeklickt, verstecke textbox und zeige label
        textbox.focusout(function () {
            $(this).hide();
            $(this).prev().html($(this).val());
            $(this).prev().show();
        });
    });
});
</script>



</html>
