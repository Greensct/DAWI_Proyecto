package com.cibertec.service;

import java.util.List;

import com.cibertec.entidad.Boleta;
import com.cibertec.entidad.Detalle;
import com.cibertec.fabrica.DAOFactory;
import com.cibertec.interfaces.BoletaDAO;
import com.cibertec.interfaces.UsuarioDAO;

public class BoletaService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	UsuarioDAO daoUsuario=fabrica.getUsuarioDAO();
	BoletaDAO daoBoleta=fabrica.getBoletaDAO();
	
	public int adicionarBoleta(Boleta bean, List<Detalle> lista) {
		return daoBoleta.registrarBoleta(bean, lista);
	}
}
