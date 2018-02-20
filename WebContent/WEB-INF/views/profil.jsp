<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="/carSharing/html/css/profil.css" media="screen" />
<jsp:include page="/theme/html/header.jsp" />
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

 <br>


	<div id="header-content">
		<h1 id="header-content-text">Meine CarNow Accountdetails</h1>
	</div>
<div class="content-wrapper">

<div id=hallo>
		<c:choose>
   				 <c:when test= "${ userEmail!=null}">
        			<div class="logout">Herzlich Willkommen ${userEmail } <a href="/carsharing/logout">(Logout)</a></div>
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
		<br> <span class="form-field-label">Ort</span> <br>
		<br>
		<p class="editable">
			${nutzer.plz} ${nutzer.ort}
		</p>
		<br>
		<br> <span class="form-field-label">Strasse</span> <br>
		<br>
		<p class="editable">
			${nutzer.strasse} 
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
	<button onclick="update()"> Speichern</button>
	<br>
	<br>
	<br>
	<br>


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

function update() {

	var email = jQuery('#email').val();
	var vorname = jQuery('#vorname').val();
	var nachname = jQuery('#nachname').val();
	var strasse = jQuery('#strasse').val();
	var postleitzahl = jQuery('#postleitzahl').val();
	var stadt = jQuery('#stadt').val();
	var passwort = jQuery('#passwort').val();

	console.log(passwort);
	jQuery.post("update", {
		email : email,
		vorname : vorname,
		nachname : nachname,
		strasse : strasse,
		postleitzahl : postleitzahl,
		stadt : stadt,
		passwort : passwort
	}, function(data, status) {
		if(data){
			window.location.href = "'/carSharing/profil';";
		}else{
			//POPUP anzeigen, email bereits vergeben
		}
	});
}
</script>



</html>
