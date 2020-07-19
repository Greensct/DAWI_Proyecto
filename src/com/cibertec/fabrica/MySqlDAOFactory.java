package com.cibertec.fabrica;

import com.cibertec.dao.MySqlBoletaDAO;
import com.cibertec.dao.MySqlCategoriaDAO;
import com.cibertec.dao.MySqlProductoDAO;
import com.cibertec.dao.MySqlUsuarioDAO;
import com.cibertec.interfaces.BoletaDAO;
import com.cibertec.interfaces.CategoriaDAO;
import com.cibertec.interfaces.ProductoDAO;
import com.cibertec.interfaces.UsuarioDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public ProductoDAO getProductoDAO() {
		return new MySqlProductoDAO();
	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		return new MySqlCategoriaDAO();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new MySqlUsuarioDAO();
	}

	@Override
	public BoletaDAO getBoletaDAO() {
		return new MySqlBoletaDAO();
	}

}