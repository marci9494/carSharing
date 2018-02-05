<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="stylesheet" type="text/css" href="/carSharing/html/css/home.css" media="screen" />
<jsp:include page="/theme/html/header.html" />


<body>

	<div class="banner-wrapper">
		<img class="banner" alt="Banner"
			src="/carSharing/html/img/header.jpg">

	</div>
	
	
	<div class="search-overlay">
	Jetzt Autos in der nähe finden<br>
		<input type="text" class="plzInput"/>
		<input type="button" value="Suchen" onclick="searchCar()"/>
	</div>



	${ausstattung.id} ${ausstattung.name} df fda
	<br> fd
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br> 	<br> 
	<br> 



</body>
<jsp:include page="/theme/html/footer.html" />

<script src="/carSharing/html/js/home.js"></script>

<script>
function searchCar(){
	console.log("blub");
	
	var plz = jQuery('.plzInput').val();
	console.log(plz);
	
    jQuery.post("home",
    	    {
    	        plz:plz
    	    },
    	    function(data, status){
    	        alert("Data: " + data + "\nStatus: " + status);
    	    });
}
</script>


</html>
