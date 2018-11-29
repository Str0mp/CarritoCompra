package com.str0mp.tienda.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql {
	Connection con;

	public Mysql() {
		super();		
	}
	
	public Connection obtenerConexion() throws Exception{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root", "");
		} catch (SQLException | ClassNotFoundException ex) {
			throw ex;
		}		
		return con;
	}
	
	public void cerrarConexion() throws Exception{
		try {
			if(con != null) {
				con.close();
			}
		} catch (SQLException ex) {
			throw ex;
		}
	}
	
	

}
