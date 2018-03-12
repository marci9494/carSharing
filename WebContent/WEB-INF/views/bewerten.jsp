<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="/carSharing/html/css/bewerten.css" media="screen" />
<jsp:include page="/theme/html/header.jsp" />

<div class="banner-wrapper">
	<img class="banner" alt="Banner" src="/carSharing/html/img/header.jpg">
</div>

<div id="header-content">
	<h1 id="header-content-text">Deine Bewertung</h1>
</div>

<body>
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

		<!-- Was ist das hier alles? -->
		<meta charset="UTF-8">
		<link rel="shortcut icon" type="image/x-icon"
			href="https://production-assets.codepen.io/assets/favicon/favicon-8ea04875e70c4b0bb41da869e81236e54394d63638a1ef12fa558a4a835f1164.ico" />
		<link rel="mask-icon" type=""
			href="https://production-assets.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg"
			color="#111" />


		<p>
			Auf CarNow kannst du Nutzer bewerten und ihnen noch zusätzliche
			Nachrichten schreiben.<br> Bitte bewerte deinen Vertragspartner
			auf einer fairen Basis!
		</p>
		<br>

		<h2>Deine Bewertung</h2>
		<label>Zustand Fahrzeugs</label> <br>
			<select id="zustand" name="zustand">
			<option value="1">sehr schlecht</option>
			<option value="2">schlecht</option>
			<option value="3">gut</option>
			<option value="4">sehr gut</option>
		<br>
								
		<label>Freundlichkeit</label> <br>
			<select id="freundlichkeit" name="freundlichkeit">
			<option value="1">sehr schlecht</option>
			<option value="2">schlecht</option>
			<option value="3">gut</option>
			<option value="4">sehr gut</option>
		<br>
								
		<label>Bezahlvorgang</label> <br>
			<select id="zahlen" name="zahlen">
			<option value="1">sehr schlecht</option>
			<option value="2">schlecht</option>
			<option value="3">gut</option>
			<option value="4">sehr gut</option>
		
		<p></p>
		<span><main> <textarea cols="35" rows="4"></textarea>
			<br>
			<br>
			<br>
			<br>
			<button onclick="bewerten('${buchung.id}')">Bewertung senden</button>
			</main> </span>


		</p>




	</div>
</body>
<script>
function bewerten (buchungsId){
	jQuery.post("bewerten", {
		action : "bewerten",
		buchungId : buchungId,
		
	}, function(data, status) {
		location.reload();
	});
}
</script>

<jsp:include page="/theme/html/footer.html" />


<script src="/carSharing/html/js/home.js"></script>

<script></script>


</html>
