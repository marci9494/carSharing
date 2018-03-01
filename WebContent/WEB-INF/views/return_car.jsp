<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="/carSharing/html/css/return_car.css" media="screen" />
<jsp:include page="/theme/html/header.jsp" />
<style>
	<jsp:include page="/html/css/return_car.css" />
	<jsp:include page ="/theme/css/main.css"/>
</style>

<body>
	<div class="banner-wrapper">
		<img class="banner" alt="Banner"
		src="/carSharing/html/img/header.jpg">
	</div>
<br>
	<div id="header-content" >
		<h1 id="header-content-text">Auto&shyrückgabe</h1>
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
		
	<h5>Autodaten im Überblick</h5>
			<span class="form-field-label">Marke: ${buchung.fahrzeug.marke}</span>
			<br><br><br><br>
			<span class="form-field-label">Modell: ${buchung.fahrzeug.modell}</span>
			<br><br><br><br>
			<span class="form-field-label">Farbe: ${buchung.fahrzeug.farbe}</span>
			<br><br><br><br>
			<span class="form-field-label"> Sitzplätze: ${buchung.fahrzeug.sitzplätze}</span>
			<br><br><br>
		
<form action="textarea.html" method="post"> 
	<div>
		<h5>Mängel</h5>
		Hast du während deiner Benutzung Mängel am Auto verursacht? Gib sie hier bitte ein.
			<br><br>
			<textarea id="text" name="maengel" cols="35" rows="4"></textarea>
		<br>	
	</div>
	<div>
		<h5>Nachricht an den Vermieter</h5>
		Willst du dem Vermieter noch etwas mitteilen? Hier hast du die Gelegenheit dazu.
			<br><br>
			<textarea id="text" name="note" cols="35" rows="4"></textarea> 
			<br><br>
			<button type="button" id="button--primary">Auto zurückgeben</button>
			<br>
	</div>  
</form> 
</div>
</body>

<jsp:include page="/theme/html/footer.html" />
</html>