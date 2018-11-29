package com.str0mp.tienda.controlador;


import java.io.File;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.str0mp.tienda.modelo.ProductosDAO;
import com.str0mp.tienda.modelo.ProductosImpl;
import com.str0mp.tienda.modelo.ProductosVO;






@WebServlet("/IngresoProducto")
@MultipartConfig(fileSizeThreshold = 800 * 800 * 2,
		maxFileSize = 800 * 800 * 10,
		maxRequestSize =  800 * 800 * 50)

public class IngresoProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IngresoProducto() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Part part = request.getPart("imagen");
		String nombreImagen = extractFileName(part);
		
		String rutaImagen = "C:\\Users\\Jorge Martini\\eclipse-workspace\\Tienda\\WebContent\\imagenes\\" + File.separator + nombreImagen;
		File fileSaveDir =new File(rutaImagen);
		
		part.write(rutaImagen + File.separator);
     
		ProductosDAO prod = new ProductosImpl();
		ProductosVO p = new ProductosVO();
		p.setDescripcion(request.getParameter("descripcion"));
		p.setId(0);
		p.setImagen(nombreImagen);
		p.setNombre(request.getParameter("nombre"));
		p.setPrecio(Integer.parseInt(request.getParameter("precio")));
		p.setStock(Integer.parseInt(request.getParameter("stock")));
		try {
			prod.registrarProducto(p);
			response.sendRedirect("Index.jsp");
		} catch (Exception e) {
			System.out.println("Error ingresar producto: " + e.getMessage());
		}
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for(String s : items) {
			if(s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() -1);
			}
		}
		
		
		return "";
	}
	
	
	



}
