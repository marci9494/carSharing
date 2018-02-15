<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="stylesheet" type="text/css" href="/carSharing/html/css/home.css" media="screen" />
<jsp:include page="/theme/html/header.html" />


<body>
<html lang="de" >

<head>

  <meta charset="UTF-8">
  <link rel="shortcut icon" type="image/x-icon" href="https://production-assets.codepen.io/assets/favicon/favicon-8ea04875e70c4b0bb41da869e81236e54394d63638a1ef12fa558a4a835f1164.ico" />
  <link rel="mask-icon" type="" href="https://production-assets.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg" color="#111" />
  <title>Bewerte deinen Mieter!</title>
  
  
  
  
      
          
          

<style>
    
    
    
    
    body{background:#59ABE3;margin:0}
.form{width:340px;height:500px;background:#5a5a6e;border-radius:8px;box-shadow:0 0 40px -10px #000;margin:calc(50vh - 220px) auto;padding:20px 30px;max-width:calc(100vw - 40px);box-sizing:border-box;font-family:'Montserrat',sans-serif;position:relative}
h2{margin:10px 0;padding-bottom:10px;width:180px;color:white;border-bottom:3px solid #78788c}
input{width:100%;padding:10px;box-sizing:border-box;background:none;outline:none;resize:none;border:0;font-family:'Montserrat',sans-serif;transition:all .3s;border-bottom:2px solid #bebed2}
input:focus{border-bottom:2px solid #78788c}
p:before{content:attr(type);display:block;margin:28px 0 0;font-size:14px;color:white}
button{float:right;padding:8px 12px;margin:8px 0 0;font-family:'Montserrat',sans-serif;border:2px solid #78788c;background:0;color:#fff;cursor:pointer;transition:all .3s}
button:hover{background:#78788c;color:#fff}
div{content:'Hi';position:absolute;bottom:-15px;right:-20px;background:#50505a;color:#fff;width:320px;padding:16px 4px 16px 0;border-radius:6px;font-size:13px;box-shadow:10px 10px 40px -14px #000}
span{margin:0 5px 0 15px}
    
    
          body {
  background: #59ABE3;
}

.review-holder {
  position: relative;
  clear: both;
  display: inline-block;
}

.review:hover span {
  color: gold;
}
.review:hover span:before {
  content: "\e600";
}
.review span {
  
  -webkit-box-reflect: below -8px -webkit-gradient(linear, left top, left bottom, from(transparent), to(rgba(250, 250, 250, 0.3)));
  float: left;
  padding: 0 2px;
  color: #FFF;
  cursor: pointer;
}
.review span:after {
  font-family: Helvetica Neue,Helvetica,Arial,sans-serif;
  font-size: 12px;
  line-height: 16px;
}
.review span:hover:after {
  content: attr(data-description);
  position: absolute;
  left: calc(100% + 10px);
  white-space: nowrap;
  color: #FFF;
}
.review span:before {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  content: "\e601";
  font-family: 'apple';
  speak: none;
  font-style: normal;
  font-weight: normal;
  font-variant: normal;
  text-transform: none;
  line-height: 1;
}
.review span:hover ~ span {
  color: #FFF;
}
.review span:hover ~ span:before {
  content: "\e601";
}

@font-face {
  font-family: 'apple';
  src: url(data:application/x-font-ttf;charset=utf-8;base64,AAEAAAALAIAAAwAwT1MvMg6SAysAAAC8AAAAYGNtYXAaVcxYAAABHAAAAExnYXNwAAAAEAAAAWgAAAAIZ2x5ZqrfI3MAAAFwAAAA1GhlYWQD07CSAAACRAAAADZoaGVhB4UDxwAAAnwAAAAkaG10eAoAAHoAAAKgAAAAGGxvY2EAkgBOAAACuAAAAA5tYXhwAAkAGAAAAsgAAAAgbmFtZa5zCdEAAALoAAABM3Bvc3QAAwAAAAAEHAAAACAAAwQAAZAABQAAApkCzAAAAI8CmQLMAAAB6wAzAQkAAAAAAAAAAAAAAAAAAAABEAAAAAAAAAAAAAAAAAAAAABAAADmAQPA/8D/wAPAAEAAAAABAAAAAAAAAAAAAAAgAAAAAAACAAAAAwAAABQAAwABAAAAFAAEADgAAAAKAAgAAgACAAEAIOYB//3//wAAAAAAIOYA//3//wAB/+MaBAADAAEAAAAAAAAAAAAAAAEAAf//AA8AAQAAAAAAAAAAAAIAADc5AQAAAAABAAAAAAAAAAAAAgAANzkBAAAAAAEAAAAAAAAAAAACAAA3OQEAAAAAAQA9AAoDwwOPAAkAAAETIQUTJQUTJSECAHoBSf70X/7q/upf/vQBSQOP/qjK/p3V1QFjygAAAAACAD0ACgPDA48ACgAVAAABIQsBIQUDJQUDJQUHNycXNxc3BxcnA8P+t3p6/rcBDF8BFgEWXwEM/j2aP5K1ODi0kT+aAjcBWP6oyv6d1dUBY8r0gLd1Bc/PBXW3gAAAAAABAAAAAQAADdS5fF8PPPUACwQAAAAAANB5NgMAAAAA0Hk2AwAAAAADwwOPAAAACAACAAAAAAAAAAEAAAPA/8AAAAQAAAAAAAPDAAEAAAAAAAAAAAAAAAAAAAAGAAAAAAAAAAAAAAAAAgAAAAQAAD0EAAA9AAAAAAAKABQAHgA6AGoAAAABAAAABgAWAAIAAAAAAAIAAAAAAAAAAAAAAAAAAAAAAAAADgCuAAEAAAAAAAEACgAAAAEAAAAAAAIADgA5AAEAAAAAAAMACgAgAAEAAAAAAAQACgBHAAEAAAAAAAUAFgAKAAEAAAAAAAYABQAqAAEAAAAAAAoANABRAAMAAQQJAAEACgAAAAMAAQQJAAIADgA5AAMAAQQJAAMACgAgAAMAAQQJAAQACgBHAAMAAQQJAAUAFgAKAAMAAQQJAAYACgAvAAMAAQQJAAoANABRAGEAcABwAGwAZQBWAGUAcgBzAGkAbwBuACAAMQAuADAAYQBwAHAAbABlYXBwbGUAYQBwAHAAbABlAFIAZQBnAHUAbABhAHIAYQBwAHAAbABlAEYAbwBuAHQAIABnAGUAbgBlAHIAYQB0AGUAZAAgAGIAeQAgAEkAYwBvAE0AbwBvAG4ALgAAAwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA==) format("truetype"), url(data:application/font-woff;charset=utf-8;base64,d09GRgABAAAAAASIAAsAAAAABDwAAQAAAAAAAAAAAAAAAAAAAAAAAAAAAABPUy8yAAABCAAAAGAAAABgDpIDK2NtYXAAAAFoAAAATAAAAEwaVcxYZ2FzcAAAAbQAAAAIAAAACAAAABBnbHlmAAABvAAAANQAAADUqt8jc2hlYWQAAAKQAAAANgAAADYD07CSaGhlYQAAAsgAAAAkAAAAJAeFA8dobXR4AAAC7AAAABgAAAAYCgAAemxvY2EAAAMEAAAADgAAAA4AkgBObWF4cAAAAxQAAAAgAAAAIAAJABhuYW1lAAADNAAAATMAAAEzrnMJ0XBvc3QAAARoAAAAIAAAACAAAwAAAAMEAAGQAAUAAAKZAswAAACPApkCzAAAAesAMwEJAAAAAAAAAAAAAAAAAAAAARAAAAAAAAAAAAAAAAAAAAAAQAAA5gEDwP/A/8ADwABAAAAAAQAAAAAAAAAAAAAAIAAAAAAAAgAAAAMAAAAUAAMAAQAAABQABAA4AAAACgAIAAIAAgABACDmAf/9//8AAAAAACDmAP/9//8AAf/jGgQAAwABAAAAAAAAAAAAAAABAAH//wAPAAEAAAAAAAAAAAACAAA3OQEAAAAAAQAAAAAAAAAAAAIAADc5AQAAAAABAAAAAAAAAAAAAgAANzkBAAAAAAEAPQAKA8MDjwAJAAABEyEFEyUFEyUhAgB6AUn+9F/+6v7qX/70AUkDj/6oyv6d1dUBY8oAAAAAAgA9AAoDwwOPAAoAFQAAASELASEFAyUFAyUFBzcnFzcXNwcXJwPD/rd6ev63AQxfARYBFl8BDP49mj+StTg4tJE/mgI3AVj+qMr+ndXVAWPK9IC3dQXPzwV1t4AAAAAAAQAAAAEAAA3UuXxfDzz1AAsEAAAAAADQeTYDAAAAANB5NgMAAAAAA8MDjwAAAAgAAgAAAAAAAAABAAADwP/AAAAEAAAAAAADwwABAAAAAAAAAAAAAAAAAAAABgAAAAAAAAAAAAAAAAIAAAAEAAA9BAAAPQAAAAAACgAUAB4AOgBqAAAAAQAAAAYAFgACAAAAAAACAAAAAAAAAAAAAAAAAAAAAAAAAA4ArgABAAAAAAABAAoAAAABAAAAAAACAA4AOQABAAAAAAADAAoAIAABAAAAAAAEAAoARwABAAAAAAAFABYACgABAAAAAAAGAAUAKgABAAAAAAAKADQAUQADAAEECQABAAoAAAADAAEECQACAA4AOQADAAEECQADAAoAIAADAAEECQAEAAoARwADAAEECQAFABYACgADAAEECQAGAAoALwADAAEECQAKADQAUQBhAHAAcABsAGUAVgBlAHIAcwBpAG8AbgAgADEALgAwAGEAcABwAGwAZWFwcGxlAGEAcABwAGwAZQBSAGUAZwB1AGwAYQByAGEAcABwAGwAZQBGAG8AbgB0ACAAZwBlAG4AZQByAGEAdABlAGQAIABiAHkAIABJAGMAbwBNAG8AbwBuAC4AAAMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA=) format("woff");
  font-weight: normal;
  font-style: normal;
}

    </style>

  <script>
  window.console = window.console || function(t) {};
</script>

  
  
  <script>
  if (document.location.search.match(/type=embed/gi)) {
    window.parent.postMessage("resize", "*");
  }
</script>

    
    
    
    
    
    
    
    
    
    </style>



</head>







<form class="form">
  <h2>Deine Bewertung</h2>
  <p type="Zustand des Fahrzeuges:">
      <p></p>
       <span class='review-holder'>
           <span class='review'>
    <span data-description=' sehr schlecht'></span>
    <span data-description="schlecht"></span>
    <span data-description="ok"></span>
    <span data-description="gut"></span>
    <span data-description="sehr gut"></span>
  </span>
</span>
    
 </p>
  <p type="Freundlichkeit:">
      <p></p>
      
      <span class='review-holder'>
           <span class='review'>
    <span data-description=' sehr schlecht'></span>
    <span data-description="schlecht"></span>
    <span data-description="ok"></span>
    <span data-description="gut"></span>
    <span data-description="sehr gut"></span>
  </span>
</span>
    
    
    
    
    
    </p>
  <p type="Bezahlvorgang:">
      
      <p></p>
      
      <span class='review-holder'>
           <span class='review'>
    <span data-description=' sehr schlecht'></span>
    <span data-description="schlecht"></span>
    <span data-description="ok"></span>
    <span data-description="gut"></span>
    <span data-description="sehr gut"></span>
  </span>
</span>
    
    
    </p>
  <button>Send Message</button>
  <div>
    <span class="fa fa-phone"></span>Car2Go
    <span class="fa fa-envelope-o"></span> 
  </div>
</form>



</body>
<jsp:include page="/theme/html/footer.html" />

<script src="/carSharing/html/js/home.js"></script>




</html>
