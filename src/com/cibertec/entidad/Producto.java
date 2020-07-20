package com.cibertec.entidad;

import java.io.File;

public class Producto {
	private int idproducto;
	private String nomprod;
	private double precio;
	private String descripcion;
	private File foto;
	private byte[] fotoBytes;
	private int stock;
	private int idcategoria;
	
	private String nombrcategoria;

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getNomprod() {
		return nomprod;
	}

	public void setNomprod(String nomprod) {
		this.nomprod = nomprod;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public File getFoto() {
		return foto;
	}

	public void setFoto(File foto) {
		this.foto = foto;
	}

	public byte[] getFotoBytes() {
		return fotoBytes;
	}

	public void setFotoBytes(byte[] fotoBytes) {
		this.fotoBytes = fotoBytes;
	}

	public int getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getNombrcategoria() {
		return nombrcategoria;
	}

	public void setNombrcategoria(String nombrcategoria) {
		this.nombrcategoria = nombrcategoria;
	}

}