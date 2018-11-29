package com.str0mp.tienda.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.str0mp.tienda.modelo.Articulo;


@WebServlet("/AgregarCarro")
public class AgregarCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AgregarCarro() {
        super();       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		int idProducto = Integer.parseInt(request.getParameter("idproducto"));
				
		
		response.getWriter().println(cantidad + " " + idProducto);
				

		@SuppressWarnings("unchecked")
		ArrayList<Articulo> listaArticulos = sesion.getAttribute("carro") == null ? new ArrayList<>() : (ArrayList<Articulo>)sesion.getAttribute("carro");
		
		boolean bandera = false;
		
		if(listaArticulos.size() > 0) {
			for(Articulo a : listaArticulos) {
				if(idProducto == a.getIdProducto()) {
					a.setCantidad(a.getCantidad() + cantidad);
					bandera = true;
					break;
				}
			}
		}
		
		if(!bandera) {
			listaArticulos.add(new Articulo(idProducto, cantidad));
		}
		
		sesion.setAttribute("carro", listaArticulos);		
		response.sendRedirect("Carro.jsp");
		
		
		
	}

}
