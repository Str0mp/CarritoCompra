package com.str0mp.tienda.modelo;

public interface UsuariosDAO {

	public int verificarUsuario(UsuariosVO usuario) throws Exception;
	
	public void registrarUsuario(UsuariosVO usuario) throws Exception ;
	
	
}
