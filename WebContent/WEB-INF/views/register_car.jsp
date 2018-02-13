<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="/carSharing/theme/css/main.css" media="screen" />

<jsp:include page="/theme/html/header.html" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
<script src="choosen.js"></script>


<body>

	<div class="banner-wrapper">
		<img class="banner" alt="Banner"
		src="/carSharing/html/img/header.jpg">

	</div>
	
			<div id="header-content" >
				<h1 id="header-content-text">Fahrzeugregistrierung</h1>
			</div>
	<div class="banner-wrapper">	
	<label>Automarke:</label>		
    <select class="chosen">  
    
	<option="Audi">Audi</option>
	<option="Bentley“>Bentley</option>
	<option="Bitter“>Bitter</option>
	<option="BMW“>BMW</option>
	<option="Borgward“>Borgward</option>
	<option="Brilliance“>Brilliance</option>
	<option="Bristol“>Bristol</option>
	<option="Bugatti“>Bugatti</option>
	<option="Buick“>Buick</option>
	<option="Cadillac“>Cadillac</option>
	<option="Chevrolet“>Chevrolet</option>
	<option="Chrysler“>Chrysler</option>
	<option="Citroen“>Citroen</option>
	<option="Dacia“>Dacia</option>
	<option="Daewoo“>Daewoo</option>
	<option="Daihatsu“>Daihatsu</option>
	<option="De Lorean“>De Lorean</option>
	<option="De Tomaso“>De Tomaso</option>
	<option="Dodge“>Dodge</option>
	<option="DS“>DS</option>
	<option="Ferrari“>Ferrari</option>
	<option="Fiat“>Fiat</option>
	<option="Ford“>Ford</option>
	<option="General Motors“>General Motors</option>
	<option="GMC“>GMC</option>
	<option="Honda“>Honda</option>
	<option="Hummer“>Hummer</option>
	<option="Hyundai“>Hyundai</option>
	<option="Infiniti“>Infiniti</option>
	<option="Isuzu“>Isuzu</option>
	<option="Jaguar“>Jaguar</option>
	<option="Jeep“>Jeep</option>
	<option="Kia“>Kia</option>
	<option="Lada“>Lada</option>
	<option="Lamborghini“>Lamborghini</option>
	<option="Lancia“>Lancia</option>
	<option="Land Rover“>Land Rover</option>
	<option="Lexus“>Lexus</option>
	<option="Lincoln“>Lincoln</option>
	<option="Lotus“>Lotus</option>
	<option="Maserati“>Maserati</option>
	<option="Maybach“>Maybach</option>
	<option="Mazda“>Mazda</option>
	<option="MCC-Smart“>MCC-Smart</option>
	<option="McLaren“>McLaren</option>
	<option="Mercedes-Benz“>Mercedes-Benz</option>
	<option="Mercury“>Mercury</option>
	<option="MG“>MG</option>
	<option="Mini“>Mini</option>
	<option="Mitsubishi“>Mitsubishi</option>
	<option="Morgan“>Morgan</option>
	<option="NEVS“>NEVS</option>
	<option="Nissan“>Nissan</option>
	<option="Oldsmobile“>Oldsmobile</option>
	<option="Opel“>Opel</option>
	<option="Peugeot“>Peugeot</option>
	<option="Plymouth“>Plymouth</option>
	<option="Porsche“>Porsche</option>
	<option="Proton“>Proton</option>
	<option="Qoros“>Qoros</option>
	<option="Renault“>Renault</option>
	<option="Rolls-Royce“>Rolls-Royce</option>
	<option="Saab“>Saab</option>
	<option="Seat“>Seat</option>
	<option="Skoda“>Skoda</option>
	<option="Ssangyong“>Ssangyong</option>
	<option="Subaru“>Subaru</option>
	<option="Suzuki“>Suzuki</option>
	<option="Tesla“>Tesla</option>
	<option="Toyota“>Toyota</option>
	<option="Volkswagen">Volkswagen</option>
	<option="Volvo“>Volvo</option>
	<option="Wiesmann“>Wiesmann</option>
 
	</select>
	
	<script type="text/javascript">
		$(".chosen").chosen();
	</script>
	
	</div>

</body>
</html>