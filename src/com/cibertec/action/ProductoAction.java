package com.cibertec.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.cibertec.entidad.Categoria;
import com.cibertec.entidad.Producto;
import com.cibertec.service.ProductoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("dawi")
public class ProductoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<Producto> listaProductos;
	private Producto producto;
	private int codigoProducto;
	private int codigoCategoria;
	private String nombre;
	private String baseFoto;

	
	private Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().getSession();

	private ProductoService servicioProducto;

	public ProductoAction() {
		servicioProducto = new ProductoService();
	}

	
	@Action(value = "/listAllCategoria", results = { @Result(name = "ok", type = "json") })
	// public String listAllTipoAtCategoria() {
	public String listAllCategoria() {
		servicioProducto.listaCategorias(codigoCategoria);
		return "ok";
	}

	// crear una acci�n que retorne un JSON
	@Action(value = "/findFotoAtProducto", results = { @Result(name = "ok", type = "json") })
	public String findFotoAtProducto() {
		Producto bean = servicioProducto.fotoProductoAtCodigo(codigoProducto);
		if (bean != null)
			baseFoto = Base64.getEncoder().encodeToString(bean.getFotoBytes());
		else
			baseFoto = null;
		return "ok";
	}

	@Action(value = "/listAllProductos", results = { @Result(name = "ok", type = "json") })
	public String listAllProductos() {
		listaProductos = servicioProducto.listaProductos();
		return "ok";
	}

	@Action(value = "/listAllPrincipal", results = { @Result(name = "ok", type = "json") })
	public String listAllPrincipal() {
		listaProductos = servicioProducto.listaProductosPrincipal();
		return "ok";
	}

	@Action(value = "/listAllProductosPorNombre", results = { @Result(name = "ok", type = "json") })
	public String listAllProductosPorNombre() {
		listaProductos = servicioProducto.listaProductosPorNombre(nombre);
		return "ok";
	}

	@Action(value = "/addProducto", results = { @Result(name = "ok", type = "redirect", location = "/producto.jsp") })
	public String addMedicamento() throws IOException {
		int estado;
		if (producto.getFoto() != null) {

			InputStream is = new FileInputStream(producto.getFoto());
			// crear un arreglo de bytes con el tama�o del archivo "is"
			byte arreglo[] = new byte[is.available()];
			// leer el binario "is" y enviar la informaci�n al arreglo de bytes
			is.read(arreglo);
			// setear el atributo fotoBytes con el valor del arreglo
			producto.setFotoBytes(arreglo);
		} else
			producto.setFotoBytes(null);

		estado = servicioProducto.registrarProducto(producto);
		if (estado != -1)
			session.put("MENSAJE", "Se registro correctamente el producto");
		else
			session.put("MENSAJE", "Error en el registro del producto");
		return "ok";
	}

	@Action(value = "/deleteProducto", results = {
			@Result(name = "ok", type = "redirect", location = "/producto.jsp") })
	public String deleteProducto() {
		int estado;
		estado = servicioProducto.eliminarProducto(codigoProducto);
		if (estado != -1)
			session.put("MENSAJE", "Se elimino correctamente el producto");
		else
			session.put("MENSAJE", "Error en la eliminaci�n del producto");
		return "ok";
	}

	// crear una acci�n para actualizar foto del Producto
	@Action(value = "/updateFotoProducto", results = {
			@Result(name = "ok", type = "redirect", location = "/producto.jsp") })
	public String updateFotoProducto() throws IOException {
		int estado;
		// obtener la imagen seleccionada de la vista, dicha imagen se encuentra en el
		// atributo foto que es de tipo File
		InputStream is = new FileInputStream(producto.getFoto());
		// crear un arreglo de bytes con el tama�o del archivo "is"
		byte arreglo[] = new byte[is.available()];
		// leer el binario "is" y enviar la informaci�n al arreglo de bytes
		is.read(arreglo);
		// setear el atributo fotoBytes con el valor del arreglo
		producto.setFotoBytes(arreglo);

		estado = servicioProducto.actualizarFotoProducto(producto);
		if (estado != -1)
			session.put("MENSAJE", "Se actualizo correctamente el producto");
		else
			session.put("MENSAJE", "Error en la actualizaci�n del producto");
		return "ok";
	}

	// crear una acci�n para actualizar Producto
	@Action(value = "/updateProducto", results = {
			@Result(name = "ok", type = "redirect", location = "/producto.jsp") })
	public String updateProducto() {
		int estado;
		estado = servicioProducto.actualizarProducto(producto);
		if (estado != -1)
			session.put("MENSAJE", "Se actualizo correctamente el producto");
		else
			session.put("MENSAJE", "Error en la actualizaci�n del producto");
		return "ok";
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(int codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public String getBaseFoto() {
		return baseFoto;
	}

	public void setBaseFoto(String baseFoto) {
		this.baseFoto = baseFoto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
