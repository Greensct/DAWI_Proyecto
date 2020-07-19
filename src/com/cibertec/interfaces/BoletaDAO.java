package com.cibertec.interfaces;

import java.util.List;

import com.cibertec.entidad.Boleta;
import com.cibertec.entidad.Detalle;

public interface BoletaDAO {
	public int registrarBoleta(Boleta bean, List<Detalle> lista);
}
