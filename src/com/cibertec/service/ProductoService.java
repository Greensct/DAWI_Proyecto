package com.cibertec.service;

import java.util.List;
import com.cibertec.fabrica.DAOFactory;
import com.cibertec.interfaces.ProductoDAO;
import com.cibertec.interfaces.CategoriaDAO;
import com.cibertec.entidad.Producto;
import com.cibertec.entidad.Categoria;


public class ProductoService {
	// Paso 1: Crear la fabrica indicando el tipo de BD a usar
	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	// Paso 2: indicar en DAO a trabajar
	ProductoDAO dao = fabrica.getProductoDAO();
	CategoriaDAO daoCate = fabrica.getCategoriaDAO();
	
	public List<Producto> listaProductos(){
		return dao.listProducto();
	}
	public List<Producto> listaProductosPrincipal(){
		return dao.listProductoprincipal();
	}
	public int registrarProducto(Producto pro) {
		return dao.addProducto(pro);
	}
	public int eliminarProducto(int id) {
		return dao.deleteProducto(id);
	}
	public int actualizarProducto(Producto pro) {
		return dao.updateProducto(pro);
	}
	public List<Categoria> listaCategorias(int cate){
		return daoCate.listAllCategorias(cate);
	}
	public int actualizarFotoProducto(Producto pro) {
		return dao.updateFotoProducto(pro);
	}
	public Producto fotoProductoAtCodigo(int cod) {
		return dao.findProducto(cod);
	}
	public List<Producto> listaProductosPorNombre(String nom){
		return dao.listProductoAtNombre(nom);
	}
}

	
	
