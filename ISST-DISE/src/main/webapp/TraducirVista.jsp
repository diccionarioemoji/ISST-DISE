<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DISE - Diccionario Social Emoji - Traducir</title>
<link href="css/estilos.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="clientjs/tabs.js"></script>
<script type="text/javascript" src="clientjs/ponerEmojis.js"></script>
</head>


<body>

	<c:if test="${not empty user}">
		<header> Usuario:&nbsp;<c:out value="${user}" />&nbsp;|&nbsp;<a
			href="<c:url value="${url}"/>"><c:out value="${urlLinktext}" /></a>
		</header>
	</c:if>

	<h1 class="titulo">Diccionario Social Emoji</h1>

	<nav id="nav">
	<ul>
		<li class="tab"><a href="/isst_dise">Traductor</a></li>
		<li class="tab"><a href="/votar_traduccion">Votar Traduccion</a></li>
		<li class="tab"><a href="/nuevoemoji">Nuevo Emoji</a></li>
		<li class="tab"><a href="/ranking">Ranking</a></li>

	</ul>
	</nav>

	<!-- Seleccion de pestaña de traduccion -->
	<div class="tab">
		<button class="tablinks" onclick="openTraductor(event, 'Esp_Emoji')">Español
			-> Emoji</button>
		<button class="tablinks" onclick="openTraductor(event, 'Emoji_Esp')">Emoji
			-> Español</button>
	</div>

	<!-- Pestaña de traduccion de español a emoji -->
	<div id="Esp_Emoji" class="tabcontent" style="display: block">
		<div>
			<textarea form="textoATraducirEspEmo"  name="escrito" class="caja-texto"  placeholder="Escribe aquí el texto en castellano"></textarea>
			<div id="traduccionAEmoji" class="caja" ">
				<c:out value="${textoFinal}" escapeXml="false"/>
			</div>
			<!--<script type="text/javascript">document.getElementById("traduccionAEmoji").innerHTML=textoFinal</script>-->
		</div>
		<form id="textoATraducirEspEmo" action="/traducirEspEmo" method="post" acceptcharset="utf-8">
			<button type="submit" class="escrito">Traducir</button>
		</form>
	</div>

	<!-- Pestaña de traduccion de emoji a español -->
	<div id="Emoji_Esp" class="tabcontent" style="display: none">
		<div style="float:left">
			<div id="seleccionEmoji" class="cajita">
				<c:forEach items="${emojis}" var="emoji">
					<img onclick='insertarEmoji(this)' src="${emoji.imagen}" alt="${emoji.traducciones[0].traduccion}" width="30px" height="30px"/>	
				</c:forEach>
			</div>
			<div id="campo" class="cajita">
				<!-- Aquí se insertan los emojis con ponerEmojis.js -->
			</div>
		</div>
		<textarea id="traduccion" class="caja-texto" readonly placeholder="Aquí aparecerá la traducción"></textarea>
	</div>

</body>
</html>