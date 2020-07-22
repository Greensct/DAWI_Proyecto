package com.cibertec.interfaces;

import java.util.List;

import com.cibertec.entidad.Categoria;

public interface CategoriaDAO {
	public List<Categoria> listCategoria();
	public int addCategoria(Categoria cat);
	public int updateCategoria(Categoria cat);
	public int deleteCategoria(int id);
	public Categoria findCategoria(int id);
	public List<Categoria> listAllCategorias(int cat);
	
	
}
