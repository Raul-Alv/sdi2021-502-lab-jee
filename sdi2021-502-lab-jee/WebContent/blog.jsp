<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<title>Blog</title>
		<meta charset="utf-8"/>
		<meta name="viewport" content="width=device-width, initial-scale=1"/>
		<link rel="stylesheet"	
			href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	
	<body>
		<div class="container" id="contenedor-principal">
			<h2>Blog</h2>
			<form class="form-horizontal" method="post" action="login.jsp">
				<div class="form-group">
					<label class="control-label	col-sm-2" for="nombre">Nombre:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="nombre" required="true"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label	col-sm-2" for="comentario">Comentario:</label>
					<div class="col-sm-10">										
						<input type="text" class="form-control" name="comentario"	
						 required="true"/>
					</div>
				</div>
				<div class="form-group">								
					<div class="col-sm-offset-2	col-sm-10">
						<button type="submit" class="btn	btn-primary">Comentar</button>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>