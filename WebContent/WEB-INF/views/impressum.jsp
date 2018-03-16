<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="/carSharing/html/css/cars.css" media="screen" />
<jsp:include page="/theme/html/header.jsp" />
<style>
<
jsp
:include
 
page
="/html/css/cars
.css
"
/
>
</style>



<body>
	<div class="banner-wrapper">
		<img class="banner" alt="Banner" src="/carSharing/html/img/header.jpg">
		<div id="header-content">
			<h1 id="header-content-text">Impressum</h1>
		</div>
	</div>

	<main> <br>





	<div class="content-wrapper">
		<div id=hallo>
			<!--Prüfung ob User eingeloggt ist-->
			<!--Wenn ja: Begrüßung und Logout Option-->
			<!--Wenn nein: nur Begrüßung-->
			<c:choose>
				<c:when test="${ user!=null}">
					<div class="logout">
						Herzlich Willkommen ${user.vorname} ${user.nachname} <a
							href="/carSharing/logout">(Logout)</a>
					</div>
					<input type="hidden" class="userEmail" value="${userEmail}" />
				</c:when>
				<c:otherwise>
        			Herzlich Willkommen
    			</c:otherwise>
			</c:choose>
		</div>
		<h2>Mietbedingungen</h2>
		<p>I. Allgemeines Für mit Kunden (nachfolgend „Mieter“ genannt)
			abgeschlossene Verträge sowie im Rahmen dieser Verträge erbrachten
			Leistungen gelten nur die nachfolgenden allgemeinen
			Vermietbedingungen, sofern nicht im Einzelfall individuelle
			Abweichungen vereinbart werden.Bedingungen des Mieters, auch soweit
			sie Gegenstand einer Auftragsbestätigung sind, sind nicht gültig,
			auch wenn im Einzelfall nicht ausdrücklich widersprochen wurde. II.
			Das Fahrzeug und seine Benutzung 1. Der Mieter erkennt durch die
			Übernahme des vermieteten Fahrzeuges (Kfz) an, dass es sich mitsamt
			Zubehör in verkehrssicherem, fahrbereitem, mangelfreiem und sauberem
			Zustand befindet und er die Wagenpapiere und Schlüssel erhalten hat.
			2. Der Mieter darf das Kfz in verkehrsüblicher Weise unter Beachtung
			der gesetzlichen Vorschriften, insbesondere der
			Straßenverkehrsordnung (bei Lkw-Anmietung: des
			Güterkraftverkehrsgesetzes), und der Gegebenheiten des Kfz (zulässige
			Belastung usw.) benutzen. 3. Das Kfz darf nur vom Mieter, den im
			Mietvertrag aufgeführten Fahrern oder von Berufsfahrern des Mieters,
			die einen entsprechenden gültigen Führerschein besitzen, gefahren
			werden. Der Mieter haftet für das Verschulden aller Personen, denen
			er den Gebrauch des Kfz überlässt, wie für eigenes Verschulden. 4.
			Das Kfz darf weder zu rechtswidrigen Zwecken verwendet noch
			zweckentfremdet oder unter Drogen- bzw. Alkoholeinfluss benutzt
			werden. Das Kfz darf nicht untervermietet werden. Sofern nicht der
			Vermieter zuvor schriftlich eingewilligt hat, darf das Kfz nicht
			außerhalb des öffentlichen Straßenverkehrs benutzt werden, nicht an
			Geländefahrten, Fahrschulübungen, Motorsportveranstaltungen oder
			deren Vorbereitung teilnehmen und nicht zu Testzwecken, im
			gewerblichen Personen- oder Güterfernverkehr, zum Abschleppen anderer
			Fahrzeuge oder auf Rennstrecken verwendet werden. 5. Das Kfz darf nur
			gemäß den Bedienungsvorschriften verwendet werden, es darf nur der
			vorgeschriebene Kraftstoff getankt werden. Besondere Bestimmungen für
			das Abstellen von Lkw sind zu beachten. Der Transport gefährlicher
			Stoffe mit dem Kfz ist untersagt. 6. Vorbestellungen von Kfz sind
			verbindlich. Der Vermieter braucht das Kfz jedoch nicht länger als
			eine Stunde nach dem vereinbarten Fahrtantritt bereit zu halten. 7.
			Der Mietpreis schließt die Kosten für den Treibstoff und Ölverbrauch
			nicht ein. Der Mieter zahlt folgende Beträge an den Vermieter: a) den
			Mietpreis für die abgelaufene Mietzeit zu den umseitig aufgeführten
			Sätzen; b) wenn vereinbart, Gebühren für die Vollkaskoversicherung,
			die lnsassenunfallversicherung sowie die Eintragung weiterer Fahrer,
			sowie gegebenenfalls Rückführungsgebühren; c) alle auf die Positionen
			a) bis c) erhobenen Steuern sowie alle im Zusammenhang mit der
			Benutzung des Fahrzeuges anfallenden Gebühren, Abgaben, Bußgelder und
			Strafen, für die der Vermieter in Anspruch genommen wird, es sei
			denn, sie sind auf Verschulden des Vermieters zurückzuführen; d) alle
			Kosten, die dem Vermieter durch die Eintreibung von fälligen
			Forderungen gegen den Mieter entstehen. Der Vermieter kann vor
			Übergabe des Kfz eine Vorauszahlung bis zur Höhe einer Monatsmiete,
			mindestens jedoch 100,- EUR verlangen. III. Versicherung 1. Für das
			Kfz bestehen folgende Versicherungen nach den Allgemeinen
			Kraftfahrzeugversicherungsbedingungen. (AKB):
			Haftpflichtversicherung, auf Anfrage Teilkaskoversicherung mit
			Selbstbeteiligung. Fahrer, Fahrzeug, Insassen, Gepäck, Waren usw.
			sind nicht versichert. 2. Nur auf schriftlichen Wunsch des Mieters
			wird auf dessen Kosten eine Vollkaskoversicherung abgeschlossen
			und/oder eine lnsassenunfallversicherung. Über weitergehende
			Versicherungswünsche des Mieters muss eine schriftliche Vereinbarung
			geschlossen werden. IV. Pflichten des Mieters 1. Der Mieter
			verpflichtet sich, das Kfz pfleglich und unter Beachtung der
			technischen Regeln zu behandeln sowie es ständig auf Verkehrs- und
			Betriebssicherheit zu überwachen (Öl- und Wasserstand, Reifendruck,
			Keilriemen, Bremsen, Türverschluss usw.), es zu verschließen, das
			Lenkradschloss einrasten zu lassen und das Kfz an sicherem Ort
			abzustellen. Die Schlüssel des Kfz sind jederzeit für Unbefugte
			unzugänglich zu verwahren und eine vorhandene Alarmanlage ist zu
			benutzen. Bei längerer Benutzung hat der Mieter nach Rücksprache mit
			dem Vermieter die fälligen Wartungsarbeiten in einer autorisierten
			Vertragswerkstatt durchführen zu lassen; die Kosten erstattet der
			Vermieter. 2. Bei Betriebsunfähigkeit auf freier Strecke ist das Kfz
			zu sichern und zu bewachen. V. Reparatur 1. Wird eine Reparatur
			notwendig, so trägt der Vermieter dafür die Kosten, wenn die Ursache
			hierfür weder auf unsachgemäßer Behandlung des Kfz durch den Mieter
			noch auf dessen Verschulden oder dem seiner Erfüllungsgehilfen
			(Fahrer und andere) beruht. Hat der Vermieter die Kosten zu tragen,
			so hat der Mieter ihn vor Beginn der Reparatur – wenn mit Kosten von
			mehr als 25 ,- EUR (ohne MwSt.) zu rechnen ist – zu unterrichten und
			seine Weisungen einzuholen. Unterlässt der Mieter dies, hat der
			Vermieter nur die Kosten für die ihm nachgewiesenen, unbedingt
			notwendigen Reparaturen zu erstatten. Bereicherungsansprüche des
			Mieters aus weitergehenden Reparaturen sind ausgeschlossen. 2.
			Versagt der Kilometerzähler, hat der Mieter ihn unverzüglich in einer
			geeigneten Werkstatt instand setzen zu lassen, wobei die Eichung
			erhalten bleiben muss. Von einer solchen lnstandsetzung ist der
			Vermieter unverzüglich schriftlich zu unterrichten. Andernfalls ist
			der Vermieter berechtigt, der Abrechnung eine Fahrstrecke von 600 km
			pro Miettag zugrunde zu legen. VI. Unfall, Diebstahl, Brand 1. Jeder
			Haftpflicht- oder Kaskoschaden ist dem Vermieter unverzüglich zu
			melden. In jedem Fall ist sofort die Polizei zu verständigen und mit
			der Aufnahme eines Protokolls zu beauftragen. 2. Gegnerische
			Ansprüche dürfen weder gegenüber Unfallbeteiligten noch gegenüber
			Ermittlungsbeamten anerkannt werden. Überlässt der Mieter das
			Fahrzeug einem Dritten, so hat er diesen entsprechend zu
			verpflichten. 3. Der Mieter hat dem Vermieter, selbst bei
			geringfügigen Schäden, einen ausführlichen schriftlichen Bericht
			unter Vorlage einer Skizze zu erstellen. Der Bericht über Unfall,
			Diebstahl oder Brand muss insbesondere Namen und Anschriften der
			beteiligten Personen und etwaiger Zeugen sowie die amtlichen
			Kennzeichen der beteiligten Fahrzeuge und Angaben über ihre Besitzer
			(Halter) enthalten. 4. Bei einem Unfall darf sich der Mieter vor
			Abschluss der polizeilichen Unfallaufnahme nicht vom Unfallort
			entfernen (Unfallflucht). 5. Bei einem Diebstahl des Fahrzeuges, von
			Fahrzeugteilen oder -zubehör bzw. Einbruch in das Fahrzeug oder einer
			Beschädigung durch Unbekannte während des Parkens hat der Mieter
			sofort Anzeige bei der Polizei zu erstatten und anschließend
			unverzüglich unter Vorlage der polizeilichen Bescheinigung den
			Vermieter zu informieren. VII. Haftung 1. Die Haftung des Vermieters
			wird für Fälle normaler Fahrlässigkeit dem Grunde und der Höhe nach
			auf denjenigen Schaden begrenzt, der durch eine
			Kraftfahrzeughaftpflichtversicherung im Rahmen der AKB abdeckbar ist,
			es sei denn, es handelt sich um eine Verletzung wesentlicher
			Vertragspflichten (Kardinalpflichten). In diesem Fall sowie bei
			Vorsatz und grober Fahrlässigkeit bleibt die gesetzliche Haftung
			bestehen. 2. Der Mieter hat das Kfz in demselben Zustand
			zurückzugeben, in dem er es übernommen hat. Der Mieter haftet für die
			Beschädigung des Kfz und für die Verletzung seiner vertraglichen
			Pflichten. Er hat in einem solchen Fall auch die Schadensnebenkosten
			zu ersetzen, insbesondere für Sachverständige, Rechtsverfolgung,
			Abschleppen und Mietausfall sowie den Betrag der Wertminderung des
			Kfz; Mietausfallkosten sind die Beiträge in Höhe einer Tagesmiete für
			jeden Tag an dem das beschädigte Kfz dem Vermieter nicht zur
			Verfügung steht. Die Tagesmiete setzt sich aus dem Grundbetrag und
			aus dem Entgelt für eine Fahrstrecke von 100 km zusammen. Dem Mieter
			bleibt der Nachweis offen, dass dem Vermieter kein oder ein
			geringerer Schaden entstanden ist. 3. Bei den durch die
			Teilkaskoversicherung abgedeckten Gefahren (unter anderem Diebstahl,
			Brand, Glasbruch) beschränkt sich die Haftung des Mieters auf seinen
			Selbstbeteiligungssatz (vgl. oben III.1.) im Rahmen der AKB. Hat der
			Mieter gemäß III.2. den Abschluss einer Vollkaskoversicherung
			gewählt, so beschränkt sich seine Haftung auch wegen der hierdurch
			abgedeckten Gefahren (Unfallschäden am Mietfahrzeug) auf seine
			Selbstbeteiligung. lst die Selbstbeteiligung ausgeschlossen, entfällt
			auch dieser Teil seiner Haftung. Für Schäden, die auf
			Bedienungsfehler des Mieters zurückzuführen sind, haftet der Mieter
			in jedem Fall uneingeschränkt. Weiter haftet der Mieter in jedem Fall
			unbeschränkt bei zumindest grob fahrlässiger Herbeiführung des
			Schadens, bei Fahrerflucht, alkohol- oder drogenbedingter
			Fahruntüchtigkeit und allen anderen Fällen, in denen eine Berufung
			auf eine begrenzte Haftung unzulässig ist, ferner bei schuldhafter
			Verletzung seiner Vertragspflichten oder Obliegenheiten nach Ziffer
			II.3., 4., 5. oder VI., es sei denn, die AKB sehen trotz der
			Pflichtverletzung Versicherungsschutz vor. 4. Soweit der
			Kaskoversicherer die Schäden und Schadennebenkosten nicht ersetzt,
			haftet der Mieter dem Vermieter im Falle seines Verschuldens für die
			Schäden und Schadensnebenkosten (Ziffer VII.2).
			Verschuldensunabhängig ist der Mieter in jedem Fall verpflichtet, den
			bei Abschluss einer Teil- oder Vollkaskoversicherung vereinbarten
			Selbstbehalt (Ziffer III.) zu tragen. 5. Soweit ein Dritter dem
			Vermieter die Schäden ersetzt, wird der Mieter von seiner
			Ersatzpflicht frei. 6. Der Mieter stellt den Vermieter von jeder
			Haftung für Schäden an oder Verluste von Gegenständen frei, die vom
			Mieter oder jemand anderem vor, während oder nach der Wagenmiete in
			dem Fahrzeug befördert, aufbewahrt oder zurückgelassen worden sind.
			VIII. Rückgabe des Kfz 1. Der Mieter hat das Kfz mit den
			vollständigen Wagenpapieren und sämtlichen ihm ausgehändigten
			Schlüsseln spätestens am Ende der vereinbarten Mietzeit dem Vermieter
			am vereinbarten Ort zurückzugeben, und zwar während der Geschäftszeit
			des Vermieters. Die Rückgabe außerhalb der Geschäftszeit erfolgt auf
			Risiko des Mieters. 2. Eine Verlängerung der Mietzeit bedarf der
			Einwilligung des Vermieters vor Ablauf der Mietzeit. 3. Wird das Kfz
			mit vollständigen Wagenpapieren und sämtlichen Schlüsseln schuldhaft
			nicht rechtzeitig zurückgegeben, hat der Mieter dem Vermieter für
			jeden angefangenen Tag der verspäteten Rückgabe des Kfz als
			Vertragsstrafe die vereinbarte Miete zu zahlen. War ein Sondertarif
			vereinbart, so wird die Miete für die gesamte Mietzeit zum jeweils
			gültigen Standardtarif abgerechnet. Sollte ein darüber hinaus
			gehender Schaden entstanden sein, so hat der Mieter diesen zu
			ersetzen. Der Mieter haftet für sämtliche nach Ablauf der Mietzeit
			eingetretenen Haftpflicht und Kaskoschäden. 4. Der Vermieter ist
			berechtigt, innerhalb von zwei Werktagen nach Entdeckung von Mängeln,
			für die der Mieter haftbar ist, gegenüber dem Mieter Mängel des Kfz
			zu beanstanden. IX. Kündigung 1. Kommt der Mieter mit der Bezahlung
			einer Mietrate zu einem nicht unerheblichen Teil in Verzug oder wird
			dem Vermieter die Fortsetzung des Mietverhältnisses unzumutbar,
			insbesondere weil der Mieter eine wesentliche Vertragspflicht
			verletzt hat, dann ist der Vermieter berechtigt, den Vertrag fristlos
			zu kündigen. Macht der Vermieter von diesem Recht Gebrauch, so bleibt
			der Mieter dem Vermieter zur Zahlung der vereinbarten Miete bis zum
			Ende der vertraglich vorgesehenen Mietzeit verpflichtet, soweit der
			Vermieter das Kfz nicht an Dritte weitervermieten kann. Dem Mieter
			steht der Nachweis offen, dass dem Vermieter kein oder ein geringerer
			Schaden entstanden ist. 2. Der Mieter ist zur fristlosen Kündigung
			berechtigt, wenn das Kfz nicht fahrbereit ist und der Vermieter kein
			Ersatzfahrzeug zur Verfügung stellt. X. Verschiedenes 1. Der Mieter
			ist damit einverstanden, dass seine persönlichen Daten im Rahmen der
			Zweckbestimmung des Mietvertrages oder eines vertragsähnlichen
			Vertrauensverhältnisses durch den Vermieter gespeichert werden. 2.
			Der Mieter ist zu einer Aufrechnung nur berechtigt, wenn seine
			Forderungen unbestritten, entscheidungsreif oder rechtskräftig
			festgestellt sind. Dies gilt nicht für Ansprüche aus Schadensersatz
			wegen eines Mangels der Mietsache (§ 536a BGB) und für
			Rückforderungsansprüche wegen zuviel gezahlter Miete. 3. Nebenabreden
			sind nicht getroffen worden. Änderungen und Ergänzungen des Vertrages
			bedürfen der Schriftform. Dies gilt auch für eine Aufhebung der
			Schriftformklausel. 4. Sollten einzelne der Vertragsbestimmungen
			unwirksam oder undurchsetzbar sein oder werden, so wird dadurch die
			Wirksamkeit oder Durchsetzbarkeit der übrigen Bestimmungen nicht
			berührt. Die unwirksame oder undurchsetzbare Bestimmung ist als durch
			diejenige wirksame und durchsetzbare Bestimmung ersetzt anzusehen,
			die dem von den Parteien mit der unwirksamen oder undurchsetzbaren
			Bestimmung verfolgten wirtschaftlichen Zweck am nähesten kommt. 5.
			Der Sitz der Vermieterin ist der Erfüllungsort. Er ist auch der
			Gerichtsstand, sofern der Mieter Vollkaufmann ist oder keinen
			allgemeinen Gerichtsstand im Inland hat oder nach Vertragsschluss
			seinen Wohnsitz oder gewöhnlichen Aufenthalt ins Ausland verlegt hat
			oder beides zur Zeit der Klageerhebung nicht bekannt ist. 6. Für alle
			Rechtsbeziehungen zwischen uns und dem Mieter gilt das Recht der
			Bundesrepublik Deutschland.</p>

		<h2>Allgemeine Datenschutzerklärung</h2>
		<p>Durch die Nutzung unserer Website erklären Sie sich mit der
			Erhebung, Verarbeitung und Nutzung von Daten gemäß der nachfolgenden
			Beschreibung einverstanden. Unsere Website kann grundsätzlich ohne
			Registrierung besucht werden. Dabei werden Daten wie beispielsweise
			aufgerufene Seiten bzw. Namen der abgerufenen Datei, Datum und
			Uhrzeit zu statistischen Zwecken auf dem Server gespeichert, ohne
			dass diese Daten unmittelbar auf Ihre Person bezogen werden.
			Personenbezogene Daten, insbesondere Name, Adresse oder
			E-Mail-Adresse werden soweit möglich auf freiwilliger Basis erhoben.
			Ohne Ihre Einwilligung erfolgt keine Weitergabe der Daten an Dritte.</p>


		<p>
			Quelle: <a
				href="https://www.anwalt.de/vorlage/muster-datenschutzerklaerung.php">Muster-Datenschutzerklärung
				von anwalt.de</a>
		</p>

		<h2>Impressum und Kontakt</h2>
		<p>&copy; carNow GmbH</p>
		<p>Duale Hochschule Baden-Württemberg Heidenheim</p>
		<p>Studiengang WWI16B - carNow Gruppe</p>

	</div>
	</main>
</body>
<jsp:include page="/theme/html/footer.html" />

<script src="/carSharing/html/js/impressum.js"></script>




</html>
