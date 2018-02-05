<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
	<jsp:include page="/theme/css/main.css" />
</style>
<jsp:include page="/theme/html/header.html" />


<body>
<br>
<br>
<br>
<br>
<br>
<br>
<form action="textarea.html" method="post"> 
   <div>  
      <label for="text">Mängel</label>
   <br>
   <br>
         <textarea id="text" name="text" cols="35" rows="4"></textarea> 
   <br>	
      <input type="submit" value="zurückgeben" />
   </div> 
</form> 
</body>
<jsp:include page="/theme/html/footer.html" />

</html>