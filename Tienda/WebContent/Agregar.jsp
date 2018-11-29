<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar Producto</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
 	<div class="container-fluid">
    	<div class="navbar-header">
      		<a class="navbar-brand" href="#">Tienda</a>
    </div>
    	<ul class="nav navbar-nav">
      		<li><a href="Index.jsp">Productos</a></li>
      		<%
      			HttpSession sesion = request.getSession();    			
      			if(sesion.getAttribute("nivel") != null && sesion.getAttribute("nivel") == "1"){      			
      		%>     		
      			<li class="active"><a href="Agregar.jsp">Agregar Productos</a></li>
      			<li><a href="Ventas.jsp">Registro Ventas</a></li>      		
      		<%}%>
      		
    	</ul>
    	<ul class="nav navbar-nav navbar-right">     		
      		<li> 
      			<%
      			if(sesion.getAttribute("usuario") != null){
      			
      			%>    			
				<a href="Login?cerrar=true"><span class="glyphicon glyphicon-log-out"></span> Cerrar sesión <%=sesion.getAttribute("usuario") %></a>
				<%}else{%>
					
				<a href="Login.jsp"><span class="glyphicon glyphicon-log-in"></span> Iniciar Sesión</a>	
				
				<%} %>					    		
      		</li>
    	</ul>
  	</div>
	</nav>

	<div class="container">
	<form action="IngresoProducto" method="post" encType="multipart/form-data">
		<label>Nombre </label> <input type="text" name="nombre" required="required" class="form-control">
		<label>Descripción </label> <input type="text" name="descripcion" required="required" class="form-control">
		<label>Stock </label> <input type="number" min="1" step="1" name="stock" required="required" class="form-control">
		<label>Precio </label> <input type="text" name="precio" required="required" class="form-control">
		<label>Imagen </label> <input type="file" name="imagen" required="required" class="form-control">
		<input type="submit" value="Agregar">
	</form>
	</div>





	<footer class="page-footer font-small blue">
		<div class="footer-copyright text-center py-3">©2018 Copyright
			<a href="https://www.facebook.com/jorge.martini97">Jorge Martini Schwenke</a>
		</div>
	</footer>
</body>
</html>