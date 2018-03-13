<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>CarNow</title>
 <link rel="stylesheet" type="text/css" href="/carSharing/theme/css/main.css" media="screen" />
</head>

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
			<li><a href="/carSharing/home">Fahrzeug mieten</a></li>
			<li><a href="/carSharing/buchungen">Meine Buchungen</a></li>
			<li><a href="/carSharing/cars">Vermieten</a></li>
			<!-- Wenn User angemeldet ist, wird Profil angezeigt, ansonsten Login -->
			<c:choose>
   				 <c:when test="${ userEmail!=null}">
        			<li><a href="/carSharing/profil">Profil</a></li>
   				 </c:when>    
    			 <c:otherwise>
        			<li><a href="/carSharing/login">Login</a></li>
    			</c:otherwise>
			</c:choose>
		</ul>

	</nav>
</header>


