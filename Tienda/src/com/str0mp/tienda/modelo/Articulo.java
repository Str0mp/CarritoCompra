package com.str0mp.tienda.modelo;

public class Articulo {
	int idProducto;
	int cantidad;	
	
	public Articulo() {
		super();		
	}
	
	public Articulo(int idProducto, int cantidad) {
		super();
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}
	
	public int getIdProducto() {
		return idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
