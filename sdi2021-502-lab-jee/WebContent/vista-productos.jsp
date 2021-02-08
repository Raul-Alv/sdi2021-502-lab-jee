<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>Productos de la base de datos</title>
	<meta charset="UTF-8">
	<meta name="viewport"	content="width=device-width,	initial-scale=1"/>
	<link rel="stylesheet"	
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h2>Lista de productos</h2>
	<ul>
		<c:forEach var="productos" items="${productosTienda}">
			<tr>
				<li>${productos.nombre} - ${productos.precio}</li>
			</tr>
		</c:forEach>
	</ul>
</body>
</html>