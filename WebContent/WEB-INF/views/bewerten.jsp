<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="/carSharing/html/css/bewerten.css" media="screen" />
<jsp:include page="/theme/html/header.jsp" />

<div class="banner-wrapper">
	<img class="banner" alt="Banner"
	src="/carSharing/html/img/header.jpg">
</div>

<div id="header-content" >
	<h1 id="header-content-text">Deine Bewertung</h1>
</div>

<body>
<html lang="de">
<div class="content-wrapper">
<div id=hallo>
		<c:choose>
			<c:when test="${ user!=null}">
				<div class="logout">
					Herzlich Willkommen ${user.vorname} ${user.nachname} <a href="/carsharing/logout">(Logout)</a>
				</div>
				<input type="hidden" class="userEmail" value="${userEmail}" />
			</c:when>
			<c:otherwise>
        			Herzlich Willkommen
    			</c:otherwise>
		</c:choose>
	</div>

<head>

		
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/x-icon"
	href="https://production-assets.codepen.io/assets/favicon/favicon-8ea04875e70c4b0bb41da869e81236e54394d63638a1ef12fa558a4a835f1164.ico" />
<link rel="mask-icon" type=""
	href="https://production-assets.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg"
	color="#111" />
<title>Bewerte deinen Mieter!</title>

</head>

<h3>Bitte bewerte deinen Vertragspartner auf einer fairen Basis!</h3>

<p>Auf CarNow kannst du Nutzer bewerten und ihnen noch zusätzliche Nachrichten schreiben.</p>

<form class="form">
	<h2>Deine Bewertung</h2>
	<p type="Zustand des Fahrzeuges:">
		<span class='review-holder'> <span class='review'> <span
				data-description=' sehr schlecht'></span> <span
				data-description="schlecht"></span> <span data-description="ok"></span>
				<span data-description="gut"></span> <span
				data-description="sehr gut"></span>
		</span>
		</span>

	</p>
	<p type="Freundlichkeit:">
		<span class='review-holder'> <span class='review'> <span
				data-description=' sehr schlecht'></span> <span
				data-description="schlecht"></span> <span data-description="ok"></span>
				<span data-description="gut"></span> <span
				data-description="sehr gut"></span>
		</span>
		</span>
	<p type="Bezahlvorgang:">
		<span class='review-holder'> <span class='review'> <span
				data-description=' sehr schlecht'></span> <span
				data-description="schlecht"></span> <span data-description="ok"></span>
				<span data-description="gut"></span> <span
				data-description="sehr gut"></span>
		</span>
		</span>
		<p></p>
		<span><main>
	<textarea>Hier kannst du dein Kommentar hinterlassen …</textarea>
</main>
		
		</span>


	</p>
	<button>Bewertung senden</button>

</form>


</div>
</body>
<jsp:include page="/theme/html/footer.html" />

<script src="/carSharing/html/js/home.js"></script>




</html>
