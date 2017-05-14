<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DISE Votar Traducción</title>
<link href="css/estilos.css" type="text/css" rel="stylesheet" />
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
		<li class="tab"><a href="/NuevoEmoji.jsp">Nuevo Emoji</a></li>
		<li class="tab"><a href="/ranking">Ranking</a></li>

	</ul>
	</nav>

<div class="imagen">
		<img src="${emoji.imagen}" />
	</div>
	<div >
	<div class="traducciones">
		<form action="/votar_traducciones" method="post" acceptcharset="utf-8">
			<c:forEach items="${emoji.traducciones}" var="traduccion"
				varStatus="n">
				<input type="radio" value="${n.index}" name="n" required>${traduccion.traduccion}<br>
			</c:forEach>
			<input type="hidden" value="${emoji.imagen}" name="imagen"> <input
				type="submit" value="Enviar" class="btn btn-primary" />
		</form>
	</div>
	<div class="votaciones">
		<c:forEach items="${emoji.traducciones}" var="traduccion">
			<p class="votaciones">${traduccion.votos}</p>
		</c:forEach>
	</div>
	
	</div>
	
	<div class="NuevaTraduccion" style = "clear:both">
		<form action="/nueva_traduccion" method="post" acceptcharset="utf-8">
			<input type="text" placeholder="Proponga aquí su traducción" name="nuevaTraduccion">
			<input type="hidden" value="${emoji.imagen}" name="imagen"> 
			<input type="submit" value="Proponer Traduccion" class="btn btn-primary" />
		</form>
	</div>


</body>
</html>