package com.cibertec.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.SessionMap;

import com.cibertec.entidad.Enlace;
import com.cibertec.entidad.Usuario;
import com.cibertec.service.UsuarioService;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("dawi")
public class UsuarioAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	//atributos para la sesi�n
	private String login,clave;
	private String nombres, apellidos, email, contra;
	

	//atributo del servicio
	private UsuarioService servicioUsuario;
	
	//atributo tipo sesi�n
	private Map<String, Object> session=(Map<String, Object>)ActionContext.getContext().getSession();
	//constructor
		public UsuarioAction() {
			servicioUsuario=new UsuarioService();
		}
		

		//acci�n para iniciar sesi�n
		@Action(value="/iniciarSesion",results= {
													@Result(name="ok",type="redirect",location="/menu.jsp"),
													@Result(name="error",type="redirect",location="/menu.jsp")
												})
		public String iniciarSesion() {
			//crear un objeto de la clase usuario y setear los atributos login y clave
			Usuario obj=new Usuario();
			obj.setEmail(login);
			obj.setPassword(clave);
			//invocar al m�todo iniciarSesion
			Usuario bean=servicioUsuario.iniciarSesion(obj);
			//validar el objeto "bean"
			if(bean==null) {
				session.put("MENSAJE", "Usuario y/o clave incorrectos...");
				return "error";
			}
			else {
				//traer los enlances seg�n el c�digo del usuario
				List<Enlace> listaEnlaces=servicioUsuario.traerEnlancesPorUsuario(bean.getIdusuario());
				//crear atributo
				session.put("ENLACES", listaEnlaces);
				session.put("USUARIO",bean);
				return "ok";
			}
		}	
		//acci�n para cerrar sesi�n
		@Action(value="/cerrarSesion",results= {@Result(name="ok",type="redirect",location="/login.jsp")})
		public String cerarrSesion() {
			//obtener la sesi�n actual
			SessionMap sessionActual=(SessionMap) ActionContext.getContext().getSession();
			sessionActual.invalidate();
			return "ok";
		}
		//Accion para registrar usuario
		@Action(value="/addUsuario",results=
				{@Result(name="ok",type="redirect",location="/login.jsp") })
				public String addUsuario(){

				Usuario obj = new Usuario();
				obj.setNombres(nombres);
				obj.setApellidos(apellidos);
				obj.setEmail(email);
				obj.setPassword(contra);
				int estado;
				estado=servicioUsuario.registrarUsuario(obj);
				if(estado!=-1)
				session.put("MENSAJE", "Se registro correctamente el producto");
				else
				session.put("MENSAJE", "Error en el registro del producto");
				
				 return "ok";
				 }
	
		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getClave() {
			return clave;
		}

		public void setClave(String clave) {
			this.clave = clave;
		}

		public String getNombres() {
			return nombres;
		}


		public void setNombres(String nombres) {
			this.nombres = nombres;
		}


		public String getApellidos() {
			return apellidos;
		}


		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getContra() {
			return contra;
		}


		public void setContra(String contra) {
			this.contra = contra;
		}

}