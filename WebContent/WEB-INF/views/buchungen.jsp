<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="/carSharing/html/css/login.css" media="screen" />
<jsp:include page="/theme/html/header.jsp" />

<body>
<head>
<style>


.form {
	width: 340px;
	height: 470px;
	border-radius: 8px;
	box-shadow: 0 0 40px -10px #000;
	margin: calc(50vh - 220px) auto;
	padding: 20px 30px;
	max-width: calc(100vw - 40px);
	box-sizing: border-box;
	position: relative
}




input:focus {
	border-bottom: 2px solid #78788c
}

p:before {
	content: attr(type);
	display: block;
	margin: 28px 0 0;
	font-size: 14px;
	color: #5a5a5a
}





</style>



</head>







<form class="form">
	<h2>Deine Buchungen</h2>
	<p type="Name:">
		<input placeholder="Dein Name..."></input>
	</p>
	<p type="Vorname:">
		<input placeholder="Dein Vorname"></input>
	</p>
	<p type="Buchungsnummer:">
		<input placeholder="Deine Buchungsnummer"></input>
	</p>
	<button>Send Message</button>
	<div>
		<span class="fa fa-phone"></span>Car2Go <span class="fa fa-envelope-o"></span>
	</div>
</form>

</body>
<jsp:include page="/theme/html/footer.html" />

</html>