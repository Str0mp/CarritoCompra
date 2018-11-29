<%@page session="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Login - Tienda</title>
</head>
<body>

<h1 align="center">Formulario de acceso</h1>
<hr>
	<div class="container">	
	<form action="Login" method="post">
	
		<div class="form-group">
			<label class="control-label col-sm-2" for="usuario">Usuario:</label>
			<div class="col-sm-10">
				<input type="text" name="usuario" class="form-control" placeholder="Ingresa tú usuario" required="required"><br>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2" for="contraseña">Contraseña:</label>
			<div class="col-sm-10">
				<input type="password" name="contraseña" class="form-control" placeholder="Ingresa tú contraseña" required="required"><br>
			</div>
		</div>
		
		<div class="form-group"> 
    		<div class="col-sm-offset-2 col-sm-10">
      			<input type="submit" value="Entrar" name="ingresar" class="btn btn-success">
    		</div>
    	</div>
		
		
	</form>	
	</div>
	
	<footer class="page-footer font-small blue">
		<div class="footer-copyright text-center py-3">©2018 Copyright
			<a href="https://www.facebook.com/jorge.martini97">Jorge Martini Schwenke</a>
		</div>
	</footer>
</body>
</html>