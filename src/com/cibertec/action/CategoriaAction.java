package com.cibertec.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.cibertec.entidad.Categoria;
import com.cibertec.service.CategoriaService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("dawi")

public class CategoriaAction extends ActionSupport {

	// atributo de tipo lista de la clase Categoria
	private List<Categoria> listaCategorias;

	// atributo para un servicio "CategoriaService"
	private CategoriaService servicioCategoria;

	// constructor
	public CategoriaAction() {
		servicioCategoria = new CategoriaService();
	}

	// crear una acción que retorne un JSON
	@Action(value = "/listAllCategorias", results = { @Result(name = "ok", type = "json") })
	public String listAllCategorias() {
		listaCategorias = servicioCategoria.listarCategorias();
		return "ok";
	}

	public List<Categoria> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

}