package com.str0mp.tienda.modelo;

public class ProductosVO {
	private int id;
	private String nombre;
	private String descripcion;
	private int stock;
	private int precio;
	private String imagen;	
	
	public ProductosVO() {
		super();		
	}

	public ProductosVO(int id, String nombre, String descripcion, int stock, int precio, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
		this.imagen = imagen;
	}
	
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public int getStock() {
		return stock;
	}
	public int getPrecio() {
		return precio;
	}
	public String getImagen() {
		return imagen;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
