package com.str0mp.tienda.modelo;

import java.util.ArrayList;

public interface ProductosDAO {

	public ArrayList<ProductosVO> listaProductos() throws Exception;
	
	public ProductosVO obtenerProducto(int id) throws Exception;
	
	public void registrarProducto(ProductosVO producto) throws Exception;
	
	public void eliminarProducto(int id) throws Exception;
	
}
