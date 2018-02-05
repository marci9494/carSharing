<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="/carSharing/html/css/home.css" media="screen" />
<style>
	<jsp:include page="/theme/css/main.css" />
</style>
<jsp:include page="/theme/html/header.html" />

<body>
	<br><br><br><br><br>
	<div>
		<h5>Vermietungszeitraum</h5>
		<p>Gib hier den Zeitraum an, in dem du dein Auto anderen Nutzern zur Verfügung stellen willst.
			<br><br>
			<label><input type="date" value="von" /></label> -
			<label><input type="date" value="bis" /></label>
			<br><br>
			<button type="button" id="button--primary">Auto vermieten</button>
			<br><br>
		</p>
	</div>
</body>

<jsp:include page="/theme/html/footer.html" />
</html>