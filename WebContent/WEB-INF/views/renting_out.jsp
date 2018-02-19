<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<header>
	<a href="/carSharing/home"><img src='/carSharing/theme/img/logo3.png'
		id="logo" alt="logo"></a> <label for="show-menu" class="show-menu"><svg
			xmlns="http://www.w3.org/2000/svg" width="21" height="18"
			viewBox="-287 411.9 21 18">
			<path fill="#FFF"
				d="M-267.7 422.2h-18c-.7 0-1.3-.6-1.3-1.3 0-.7.6-1.3 1.3-1.3h18c.7 0 1.3.6 1.3 1.3 0 .7-.6 1.3-1.3 1.3zm0-7.7h-18c-.7 0-1.3-.6-1.3-1.3 0-.7.6-1.3 1.3-1.3h18c.7 0 1.3.6 1.3 1.3 0 .7-.6 1.3-1.3 1.3zm-18 12.8h18c.7 0 1.3.6 1.3 1.3 0 .7-.6 1.3-1.3 1.3h-18c-.7 0-1.3-.6-1.3-1.3 0-.7.6-1.3 1.3-1.3z" /></svg></label>
	<input type="checkbox" id="show-menu">
	<nav id="nav">
		<ul>
			<li><a href="/carSharing/home">Dashboard</a></li>
			<li><a href="">Mieten</a></li>
			<li><a href="/carSharing/cars">Vermieten</a></li>
			<c:choose>
   				 <c:when test= "userEmail!=null">
        			<li><a href="/carSharing/profil">Profil</a></li>
   				 </c:when>    
    			 <c:otherwise>
        			<li><a href="/carSharing/login">Login</a></li>
    			</c:otherwise>
		</c:choose>
		</ul>
	</nav>
</header>
<body>
	<div class="banner-wrapper">
		<img class="banner" alt="Banner"
		src="/carSharing/html/img/header.jpg">
	</div>
<main>
//nur anzeigen wenn angemeldet
		<c:choose>
   				 <c:when test= "userEmail!=null">
        			<div class="logout">Herzlich Willkommen ${userEmail } <a href="/carsharing/Logout">(Logout)</a></div>
   				 </c:when>    
    			 <c:otherwise>
        			Herzlich Willkommen
    			</c:otherwise>
		</c:choose>
	<div class="logout">Herzlich Willkommen ${userEmail } <a href="/carsharing/Logout">(Logout)</a></div>

	<div id="header-content" >
		<h1 id="header-content-text">Auto&shyvermietung</h1>
	</div>
	<div>
	<h5>Autodaten im Überblick</h5>
		<p>
			<span class="form-field-label">Marke: ${car.marke}</span>
			<br><br><br><br>
			<span class="form-field-label">Modell: ${car.modell}</span>
			<br><br><br><br>
			<span class="form-field-label">Farbe: ${car.farbe}</span>
			<br><br><br><br>
			<span class="form-field-label"> Sitzplätze: ${car.sitzplätze}</span>
		</p>
	</p>
	</div>
	<div>
		<h5>Vermietungs&shyzeitraum</h5>
		<p>Gib hier den Zeitraum an, in dem du dein Auto anderen Nutzern zur Verfügung stellen willst.
			<br><br>
			<label><input type="date" value="von" /></label> -
			<label><input type="date" value="bis" /></label>
			<br><br>
			<button type="button" id="button--primary">Auto vermieten</button>
			<br><br>
		</p>
	</div>
</main>
</body>

<jsp:include page="/theme/html/footer.html" />
</html>