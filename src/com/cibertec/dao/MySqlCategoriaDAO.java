package com.cibertec.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.cibertec.entidad.Categoria;
import com.cibertec.interfaces.CategoriaDAO;

public class MySqlCategoriaDAO implements CategoriaDAO {
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
	public int addCategoria(Categoria cat) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCategoria(Categoria cat) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCategoria(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Categoria> listCategoria() {
		List<Categoria> lista = new ArrayList<Categoria>();
		// crear una sesión de la conexión "factory"
		SqlSession session = factory.openSession();
		try {
			lista = session.selectList("SQL_listarCategorias");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lista;
	}

	@Override
	public Categoria findCategoria(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> listAllCategorias(int cat) {
		// TODO Auto-generated method stub
		return null;
	}

}
