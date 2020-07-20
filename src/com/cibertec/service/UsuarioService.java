package com.cibertec.service;

import java.util.List;

import com.cibertec.entidad.Enlace;
import com.cibertec.entidad.Producto;
import com.cibertec.entidad.Usuario;
import com.cibertec.fabrica.DAOFactory;
import com.cibertec.interfaces.UsuarioDAO;

public class UsuarioService {
	// Paso 1: Crear la fabrica indicando el tipo de BD a usar
	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	// Paso 2: indicar en DAO a trabajar
	UsuarioDAO dao = fabrica.getUsuarioDAO();
	
	public Usuario iniciarSesion(Usuario bean) {
		return dao.iniciarSesion(bean);
	}
	public List<Enlace> traerEnlancesPorUsuario(int codUsu) {
		return dao.traerEnlacePorUsuario(codUsu);
	}
	public int registrarUsuario(Usuario usu) {
		return dao.addUsuario(usu);
	}
	
}