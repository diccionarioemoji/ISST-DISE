<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DISE - Diccionario Social Emoji - Traducir</title>
<link href="css/estilos.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="clientjs/tabs.js"></script>
</head>


<body>
	<c:if test="${not empty user}">
		<header>
			Usuario:&nbsp;<c:out value="${user}"/>&nbsp;|&nbsp;<a href="<c:url value="${url}"/>"><c:out value="${urlLinktext}"/></a>
		</header>
	</c:if>
	
	<h1 class="titulo">Diccionario Social Emoji</h1>
	<p>Imagen: <img src="<c:out value="${emoji1.imagen}"/>"/></p>
	<p>Traduccion: <c:out value="${emoji1.traducciones[0].traduccion}"/></p>
	
	<!-- Seleccion de pesta�a de traduccion -->
	<div class="tab">
		<button class="tablinks" onclick="openTraductor(event, 'Esp_Emoji')">Espa�ol -> Emoji</button>
		<button class="tablinks" onclick="openTraductor(event, 'Emoji_Esp')">Emoji -> Espa�ol</button>
	</div>
	
	<!-- Pesta�a de traduccion de espa�ol a emoji -->
	<div id="Esp_Emoji" class="tabcontent">
		<span>
			<textarea float="left" rows="20" cols="25" placeholder="Escribe aqu� el texto en castellano"></textarea>
			<div id="traduccionAEmoji" class="caja" float="left" contenteditable="true">
				<p placeholder="Aqu� aparecer� la traducci�n"></p>
			</div>
		</span>
		<p>Mostrar cuadros de traduccion</p>
	</div>

	<!-- Pesta�a de traduccion de emoji a espa�ol -->
	<div id="Emoji_Esp" class="tabcontent">
		<span>
			<div float="left">
				<div class="cajita"></div>
				<div class="cajita"></div>
				<!-- INSERTAR TABLA CON EMOJIS !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
			</div>
			
			<textarea float="left" readonly rows="20" cols="25" placeholder="Aqu� aparecer� la traducci�n"></textarea>

		</span>
		<p>Mostrar cuadros de traduccion y emojis para a�adirlos al texto a traducir</p>
	</div>
	
</body>
</html>