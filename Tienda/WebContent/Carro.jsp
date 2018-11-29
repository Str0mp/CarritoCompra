<%@page import="com.str0mp.tienda.modelo.ProductosVO"%>
<%@page import="com.str0mp.tienda.modelo.ProductosImpl"%>
<%@page import="com.str0mp.tienda.modelo.ProductosDAO"%>
<%@page import="com.str0mp.tienda.modelo.Articulo"%>
<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="js/carro.js"></script>
<title>Carro - Tienda</title>
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
      			HttpSession sesion = request.getSession(true);    			
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



	<%
		ArrayList<Articulo> listaArticulos = sesion.getAttribute("carro") == null ? null : (ArrayList)sesion.getAttribute("carro");
	
	%>
	
	<div class="container" id="cart-container">
	<br><br>
		<table class="table" id="shop-table">
			<thead>
			 <tr>			 	
			 	<th scope="col">Producto</th>
			 	<th scope="col"></th>
			 	<th scope="col">Precio</th>
			 	<th scope="col">Cantidad</th>
			 	<th scope="col">Total</th>			 	
			 </tr>
			</thead>
			
			<%
				ProductosDAO prod = new ProductosImpl();
			
				int total = 0;
				if(listaArticulos != null){
				for(Articulo a : listaArticulos){
					ProductosVO producto = prod.obtenerProducto(a.getIdProducto());				
					total += a.getCantidad() * producto.getPrecio();
			%>
			
			<tbody>
				<tr>
					<th><img alt="" src="imagenes/<%= producto.getImagen()%>" width="150" height="150"></th>
					<th><%=producto.getNombre() %></th>
					<th><%=producto.getPrecio() %></th>
					<th><input type="number" min="1" max="<%=producto.getStock()%>" step="1" value="<%=a.getCantidad()%>"></th>
					<th><%= Math.round(producto.getPrecio() * a.getCantidad()) %></th>
					<th>
						<span id="idarticulo" style="display: none;"><%=producto.getId()%></span>
						<a href="" id="deleteitem" class="btn tb-lg glyphicon glyphicon-remove-sign"></a>
					</th>
				
				
				</tr>
			
			
			</tbody>
			
			<%		}
				}							
				%>		
		</table>
		<%if(listaArticulos == null){%>
			
			<div id="contenedor">
				<h4> No hay articulos en el carro</h4>
			</div>
			
		<%} %>
		
		
	
	<div class="container">
		<div class="col-sm-8"></div>
		<div class="col-sm-4">
			<h2 id="total">Total: <%=total%></h2>
			<h3>Despacho: Retiro en tienda</h3>
			<h3>Descuentos: 0</h3>
		
		</div>
	
	</div>
	
	
	
	</div>






	
	<footer class="page-footer font-small blue">
		<div class="footer-copyright text-center py-3">©2018 Copyright
			<a href="https://www.facebook.com/jorge.martini97">Jorge Martini Schwenke</a>
		</div>
	</footer>
</body>
</html>