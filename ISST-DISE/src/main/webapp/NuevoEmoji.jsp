<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page
	import="com.google.appengine.api.blobstore.BlobstoreServiceFactory"%>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService"%>
<%
	BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DISE - Diccionario Social Emoji - Traducir</title>
<link href="css/estilos.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="clientjs/tabs.js"></script>
<script type="text/javascript" src="clientjs/validarform.js"></script>
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
	<c:if test="${not empty user}">
	<div>
		<h2>
			Proponga su nuevo Emoji
			</h2>
				<form action="<%=blobstoreService.createUploadUrl("/upload")%>"
						enctype="multipart/form-data"  method="post">
					<p>Proponga la traducción inicial</p>
					<input type="text" placeholder="Escriba aquí su traducción"
						name="traduccion">
					<p>Suba su archivo a continuación</p>
					<input type="file" name="file" />
					<input type="button" value="Upload document" onclick="comprueba_extension(this.form, this.form.file.value)" />

				</form>
	</div>
	</c:if>

	<c:if test="${empty user}">
		<p>
			Para poder subir un nuevo emoji necesita estar registrado, autentíquese <a
				href="<c:url value="${url}"/>" class="btn btn-success">aquí</a>
		</p>
	</c:if>

</body>
</html>