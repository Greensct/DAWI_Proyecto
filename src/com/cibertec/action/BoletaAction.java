package com.cibertec.action;

import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.cibertec.entidad.Detalle;
import com.cibertec.entidad.Producto;
import com.cibertec.entidad.Usuario;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("dawi")

public class BoletaAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private List<Usuario> listUsuarios;
	private List<Producto> listaProductos;
	private List<Detalle> listaDetalle;

}
