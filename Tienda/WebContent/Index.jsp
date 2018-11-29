<%@page session="true"%>
<%@page import="com.str0mp.tienda.modelo.*,java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<title>Tienda</title>
</head>
<body>

	<nav class="navbar navbar-inverse">
 	<div class="container-fluid">
    	<div class="navbar-header">
      		<a class="navbar-brand" href="#">Tienda</a>
    </div>
    	<ul class="nav navbar-nav">
      		<li class="active"><a href="Index.jsp">Productos</a></li>
      		<%
      			HttpSession sesion = request.getSession();    			
      			if(sesion.getAttribute("nivel") != null && sesion.getAttribute("nivel") == "1"){      			
      		%>     		
      			<li><a href="Agregar.jsp">Agregar Productos</a></li>
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
		<table align="center" width="900">
			<%
			ProductosDAO prod = new ProductosImpl();
			ArrayList<ProductosVO> lista = prod.listaProductos();			
			int salto = 0;
			for(int x=0; x < lista.size(); x++){
				ProductosVO p = lista.get(x);			
			%>			
			<th>
			<img src="imagenes/<%=p.getImagen()%>" width="150" height="150" class="center-block">
			<h2 style="text-align: center;"><%=p.getNombre()%></h2>
			<h3 style="text-align: center;"><%=p.getDescripcion() %></h3>
			<h4 style="text-align: center;">Stock : <%=p.getStock()%></h4>
			<h4 style="text-align: center;">$ <%=p.getPrecio() %></h4><br><br>	
			<form action="AgregarCarro" method="post">						
			<input type="hidden" value="<%=p.getId()%>" class="form-control input-sm" name="idproducto">
			<div class="col-xs-8">	
			<input type="number" min="1" step="1" max="<%=p.getStock()%>" class="form-control input-sm" name="cantidad" required="required" placeholder="Añadir al carrito">
			</div>
			<div class="col-xs-4">
			<button type="submit" class="btn btn-xs">
   			<span class="btn glyphicon glyphicon-shopping-cart"></span>
			</button>			
			</div>
			</form>		
			</th>
			
			<%
			salto++;
			if(salto==3){%>
				<tr>
			<%
				salto =0;
			}
			
			} %>		
		</table>	
	</div>




	<footer class="page-footer font-small blue">
		<div class="footer-copyright text-center py-3">©2018 Copyright
			<a href="https://www.facebook.com/jorge.martini97">Jorge Martini Schwenke</a>
		</div>
	</footer>
</body>
</html>