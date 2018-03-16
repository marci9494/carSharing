<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="/carSharing/html/css/login.css" media="screen" />
<jsp:include page="/theme/html/header.jsp" />
<style>
<
jsp
:include
 
page
 
="/
html
/css/login
.css
"/
>
</style>

<body>
	<div class="banner-wrapper">
		<img class="banner" alt="Banner" src="/carSharing/html/img/header.jpg">
		<div id="header-content">
			<h1 id="header-content-text">Login</h1>
		</div>
	</div>


	<div class="content-wrapper">
		<h5>
			Willkommen <span>zurück!</span>
		</h5>
		<form method="post" action="login" accept-charset="ISO-8859-1">
			<label class="user">
				<p>
					<input type="text" name="username" placeholder="Email"
						id="username">
			</label> <label class="mail"> <input type="password" name="pass"
				placeholder="Passwort" id="pass">
				</p>
			</label>
			<p>
				<button type="submit" value="login" onsubmit="">Anmelden</button>
			</p>
		</form>

		<p>
			<a href="/carSharing/register">Noch kein Konto? Hier kannst Du
				dich registrieren.</a>
		</p>
	</div>

</body>
<jsp:include page="/theme/html/footer.html" />

</html>