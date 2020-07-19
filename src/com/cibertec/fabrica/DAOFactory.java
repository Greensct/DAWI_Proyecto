package com.cibertec.fabrica;

import com.cibertec.interfaces.BoletaDAO;
import com.cibertec.interfaces.CategoriaDAO;
import com.cibertec.interfaces.ProductoDAO;
import com.cibertec.interfaces.UsuarioDAO;

public abstract class DAOFactory {
	// Orginenes de Datos
	public static final int MYSQL = 1;
	public static final int ORACLE = 2;
	public static final int DB2 = 3;
	public static final int SQLSERVER = 4;
	public static final int XML = 5;
	
	// Registrar DAOs
	public abstract ProductoDAO getProductoDAO();

	public abstract CategoriaDAO getCategoriaDAO();

	public abstract UsuarioDAO getUsuarioDAO();
	
	public abstract BoletaDAO getBoletaDAO();

	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
		case MYSQL:
			return new MySqlDAOFactory();
		case ORACLE:
			return null;
		case DB2:
			return null;
		case SQLSERVER:
			return null;
		case XML:
			return null;
		default:
			return null;
		}
	}
}