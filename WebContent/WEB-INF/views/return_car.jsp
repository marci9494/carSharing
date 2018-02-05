<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="/carSharing/html/css/return_car.css" media="screen" />
<jsp:include page="/theme/html/header.html" />
<style>
	<jsp:include page="/theme/css/main.css" />
</style>

<body>
	<br><br><br><br><br><br>
<form action="textarea.html" method="post"> 
	<div>
		<h5>Mängel</h5>
		<p>Hast du während deiner Benutzung Mängel am Auto verursacht? Gib sie hier bitte ein.
			<br><br>
			<textarea id="text" name="text" cols="35" rows="4"></textarea>
		<br>
		</p>	
	</div>
	<div>
		<h5>Nachricht an den Vermieter</h5>
		<p>Willst du dem Vermieter noch etwas mitteilen? Hier hast du die Gelegenheit dazu.
			<br><br>
			<textarea id="text" name="text" cols="35" rows="4"></textarea> 
			<br>
			<button type="button" id="button--primary">Auto zurückgeben</button>
			<br>
		</p>
	</div>  
</form> 
</body>

<jsp:include page="/theme/html/footer.html" />
</html>