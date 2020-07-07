package com.cibertec.service;

import com.cibertec.fabrica.DAOFactory;
import com.cibertec.interfaces.CategoriaDAO;

public class CategoriaService {
	// Paso 1: Crear la fabrica indicando el tipo de BD a usar
	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	// Paso 2: indicar en DAO a trabajar
	CategoriaDAO dao = fabrica.getCategoriaDAO();

}