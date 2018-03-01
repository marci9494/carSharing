<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="/carSharing/html/css/login.css" media="screen" />
<jsp:include page="/theme/html/header.jsp" />

<body>
<head>
<style>
table {
	overflow: hidden;
	text-align: center;
}

td, th {
	padding: 10px;
	position: relative;
	outline: 0;
}

<<<<<<<
HEAD
body:not (.nohover ) tbody tr:hover {
	background-color: aqua; =======
	body: not(.nohover) tbody tr:hover{
  background-color: #00a0e1;
	>>>>>>>
	e7fb7dd24ed5fce5004b7360e5130cecc40770f3
}

td:hover::after, thead th:not (:empty ):hover::after, td:focus::after,
	thead th:not (:empty ):focus::after {
	content: '';
	height: 10000px;
	left: 0;
	position: absolute;
	top: -5000px;
	width: 100%;
	z-index: -1;
}

td:hover::after, th:hover::after {
	background-color: #00a0e1;
}

td:focus::after, th:focus::after {
	background-color: #00a0e1;
}

/* Focus stuff for mobile */
td:focus::before, tbody th:focus::before {
	background-color: #00a0e1;
	content: '';
	height: 100%;
	top: 0;
	left: -5000px;
	position: absolute;
	width: 10000px;
	z-index: -1;
}
</style>



</head>


<body>
	<div class="banner-wrapper">
		<img class="banner" alt="Banner" src="/carSharing/html/img/header.jpg">

	</div>
	
	<div class="content-wrapper">

	<c:choose>
		<c:when test="${ userEmail!=null}">
			<div class="logout">
				Herzlich Willkommen ${userEmail } <a href="/carsharing/logout">(Logout)</a>
			</div>
		</c:when>
		<c:otherwise>
        			
    			</c:otherwise>
	</c:choose>
	</div>


	<div id="header-content">
		<h1 id="header-content-text">Deine Buchungen</h1>
	</div>
	<main>
	<table>
		<thead>
			<tr>
				<th></th>
				<th class="col">Vermieten</th>
				<th class="col">Mieten</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${buchungen}" var="buchung">
				<tr>
					<th class="row">Buchungsnummer ${buchung.id }</th>
					<td>${buchung.endDatum }</td>
					<td>${buchung.startDatum }</td>
				</tr>
			</c:forEach>
		<tbody>
	</table>
	</main>


</body>
<jsp:include page="/theme/html/footer.html" />
</div>

</html>