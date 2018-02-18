<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="stylesheet" type="text/css" href="/carSharing/html/css/cars.css" media="screen" />
<jsp:include page="/theme/html/header.html" />
<style>
<jsp:include page ="/html/css/cars.css"/>
<jsp:include page ="/theme/css/main.css"/>

</style>



<body>
	<div class="banner-wrapper">
		<img class="banner" alt="Banner"
		src="/carSharing/html/img/header.jpg">

	</div>


<br>

				
				
			<div id="header-content" >
				<h1 id="header-content-text">Meine CarNow Fahrzeuge</h1>
			</div>
			
		<div class="content-wrapper">	
			<p> Hier findest du alle wichtigen Infos rund um deine zum Mieten freigegebenen Fahrzeuge. Stell sicher, dass die Angaben zum Fahrzeug immer auf dem neusten Stand sind, damit deiner Nutzung von carNow nichts im Wege steht. 
			Solltest du Fragen haben, melde dich gern bei uns.</p>
			<br>
			<br>

<table id="my_table">
  <tr>
    <th id="head_tbl"  >Marke</th>
    <th id="head_tbl">Modell</th>
  </tr>
  <tr>
    <td id="down_tbl">${nutzer.vorname}</td>
    <td id="down_tbl" >${nutzer.nachname}</td>
    <td> <button onclick="visitPage()" >Daten ändern</button> </td>
   </tr>
     <tr>
    <td id="down_tbl">${nutzer.vorname}</td>
    <td id="down_tbl" >${nutzer.nachname}</td>
    <td> <button onclick="visitPage()">Daten ändern</button> </td>
   </tr>
</table>
</div>	
			
<script>
    function visitPage(){
        window.location='/carSharing/cars_detail';
    }
</script>
			
			
			
	</div>
			


</body>
<jsp:include page="/theme/html/footer.html" />

<script src="/carSharing/html/js/cars.js"></script>




</html>
