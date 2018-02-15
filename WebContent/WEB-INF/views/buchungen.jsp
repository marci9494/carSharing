<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="/carSharing/html/css/login.css" media="screen" />
<jsp:include page="/theme/html/header.html" />

<body>
	<head>
<style>
    
    
    
    
    body{background:#fff;margin:0px;}
.form{width:340px;height:470px;background:#e6e6e6;border-radius:8px;box-shadow:0 0 40px -10px #000;margin:calc(50vh - 220px) auto;padding:20px 30px;max-width:calc(100vw - 40px);box-sizing:border-box;font-family:'Montserrat',sans-serif;position:relative}
h2{margin:10px 0;padding-bottom:10px;width:180px;color:#78788c;border-bottom:3px solid #78788c}
input{width:100%;padding:10px;box-sizing:border-box;background:none;outline:none;resize:none;border:0;font-family:'Montserrat',sans-serif;transition:all .3s;border-bottom:2px solid #bebed2}
input:focus{border-bottom:2px solid #78788c}
p:before{content:attr(type);display:block;margin:28px 0 0;font-size:14px;color:#5a5a5a}
button{float:right;padding:8px 12px;margin:8px 0 0;font-family:'Montserrat',sans-serif;border:2px solid #78788c;background:0;color:#5a5a6e;cursor:pointer;transition:all .3s}
button:hover{background:#78788c;color:#fff}
div{content:'Hi';position:absolute;bottom:-15px;right:-20px;background:#50505a;color:#fff;width:320px;padding:16px 4px 16px 0;border-radius:6px;font-size:13px;box-shadow:10px 10px 40px -14px #000}
span{margin:0 5px 0 15px}
    
    
    
    
    
    
    
    
    
    </style>



</head>







<form class="form">
  <h2>Deine Buchungen</h2>
  <p type="Name:"><input placeholder="Dein Name..."></input></p>
  <p type="Vorname:"><input placeholder="Dein Vorname"></input></p>
  <p type="Buchungsnummer:"><input placeholder="Deine Buchungsnummer"></input></p>
  <button>Send Message</button>
  <div>
    <span class="fa fa-phone"></span>Car2Go
    <span class="fa fa-envelope-o"></span> 
  </div>
</form>

</body>
<jsp:include page="/theme/html/footer.html" />

</html>