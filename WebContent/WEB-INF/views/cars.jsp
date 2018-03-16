<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="/carSharing/html/css/cars.css" media="screen" />
<jsp:include page="/theme/html/header.jsp" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<style>
<
jsp
:include
 
page
 
="/
html
/css/cars
.css
"/
>
<
jsp
:include
 
page
 
="/
theme
/css/main
.css
"/
>
</style>



<body>
	<div class="banner-wrapper">
		<img class="banner" alt="Banner" src="/carSharing/html/img/header.jpg">
		<div id="header-content">
			<h1 id="header-content-text">Meine CarNow Fahrzeuge</h1>
		</div>
	</div>

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


		<p>Hier findest du alle wichtigen Infos rund um deine zum Mieten
			freigegebenen Fahrzeuge. Stell sicher, dass die Angaben zum Fahrzeug
			immer auf dem neusten Stand sind, damit deiner Nutzung von carNow
			nichts im Wege steht. Solltest du Fragen haben, melde dich gern bei
			uns.</p>
		<br>

		<table id="my_table">
			<tr>
				<th id="head_tbl">Marke</th>
				<th id="head_tbl">Modell</th>
			</tr>
			<c:forEach items="${fahrzeuge}" var="fahrzeug">
				<tr>
					<td id="down_tbl"><c:out value="${fahrzeug.hersteller.name }" />
					</td>
					<td id="down_tbl"><c:out value="${fahrzeug.modell }" /></td>
					<td>
						<button onclick="visitPage(${fahrzeug.id })">Daten ändern</button>
					</td>
					<td>
						<button onclick="visitPageV(${fahrzeug.id })">Vermieten</button>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td>
					<button onclick="visitPageR()">
						</> <i class="material-icons">add</i>
					</button>
				</td>
			</tr>


		</table>
	</div>

	<script>
    function visitPage(id){
        window.location='/carSharing/cars_detail?id='+id;
    }

</script>
	<script>
		    function visitPageV(id){
        window.location='/carSharing/cars_detail?id='+id+"#vermieten";

    }
 </script>
	<script>		
		    function visitPageR(){
		        window.location='/carSharing/register_car';

		    }	
			
		    </script>

</body>
<jsp:include page="/theme/html/footer.html" />


</html>
