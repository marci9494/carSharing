<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="/carSharing/html/css/register_car.css" media="screen" />

<jsp:include page="/theme/html/header.html" />

<script src="https://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
		<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.1/css/select2.min.css" rel="stylesheet" />
		<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.1/js/select2.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				var marke = [];
				$("#marke").select2({
				  data: marke
				});
			});
			
			$(document).ready(function() {
				var kraftstoff = [];
				$("#kraftstoff").select2({
				  data: kraftstoff
				});
			});
		</script>

<body>

	<div class="banner-wrapper">
		<img class="banner" alt="Banner"
		src="/carSharing/html/img/header.jpg">

	</div>
	
	<div id="header-content" >
		<h1 id="header-content-text">Fahrzeugregistrierung</h1>
	</div>
	
	<div class="wrapper">	
	<label>Automarke</label>		
    <select id="marke">
  		<option value="Audi">Audi</option>
		<option value="Bentley“>Bentley</option>
		<option value="Bitter“>Bitter</option>
		<option value="BMW“>BMW</option>
		<option value="Borgward“>Borgward</option>
		<option value="Brilliance“>Brilliance</option>
		<option value="Bristol“>Bristol</option>
		<option value="Bugatti“>Bugatti</option>
		<option value="Buick“>Buick</option>
		<option value="Cadillac“>Cadillac</option>
		<option value="Chevrolet“>Chevrolet</option>
		<option value="Chrysler“>Chrysler</option>
		<option value="Citroen“>Citroen</option>
		<option value="Dacia“>Dacia</option>
		<option value="Daewoo“>Daewoo</option>
		<option value="Daihatsu“>Daihatsu</option>
		<option value="De Lorean“>De Lorean</option>
		<option value="De Tomaso“>De Tomaso</option>
		<option value="Dodge“>Dodge</option>
		<option value="DS“>DS</option>
		<option value="Ferrari“>Ferrari</option>
		<option value="Fiat“>Fiat</option>
		<option value="Ford“>Ford</option>
		<option value="General Motors“>General Motors</option>
		<option value="GMC“>GMC</option>
		<option value="Honda“>Honda</option>
		<option value="Hummer“>Hummer</option>
		<option value="Hyundai“>Hyundai</option>
		<option value="Infiniti“>Infiniti</option>
		<option value="Isuzu“>Isuzu</option>
		<option value="Jaguar“>Jaguar</option>
		<option value="Jeep“>Jeep</option>
		<option value="Kia“>Kia</option>
		<option value="Lada“>Lada</option>
		<option value="Lamborghini“>Lamborghini</option>
		<option value="Lancia“>Lancia</option>
		<option value="Land Rover“>Land Rover</option>
		<option value="Lexus“>Lexus</option>
		<option value="Lincoln“>Lincoln</option>
		<option value="Lotus“>Lotus</option>
		<option value="Maserati“>Maserati</option>
		<option value="Maybach“>Maybach</option>
		<option value="Mazda“>Mazda</option>
		<option value="MCC-Smart“>MCC-Smart</option>
		<option value="McLaren“>McLaren</option>
		<option value="Mercedes-Benz“>Mercedes-Benz</option>
		<option value="Mercury“>Mercury</option>
		<option value="MG“>MG</option>
		<option value="Mini“>Mini</option>
		<option value="Mitsubishi“>Mitsubishi</option>
		<option value="Morgan“>Morgan</option>
		<option value="NEVS“>NEVS</option>
		<option value="Nissan“>Nissan</option>
		<option value="Oldsmobile“>Oldsmobile</option>
		<option value="Opel“>Opel</option>
		<option value="Peugeot“>Peugeot</option>
		<option value="Plymouth“>Plymouth</option>
		<option value="Porsche“>Porsche</option>
		<option value="Proton“>Proton</option>
		<option value="Qoros“>Qoros</option>
		<option value="Renault“>Renault</option>
		<option value="Rolls-Royce“>Rolls-Royce</option>
		<option value="Saab“>Saab</option>
		<option value="Seat“>Seat</option>
		<option value="Skoda“>Skoda</option>
		<option value="Ssangyong“>Ssangyong</option>
		<option value="Subaru“>Subaru</option>
		<option value="Suzuki“>Suzuki</option>
		<option value="Tesla“>Tesla</option>
		<option value="Toyota“>Toyota</option>
		<option value="Volkswagen">Volkswagen</option>
		<option value="Volvo“>Volvo</option>
		<option value="Wiesmann“>Wiesmann</option>
	</select>
	
	<label for="modell">Modell</label> <input type="text"
			name="modell" id="modell" placeholder="z.B. Astra" size="30"
			maxlength="30">
	
	</div>
	
	<div class="wrapper">
	<label for="baujahr">Baujahr</label> <input type="int"
			name="baujahr" id="baujahr" placeholder="z.B. 2012" size="30"
			maxlength="4">	
			
	<label for="laufleistung">Laufleistung in km</label> <input type="int"
			name="laufleistung" id="laufleistung" placeholder="z.B. 148000" size="30"
			maxlength="6">
			
	<br><br>		
			
	<div class="wrapper">
		<h2>Leistung und Ausstattung</h2>
	</div>

	<div class="wrapper">
		<label for="ps">PS</label> <input type="int"
			name="ps" id="ps" placeholder="z.B. 122" size="30"
			maxlength="3">
			
		<label>Kraftstoff</label>		
    	<select id="kraftstoff">
  			<option value="Benzin">Benzin</option>
			<option value="Diesel">Diesel</option>
			<option value="Elektro">Elektro</option>
			<option value="Hybrid">Hybrid</option>
			<option value="Erdgas">Erdgas</option>
		</select>
	</div>
	
	<br>
	
	<div class="wrapper">
	<label for="ausstattung">Geben Sie die Ausstattung des Fahrzeugs an (Trennunng von mehreren Elementen mit Semikolon ; )</label>
	 <textarea name=ausstattung id="ausstattung" rows="5" cols="50" placeholder="Klimatronik;elektronische Fensterheber;Frontscheibenheizung"></textarea> 	
	
	<div class="wrapper">
		<h2>Fotos</h2>
	</div>
	
	<div class="wrapper">
		<label>Fügen Sie Bilder Ihres Fahrzeugs hinzu, um die Attraktivität Ihrer Anzeige zu erhöhen<input name="datei[]"
			type="file" size="50" accept="image/*" multiple>
		</label>		
	</div>

	<div class="wrapper">
		<h2>Fahrzeugschein</h2>
	</div>	

	<div class="wrapper">
	<label>Laden Sie bitte ein Bild Ihres Fahrzeugscheins (Zulassungsbescheinigung Teil I) hoch<input name="datei"
		type="file" size="50" accept="image/*">
	</label>		
	</div>
	
	<div class="submit">
		<button class="send_reg"  onclick="register()">Weiter</button>
	</div>
</body>
</html>