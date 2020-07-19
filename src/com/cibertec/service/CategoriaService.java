package com.cibertec.service;

import java.util.List;
import com.cibertec.fabrica.DAOFactory;
import com.cibertec.interfaces.CategoriaDAO;
import com.cibertec.entidad.Categoria;

public class CategoriaService {
	// Paso 1: Crear la fabrica indicando el tipo de BD a usar
	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	// Paso 2: indicar en DAO a trabajar
	CategoriaDAO dao = fabrica.getCategoriaDAO();

	public List<Categoria> listarCategorias(){
		return dao.listCategoria();
}
}

		
	