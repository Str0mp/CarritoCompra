package com.str0mp.tienda.modelo;

public class UsuariosVO {
	private int id;
	private String usuario;
	private String contraseña;
	private int nivel;
	
	public UsuariosVO() {
		super();		
	}
	
	public UsuariosVO(int id, String usuario, String contraseña, int nivel) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.nivel = nivel;
	}
	
	public int getId() {
		return id;
	}
	public String getUsuario() {
		return usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public int getNivel() {
		return nivel;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
	
	

}
