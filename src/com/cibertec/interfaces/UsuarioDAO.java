package com.cibertec.interfaces;

import java.util.List;

import com.cibertec.entidad.Usuario;

public interface UsuarioDAO {
	public int addUsuario(Usuario pro);

	public int updateUsuario(Usuario pro);

	public int deleteUsuarioo(int id);

	public List<Usuario> listProducto();
}