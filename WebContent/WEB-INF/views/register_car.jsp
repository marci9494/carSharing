<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="/carSharing/html/css/register_car.css" media="screen" />

<jsp:include page="/theme/html/header.jsp" />

<!-- <script src="https://code.jquery.com/jquery-2.1.1.min.js"
	type="text/javascript"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.1/css/select2.min.css"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.1/js/select2.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var marke = [];
		$("#marke").select2({
			data : marke
		});
	});

	$(document).ready(function() {
		var kraftstoff = [];
		$("#kraftstoff").select2({
			data : kraftstoff
		});
	});
</script> -->

<body>

	<div class="banner-wrapper">
		<img class="banner" alt="Banner" src="/carSharing/html/img/header.jpg">

	</div>

	<div id="header-content">
		<h1 id="header-content-text">Fahrzeugregistrierung</h1>
	</div>
	<div class="content-wrapper">

<div id=hallo>
		<c:choose>
   				 <c:when test= "${ userEmail!=null}">
        			<div class="logout">Herzlich Willkommen ${userEmail } <a href="/carsharing/logout">(Logout)</a></div>
   				 </c:when>    
    			 <c:otherwise>
        			Herzlich Willkommen
    			</c:otherwise>
		</c:choose>
		</div>

<br><br>

		<label>Kfz-Kennzeichen</label><br>
		<div class="kennzeichen-wrapper">
			<img class="kennzeichen_img" alt="Kennzeichen"
				src="/carSharing/html/img/kennzeichen.jpg"> <span id="span1">
				<input type="text" name="kennzeichen_1" id="kennzeichen_1"
				placeholder="HH" maxlength="3">
			</span> <span id="span2"> <input type="text" name="kennzeichen_2"
				id="kennzeichen_2" placeholder="XX" maxlength="2">
			</span> <span id="span3"> <input type="int" name="kennzeichen_3"
				id="kennzeichen_3" placeholder="1234" maxlength="4">
			</span>
		</div>

		<div class="formular-wrapper">
			<ul class="formular_ul">
				<li class="formular_li"><label>Automarke</label> <br> <select
					id="marke">
						<option value="Audi">Audi</option>
						<option value="Bentley">Bentley</option>
						<option value="Bitter">Bitter</option>
						<option value="BMW">BMW</option>
						<option value="Borgward">Borgward</option>
						<option value="Brilliance">Brilliance</option>
						<option value="Bristol">Bristol</option>
						<option value="Bugatti">Bugatti</option>
						<option value="Buick">Buick</option>
						<option value="Cadillac">Cadillac</option>
						<option value="Chevrolet">Chevrolet</option>
						<option value="Chrysler">Chrysler</option>
						<option value="Citroen">Citroen</option>
						<option value="Dacia">Dacia</option>
						<option value="Daewoo">Daewoo</option>
						<option value="Daihatsu">Daihatsu</option>
						<option value="De Lorean">De Lorean</option>
						<option value="De Tomaso">De Tomaso</option>
						<option value="Dodge">Dodge</option>
						<option value="DS">DS</option>
						<option value="Ferrari">Ferrari</option>
						<option value="Fiat">Fiat</option>
						<option value="Ford">Ford</option>
						<option value="General Motors">General Motors</option>
						<option value="GMC">GMC</option>
						<option value="Honda">Honda</option>
						<option value="Hummer">Hummer</option>
						<option value="Hyundai">Hyundai</option>
						<option value="Infiniti">Infiniti</option>
						<option value="Isuzu">Isuzu</option>
						<option value="Jaguar">Jaguar</option>
						<option value="Jeep">Jeep</option>
						<option value="Kia">Kia</option>
						<option value="Lada">Lada</option>
						<option value="Lamborghini">Lamborghini</option>
						<option value="Lancia">Lancia</option>
						<option value="Land Rover">Land Rover</option>
						<option value="Lexus">Lexus</option>
						<option value="Lincoln">Lincoln</option>
						<option value="Lotus">Lotus</option>
						<option value="Maserati">Maserati</option>
						<option value="Maybach">Maybach</option>
						<option value="Mazda">Mazda</option>
						<option value="MCC-Smart">MCC-Smart</option>
						<option value="McLaren">McLaren</option>
						<option value="Mercedes-Benz">Mercedes-Benz</option>
						<option value="Mercury">Mercury</option>
						<option value="MG">MG</option>
						<option value="Mini">Mini</option>
						<option value="Mitsubishi">Mitsubishi</option>
						<option value="Morgan">Morgan</option>
						<option value="NEVS">NEVS</option>
						<option value="Nissan">Nissan</option>
						<option value="Oldsmobile">Oldsmobile</option>
						<option value="Opel">Opel</option>
						<option value="Peugeot">Peugeot</option>
						<option value="Plymouth">Plymouth</option>
						<option value="Porsche">Porsche</option>
						<option value="Proton">Proton</option>
						<option value="Qoros">Qoros</option>
						<option value="Renault">Renault</option>
						<option value="Rolls-Royce">Rolls-Royce</option>
						<option value="Saab">Saab</option>
						<option value="Seat">Seat</option>
						<option value="Skoda">Skoda</option>
						<option value="Ssangyong">Ssangyong</option>
						<option value="Subaru">Subaru</option>
						<option value="Suzuki">Suzuki</option>
						<option value="Tesla">Tesla</option>
						<option value="Toyota">Toyota</option>
						<option value="Volkswagen">Volkswagen</option>
						<option value="Volvo">Volvo</option>
						<option value="Wiesmann">Wiesmann</option>
				</select></li>
				<li class="formular_li"><label for="modell">Modell</label><br>
					<input type="text" name="modell" id="modell"
					placeholder="z.B. Astra" size="30" maxlength="30"></li>
				<ul>
		</div>
		<br>
		<div class="formular-wrapper">
			<ul class="formular_ul">
				<li class="formular_li"><label for="baujahr">Baujahr</label><br>
					<input type="int" name="baujahr" id="baujahr"
					placeholder="z.B. 2012" size="10" maxlength="4"></li>
				<li class="formular_li"><label for="laufleistung">Laufleistung
						in km</label><br> <input type="int" name="laufleistung"
					id="laufleistung" placeholder="z.B. 148000" size="20" maxlength="6"></li>
			</ul>
		</div>

		<br> <br>

		<div class="formular-wrapper">
			<h2>Leistung</h2>
		</div>

		<div class="formular-wrapper">
			<ul class="formular_ul">
				<li class="formular_li"><label for="ps">PS</label><br> <input
					type="int" name="ps" id="ps" placeholder="z.B. 122" size="10"
					maxlength="3"></li>
				<li class="formular_li"><label>Kraftstoff</label><br> <select
					id="kraftstoff">
						<option value="Benzin">Benzin</option>
						<option value="Diesel">Diesel</option>
						<option value="Elektro">Elektro</option>
						<option value="Hybrid">Hybrid</option>
						<option value="Erdgas">Erdgas</option>
				</select></li>
		</div>

		<div class="formular-wrapper">
			<h2>Ausstattung</h2>
		</div>

		<div class="formular-wrapper">
			<ul class="formular_ul">
				<li class="formular_li"><label>Farbe</label> <br> <select
					id="farbe">
						<option value="Grau">Grau</option>
						<option value="Rot">Rot</option>
						<option value="Schwarz">Schwarz</option>
						<option value="Weiß">Weiß</option>
						<option value="sonstiges">sonstiges</option>
				</select></li>
				<li class="formular_li"><label class="container">Kindersitz
						<input type="checkbox" checked="checked"> <span
						class="checkmark"></span>
				</label> <label class="container">Navigationsgerät <input
						type="checkbox"> <span class="checkmark"></span>
				</label> <label class="container">Klimaanlage oder Klimaautomatik <input
						type="checkbox"> <span class="checkmark"></span>
				</label> <label class="container">Fahradträger <input
						type="checkbox"> <span class="checkmark"></span>
				</label> <label class="container">Dachbox <input type="checkbox">
						<span class="checkmark"></span>
				</label> <label class="container">Tempomat <input type="checkbox">
						<span class="checkmark"></span>
				</label> <label class="container">Winterreifen <input
						type="checkbox"> <span class="checkmark"></span>
				</label> <label class="container">Schneeketten <input
						type="checkbox"> <span class="checkmark"></span>
				</label></li>
		</div>

		<div class="formular-wrapper">
			<h2>Fotos</h2>
		</div>

		<div class="formular-wrapper">
			<label>Fügen Sie Bilder Ihres Fahrzeugs hinzu, um die
				Attraktivität Ihrer Anzeige zu erhöhen</label> <br> <input
				name="datei[]" type="file" size="50" accept="image/*" multiple>
			</label>
		</div>

		<div class="formular-wrapper">
			<h2>Fahrzeugschein</h2>
		</div>

		<div class="formular-wrapper">
			<label>Laden Sie bitte ein Bild Ihres Fahrzeugscheins
				(Zulassungsbescheinigung Teil I) hoch</label> <br> <input name="datei"
				type="file" size="50" accept="image/*">
		</div>

		<div class="formular-wrapper">
			<button onclick="register()">Weiter</button>
		</div>

		<div class="formular-wrapper">
			<div class="slidecontainer">
				<input type="range" min="1" max="100" value="50" class="slider"
					id="myRange">
				<script>
					var slider = document.getElementById("myRange");
					var output = document.getElementById("demo");
					output.innerHTML = slider.value; // Display the default slider value

					// Update the current slider value (each time you drag the slider handle)
					slider.oninput = function() {
						output.innerHTML = this.value;
					}
				</script>


			</div>
		</div>



	</div>
</body>
<jsp:include page="/theme/html/footer.html" />
</html>