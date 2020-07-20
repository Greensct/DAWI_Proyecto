package com.cibertec.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.cibertec.entidad.Producto;
import com.cibertec.interfaces.ProductoDAO;

public class MySqlProductoDAO implements ProductoDAO {
	// crear un objeto que permita obtener la conexión con la base de datos que se
	// encuentra
	// en el archivo ConfiguracionIbatis.xml
	SqlSessionFactory factory = null;
	{
		try {
			// variable para almacenar el nombre del archivo que tiene la conex. a la BD
			String archivo = "ConfiguracionIbatis.xml";
			// leer el arhivo XML
			Reader reader = Resources.getResourceAsReader(archivo);
			// crear objeto según el valor del objeto "reader"
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int addProducto(Producto pro) {
		int estado = -1;
		SqlSession session = factory.openSession();
		try {
			estado = session.insert("SQL_InsertarProducto", pro);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return estado;
	}

	@Override
	public int updateProducto(Producto pro) {
		int estado = -1;
		SqlSession session = factory.openSession();
		try {
			estado = session.update("SQL_ActualizarProducto", pro);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return estado;
	}

	@Override
	public int deleteProducto(int id) {
		int estado = -1;
		SqlSession session = factory.openSession();
		try {
			estado = session.delete("SQL_EliminarProducto", id);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return estado;
	}

	@Override
	public List<Producto> listProducto() {
		List<Producto> lista = new ArrayList<Producto>();
		SqlSession session = factory.openSession();
		try {
			lista = session.selectList("SQL_listarProductos");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lista;
	}
	
	

	@Override
	public Producto findProducto(int id) {
		Producto bean = null;
		SqlSession session = factory.openSession();
		try {
			bean = (Producto) session.selectOne("SQL_fotoProducto", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bean;
	}

	@Override
	public int updateFotoProducto(Producto pro) {
		int estado = -1;
		SqlSession session = factory.openSession();
		try {
			estado = session.update("SQL_ActualizarFotoProducto", pro);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return estado;
	}

	@Override
	public List<Producto> listProductoAtNombre(String nom) {
		List<Producto> lista = new ArrayList<Producto>();
		SqlSession session = factory.openSession();
		try {
			lista = session.selectList("SQL_listarProductosAtNombre", nom);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lista;
	}

	@Override
	public List<Producto> listProductoprincipal() {
		List<Producto> lista = new ArrayList<Producto>();
		SqlSession session = factory.openSession();
		try {
			lista = session.selectList("SQL_listarProductosPrincipal");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lista;
	}

	

}
