package com.str0mp.tienda.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductosImpl extends Mysql implements ProductosDAO{
	ResultSet rs;
	PreparedStatement ps;
	ArrayList<ProductosVO> lista;
  	
	@Override
	public ArrayList<ProductosVO> listaProductos() throws Exception {
		lista = new ArrayList<>();
		
		try {
			ps = this.obtenerConexion().prepareStatement("SELECT * FROM productos ORDER BY nombre");
			rs = ps.executeQuery();			
			while(rs.next()) {
				lista.add(new ProductosVO(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("stock"), rs.getInt("precio"), rs.getString("imagen")));
			}
			this.cerrarConexion();
		} catch (SQLException ex) {
			throw ex;
		}
		return lista;
	}

	@Override
	public ProductosVO obtenerProducto(int id) throws Exception {
		ProductosVO producto = null;
		try {
			ps = this.obtenerConexion().prepareStatement("SELECT * FROM productos WHERE id=" + id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				producto = new ProductosVO(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("stock"), rs.getInt("precio"), rs.getString("imagen"));
				
			}
		} catch (SQLException ex) {
			throw ex;
		}
		return producto;
	}

	@Override
	public void registrarProducto(ProductosVO producto) throws Exception {
		try {
			ps = this.obtenerConexion().prepareStatement("INSERT INTO productos (nombre,descripcion,stock,precio,imagen) VALUES(?,?,?,?,?)");
			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getDescripcion());
			ps.setInt(3, producto.getStock());
			ps.setInt(4, producto.getPrecio());
			ps.setString(5, producto.getImagen());
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw ex;
		}
	}

	@Override
	public void eliminarProducto(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
