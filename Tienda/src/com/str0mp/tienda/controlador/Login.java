package com.str0mp.tienda.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.str0mp.tienda.modelo.UsuariosDAO;
import com.str0mp.tienda.modelo.UsuariosImpl;
import com.str0mp.tienda.modelo.UsuariosVO;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("cerrar") != null) {
			request.getSession().invalidate();
			response.sendRedirect("Index.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion;
		
		if(request.getParameter("usuario") != null && request.getParameter("contraseña") != null) {
			
			UsuariosDAO u = new UsuariosImpl();
			
			try {
				switch (u.verificarUsuario(new UsuariosVO(0, request.getParameter("usuario"), request.getParameter("contraseña"), 0))) {
				case 1:
					sesion = request.getSession();
					sesion.setAttribute("usuario", request.getParameter("usuario"));
					sesion.setAttribute("nivel", "1");
					response.sendRedirect("Index.jsp");
					break;
					
				case 2:
					sesion = request.getSession();
					sesion.setAttribute("usuario", request.getParameter("usuario"));
					sesion.setAttribute("nivel", "2");
					response.sendRedirect("Index.jsp");
					break;

				case 0:					
					response.sendRedirect("Login.jsp");
					break;
					
				default:
					response.sendRedirect("Login.jsp");
					break;
				}
			} catch (Exception ex) {
				System.out.println("Error Servlet Login: " + ex.getMessage());
			}
			
			
			
		}
		
		
	}

}
