<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="stylesheet" type="text/css" href="/carSharing/html/css/cars.css" media="screen" />
<jsp:include page="/theme/html/header.jsp" />
<style>
	<jsp:include page="/html/css/cars.css" />
</style>



<body>
	<div class="banner-wrapper">
		<img class="banner" alt="Banner"
		src="/carSharing/html/img/header.jpg">

	</div>

<main> 

<br>

				
				
			<div id="header-content" >
				<h1 id="header-content-text">Impressum</h1>
				
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
				
			</div>
			<h2> Mietbedingungen</h2>
			<p> Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut 
			labore et dolore magna aliquyam erat, sed diam voluptua. 
			At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, 
			no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, 
			consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, 
			sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. 
			Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.
</p>
			
				<h2> Allgemeine Datenschutzerklärung </h2>
<p>Durch die Nutzung unserer Website erklären Sie sich mit der Erhebung, Verarbeitung und Nutzung von Daten gemäß der nachfolgenden Beschreibung einverstanden. Unsere Website kann grundsätzlich ohne Registrierung besucht werden. Dabei werden Daten wie beispielsweise aufgerufene Seiten bzw. Namen der abgerufenen Datei, Datum und Uhrzeit zu statistischen Zwecken auf dem Server gespeichert, ohne dass diese Daten unmittelbar auf Ihre Person bezogen werden. Personenbezogene Daten, insbesondere Name, Adresse oder E-Mail-Adresse werden soweit möglich auf freiwilliger Basis erhoben. Ohne Ihre Einwilligung erfolgt keine Weitergabe der Daten an Dritte.</p>


<p>Quelle: <a href="https://www.anwalt.de/vorlage/muster-datenschutzerklaerung.php">Muster-Datenschutzerklärung von anwalt.de</a></p>

		</main> 
		<h2> Impressum und Kontakt</h2>
		<p> &copy; carNow  GmbH </p>
		<p> Duale Hochschule Baden-Württemberg Heidenheim </p>
		<p> Studiengang WWI16B - carNow Gruppe </p>


</body>
<jsp:include page="/theme/html/footer.html" />

<script src="/carSharing/html/js/impressum.js"></script>




</html>
