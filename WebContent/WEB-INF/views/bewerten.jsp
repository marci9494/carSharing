<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="stylesheet" type="text/css" href="/carSharing/html/css/home.css" media="screen" />
<jsp:include page="/theme/html/header.html" />


<body>
<h1>Bewertungsformular</h1>
<p></p>

Wir bitten dich deinen Vertragspartner ehrlich und fair zu bewerten!<p></p>


<form action="bewertung.html">
  <fieldset>
    <legend>Freundlichkeit</legend>
    <ul>
      <li>
          <label for="flk">Freundlichkeit</label>
          <input id="flk" name="flk" type="number" value="0">
      </li>
    </ul>
  </fieldset>
  <fieldset>
    <legend>Zustand</legend>
    <p>
      <label for="Zustand">Zustand des Fahrzeuges</label>
      <select id="zsd" name="zsd">
        <option value="sg">sehr gut</option>
        <option value="g">gut</option>
        <option value="m">mittelmäßig</option>
        <option value="s">schlecht</option>
      </select>
    </p>
  </fieldset>
  <fieldset>
    <legend>Vorgangsabwicklung</legend>
    <dl>
      <dt>Vorgangsabwicklung</dt>
      <dd>
          <ul>
    <label for="Vorgangsabwicklung">Vorgangsabwicklung</label>
      <select id="vag" name="vag">
        <option value="sg">sehr gut</option>
        <option value="g">gut</option>
        <option value="m">mittelmäßig</option>
        <option value="s">schlecht</option>
      </select>
         </ul>
      </dd>
  </fieldset>
  <fieldset>
    <legend>Deine Nachricht an uns:</legend>
    <p>
      <label for="nachricht">Ihre Nachricht an uns</label>
      <textarea id="nachricht"></textarea>
    </p>
  </fieldset>
  <p><button>Abschicken!</button></p>
</form>



</body>
<jsp:include page="/theme/html/footer.html" />

<script src="/carSharing/html/js/home.js"></script>




</html>
