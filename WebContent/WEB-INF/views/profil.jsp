<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="stylesheet" type="text/css" href="/carSharing/html/css/profil.css" media="screen" />
<jsp:include page="/theme/html/header.html" />
<style>
	<jsp:include page="/html/css/profil.css" />
</style>



<body>
	<div class="banner-wrapper">
		<img class="banner" alt="Banner"
		src="/carSharing/html/img/header.jpg">

	</div>

<main> 

<br>

				
				
			<div id="header-content" >
				<h1 id="header-content-text">Meine CarNow Accountdetails</h1>
			</div>
			
				
			<p> Hier findest du alle wichtigen Infos rund um deinen Account. Stell sicher, dass deine Angaben immer auf dem neusten Stand sind, damit deiner Nutzung von carNow nichts im Wege steht. 
			Solltest du Fragen haben, melde dich gern bei uns.</p>
			<div id="name-adress" class="name-adress">
			<h2> Persönliche Daten</h2>
			<span class="form-field-label">Anrede</span>
			<br><br>
			//Zugriff auf Anrede auf DB funktioniert nicht?
			<br><br>
			<span class="form-field-label">Vorname</span>
			<br><br>
			<div id="daten" class="daten">
			${nutzer.vorname}
			</div>
			<br><br>
			<span class="form-field-label">Nachname</span>
			<br><br>
			<div id="daten" class="daten">
			${nutzer.nachname}
			</div>
			<br><br>
			<span class="form-field-label">Adresse</span>
			<br><br>
			<div id="daten" class="daten">
			${nutzer.strasse}<br>
			${nutzer.plz} ${nutzer.ort}
			</div><br><br>
			<span class="form-field-label">E-Mail-Adresse</span>
			<br><br>
			<div id="daten" class="daten">
			${nutzer.email}
			</div><br><br>
			<span class="form-field-label">Dein Passwort</span>
			<br><br><div id="daten" class="daten">
			********
			</div><br><br>
			</div>
			 <button type="button" id="button--primary">Daten ändern</button>
			 <br><br><br><br>
			 <h2> Führerscheindaten</h2>
			 <p> Lade hier ein Foto von deinem Führerschein hoch, damit eine Nutzung von carNow möglich ist. </p>
			 <br>
			 <div class="file-upload btn btn-primary">	
			 <span>Hochladen</span>  
			<input class="upload" type="file"></div> //Anzeige, welche Datei hochgeladen wurde?
			 <br><br><br><br>
			 <h2> Kreditkarteninformationen</h2>
			<!--   <span class="form-field-label">Anbieter</span>
			<br><br><br><br>
			<span class="form-field-label">Kartenummer</span>
			<br><br><br><br>
			<span class="form-field-label">Gültigkeit</span>
			<br><br><br><br>
			<span class="form-field-label">Prüfziffer</span>
			 <br><br><br><br>
			 <button type="button" id="button--primary">Daten ändern</button>
			 <br><br><br><br>-->
			 <div class="creditCardForm">
    <div class="payment">
        <form>
            <div class="form-group owner">
                <label for="owner">Vor-/Name:</label>
                <input type="text" class="form-control" id="owner">
            </div>
            <div class="form-group CVV">
                <label for="cvv">Prüfziffer:</label>
                <input type="text" class="form-control" id="cvv">
            </div>
            <div class="form-group" id="card-number-field">
                <label for="cardNumber">Nummer:</label>
                <input type="text" class="form-control" id="cardNumber">
            </div>
            <div class="form-group" id="expiration-date">
                <label>Gültig bis:</label>
                <select>
                    <option value="01">Januar</option>
                    <option value="02">Februar </option>
                    <option value="03">März</option>
                    <option value="04">April</option>
                    <option value="05">Mai</option>
                    <option value="06">Juni</option>
                    <option value="07">July</option>
                    <option value="08">August</option>
                    <option value="09">September</option>
                    <option value="10">Oktober</option>
                    <option value="11">November</option>
                    <option value="12">Dezember</option>
                </select>
                <select>
                    <option value="18"> 2018</option>
                    <option value="19"> 2019</option>
                    <option value="20"> 2020</option>
                    <option value="21"> 2021</option>
                    <option value="22"> 2022</option>
                    <option value="23"> 2023</option>
                    <option value="24"> 2024</option>
                    <option value="25"> 2025</option>
                    
                </select>
            </div>
            <div class="form-group" id="credit_cards">
                <img src="/carSharing/html/img/visa.jpg" id="visa">
                <img src="/carSharing/html/img/mastercard.jpg" id="mastercard">
                <img src="/carSharing/html/img/amex.jpg" id="amex">
            </div>
            <div class="form-group" id="pay-now">
                <button type="submit" class="btn btn-default" id="confirm-purchase">Confirm</button>
            </div>
        </form>
    </div>
</div>
		</main> 


</body>
<jsp:include page="/theme/html/footer.html" />

<script src="/carSharing/html/js/profil.js"></script>




</html>
