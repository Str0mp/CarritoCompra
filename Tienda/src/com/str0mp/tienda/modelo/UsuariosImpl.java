package com.str0mp.tienda.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuariosImpl extends Mysql implements UsuariosDAO {
	ResultSet rs;
	PreparedStatement ps;	
	
	@Override
	public int verificarUsuario(UsuariosVO usuario) throws Exception {
		try {
			ps = this.obtenerConexion().prepareStatement("SELECT * FROM usuarios");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				if(usuario.getUsuario().equals(rs.getString("usuario")) && usuario.getContraseña().equals(rs.getString("contraseña"))) {
					return rs.getInt("nivel");
				}
			}			
		} catch (SQLException ex) {
			throw ex;
		}
		return 0;
	}

	@Override
	public void registrarUsuario(UsuariosVO usuario) throws Exception {
		try {
			ps = this.obtenerConexion().prepareStatement("INSERT INTO usuarios(usuario,contraseña,nivel) VALUES(?,?,?)");
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getContraseña());
			ps.setInt(3, usuario.getNivel());
			ps.executeUpdate();
		} catch (Exception ex) {
			throw ex;
		}
		
	}

}
