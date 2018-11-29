package com.str0mp.tienda.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.str0mp.tienda.modelo.Articulo;
import com.str0mp.tienda.modelo.ProductosDAO;
import com.str0mp.tienda.modelo.ProductosImpl;
import com.str0mp.tienda.modelo.ProductosVO;

@WebServlet("/EliminarCarro")
public class EliminarCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EliminarCarro() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idProducto = Integer.parseInt(request.getParameter("idproducto"));
		
		HttpSession sesion = request.getSession(true);
		ArrayList<Articulo> listaArticulos = sesion.getAttribute("carro") == null ? null : (ArrayList)sesion.getAttribute("carro");
		
		if(listaArticulos != null) {
			for(Articulo a: listaArticulos) {
				if(a.getIdProducto() == idProducto) {
					listaArticulos.remove(a);
					break;
				}
			}
		}
		
		int total = 0;
		ProductosDAO prod = new ProductosImpl();
		
		for(Articulo a : listaArticulos) {
			try {
				ProductosVO producto = prod.obtenerProducto(a.getIdProducto());
				total += a.getCantidad() * producto.getPrecio();
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}
		
		response.getWriter().println(total);
		
		
		
	}

}
