package com.cibertec.dao;

import java.util.List;

import com.cibertec.entidad.Usuario;
import com.cibertec.interfaces.UsuarioDAO;

public class MySqlUsuarioDAO implements UsuarioDAO {

	@Override
	public int addUsuario(Usuario pro) {

		return 0;
	}

	@Override
	public int updateUsuario(Usuario pro) {

		return 0;
	}

	@Override
	public int deleteUsuarioo(int id) {

		return 0;
	}

	@Override
	public List<Usuario> listProducto() {

		return null;
	}
	
	@Override
	public Usuario iniciarSesion(Usuario bean) {
		Usuario obj=null;
		//crear una sesión de la conexión "factory"
		SqlSession session=factory.openSession();
		try {
			obj=(Usuario) session.selectOne("SQL_InicarSesion",bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return obj;
	}

}
