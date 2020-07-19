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
	private List<Categoria> listaCategorias;
	private Producto producto;
	private int codigoProducto;
	private int codigoCategoria;
	private String nombre;
	private String baseFoto;

	// atributo tipo sesión
	private Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().getSession();

	private ProductoService servicioProducto;

	public ProductoAction() {
		servicioProducto = new ProductoService();
	}

	// crear una acción que retorne un JSON
	@Action(value = "/listAllCategoria", results = { @Result(name = "ok", type = "json") })
	// public String listAllTipoAtCategoria() {
	public String listAllCategoria() {
		listaCategorias = servicioProducto.listaCategorias(codigoCategoria);
		return "ok";
	}

	// crear una acción que retorne un JSON
	@Action(value = "/findFotoAtProducto", results = { @Result(name = "ok", type = "json") })
	public String findFotoAtProducto() {
		Producto bean = servicioProducto.fotoProductoAtCodigo(codigoProducto);
		if (bean != null)
			baseFoto = Base64.getEncoder().encodeToString(bean.getFotoBytes());
		else
			baseFoto = null;
		return "ok";
	}

	// @Action(value="/listAllProductos",results= {@Result(name="ok",type="json") })
	// public String listAllProductos() {
	// listaProductos=servicioProducto.listAllProductos();
	// return "ok";
	// }
	// @Action(value="/listAllCategorias",results= {@Result(name="ok",type="json")
	// })
	// public String listAllCategorias() {
	// listaCategorias=servicioProducto.listAllCategorias();
	// return "ok";
	// }
	//
	// @Action(value="/addProducto",results=
	// {@Result(name="ok",type="redirect",location="/producto.jsp") })
	// public String addProducto() throws IOException {
	// int estado;
	// estado=servicioProducto.save(producto);
	// if(estado!=-1)
	// session.put("MENSAJE", "Se registro correctamente el producto");
	// else
	// session.put("MENSAJE", "Error en el registro del producto");
	//
	// return "ok";
	// }
	// @Action(value="/deleteProducto",results=
	// {@Result(name="ok",type="redirect",location="producto.jsp") })
	// public String deleteProducto() throws IOException {
	// int estado;
	// estado=servicioProducto.delete(codigo);
	// if(estado!=-1)
	// session.put("MENSAJE", "Se elimino correctamente el producto");
	// else
	// session.put("MENSAJE", "Error en la eliminación del producto");
	//
	// return "ok";
	// }
	//
	//
	//
	// public List<Producto> getListaProductos() {
	// return listaProductos;
	// }
	//
	// public void setListaProductos(List<Producto> listaProductos) {
	// this.listaProductos = listaProductos;
	// }
	//
	// public List<Categoria> getListaCategorias() {
	// return listaCategorias;
	// }
	//
	// public void setListaCategorias(List<Categoria> listaCategorias) {
	// this.listaCategorias = listaCategorias;
	// }
	//
	// public Producto getProducto() {
	// return producto;
	// }
	//
	// public void setProducto(Producto producto) {
	// this.producto = producto;
	// }
	//
	// public int getCodigo() {
	// return codigo;
	// }
	//
	// public void setCodigo(int codigo) {
	// this.codigo = codigo;
	// }
	//
	//
	//
	// }

	// crear una acción que retorne un JSON
	@Action(value = "/listAllProductos", results = { @Result(name = "ok", type = "json") })
	public String listAllProductos() {
		listaProductos = servicioProducto.listaProductos();
		return "ok";
	}

	// crear una acción que retorne un JSON
	@Action(value = "/listAllProductosPorNombre", results = { @Result(name = "ok", type = "json") })
	public String listAllProductosPorNombre() {
		listaProductos = servicioProducto.listaProductosPorNombre(nombre);
		return "ok";
	}

	// crear una acción para registrar Producto
	@Action(value = "/addProducto", results = { @Result(name = "ok", type = "redirect", location = "/producto.jsp") })
	public String addMedicamento() throws IOException {
		int estado;
		if (producto.getFoto() != null) {

			// obtener la imagen seleccionada de la vista, dicha imagen se encuentra en el
			// atributo foto que es de tipo File
			InputStream is = new FileInputStream(producto.getFoto());
			// crear un arreglo de bytes con el tamaño del archivo "is"
			byte arreglo[] = new byte[is.available()];
			// leer el binario "is" y enviar la información al arreglo de bytes
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

	// crear una acción para eliminar Producto
	@Action(value = "/deleteProducto", results = {
			@Result(name = "ok", type = "redirect", location = "/producto.jsp") })
	public String deleteProducto() {
		int estado;
		estado = servicioProducto.eliminarProducto(codigoProducto);
		if (estado != -1)
			session.put("MENSAJE", "Se elimino correctamente el producto");
		else
			session.put("MENSAJE", "Error en la eliminación del producto");
		return "ok";
	}

	// crear una acción para actualizar foto del Producto
	@Action(value = "/updateFotoProducto", results = {
			@Result(name = "ok", type = "redirect", location = "/producto.jsp") })
	public String updateFotoProducto() throws IOException {
		int estado;
		// obtener la imagen seleccionada de la vista, dicha imagen se encuentra en el
		// atributo foto que es de tipo File
		InputStream is = new FileInputStream(producto.getFoto());
		// crear un arreglo de bytes con el tamaño del archivo "is"
		byte arreglo[] = new byte[is.available()];
		// leer el binario "is" y enviar la información al arreglo de bytes
		is.read(arreglo);
		// setear el atributo fotoBytes con el valor del arreglo
		producto.setFotoBytes(arreglo);

		estado = servicioProducto.actualizarFotoProducto(producto);
		if (estado != -1)
			session.put("MENSAJE", "Se actualizo correctamente el producto");
		else
			session.put("MENSAJE", "Error en la actualización del producto");
		return "ok";
	}

	// crear una acción para actualizar Producto
	@Action(value = "/updateProducto", results = {
			@Result(name = "ok", type = "redirect", location = "/producto.jsp") })
	public String updateProducto() {
		int estado;
		estado = servicioProducto.actualizarProducto(producto);
		if (estado != -1)
			session.put("MENSAJE", "Se actualizo correctamente el producto");
		else
			session.put("MENSAJE", "Error en la actualización del producto");
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

	// public List<TipoProducto> getListaTipoMedicamentos() {
	// return listaTipoMedicamentos;
	// }

	// public void setListaTipoMedicamentos(List<TipoMedicamento>
	// listaTipoMedicamentos) {
	// this.listaTipoMedicamentos = listaTipoMedicamentos;
	// }

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
