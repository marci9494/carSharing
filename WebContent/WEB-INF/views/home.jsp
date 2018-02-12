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
		<select>
			<option value="10">
				10Km
			</option>
		</select>
		<input type="button" value="Suchen" onclick="searchCar()"/>
	</div>

	<div class="foundCars">
	</div>


<div id="dummyCarWrapper" class="carWrapper" style="display:none">
	<div class="carPicture"></div>
	<div class="carDetails"></div>
	<div><input type="button" value="Mieten" /></div>

</div>

</body>
<jsp:include page="/theme/html/footer.html" />

<script src="/carSharing/html/js/home.js"></script>

<script>
function searchCar(){	
	var plz = jQuery('.plzInput').val();
	console.log(plz);
	
    jQuery.post("home",
    	    {
    	        plz:plz
    	    },
    	    function(data, status){
    	    	
    	    	for (var i = 0; i < data.length; i++) {
    	    		jQuery('.foundCars').append(jQuery('<span>').text(data[i]));
    	    	}
    	    	
    	    
    	    	<%--
    	    	Wird wieder benötigt
    	    	console.log(data[0].id)
    	    	for (var i = 0; i < data.length; i++) {
					var carWrapper = jQuery('#dummyCarWrapper').clone();
					carWrapper.removeAttr('id');
					
					
					carWrapper.show();
					jQuery('.foundCars').append(carWrapper);
				}
    	    	jQuery('.foundCars').append(jQuery('<div>').css('clear','both'));
    	    	--%>
    	    });
}
</script>


</html>
