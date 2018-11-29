package com.str0mp.tienda.modelo;

public class UsuariosVO {
	private int id;
	private String usuario;
	private String contrase�a;
	private int nivel;
	
	public UsuariosVO() {
		super();		
	}
	
	public UsuariosVO(int id, String usuario, String contrase�a, int nivel) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
		this.nivel = nivel;
	}
	
	public int getId() {
		return id;
	}
	public String getUsuario() {
		return usuario;
	}
	public String getContrase�a() {
		return contrase�a;
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
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
	
	

}
