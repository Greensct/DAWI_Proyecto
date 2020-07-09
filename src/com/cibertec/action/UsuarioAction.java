package com.cibertec.action;

import com.opensymphony.xwork2.ActionSupport;

public class UsuarioAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	//atributos para la sesi�n
	private String login,clave;
	
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
													@Result(name="error",type="redirect",location="/login.jsp")
												})
		public String iniciarSesion() {
			//crear un objeto de la clase usuario y setear los atributos login y clave
			Usuario obj=new Usuario();
			obj.setLogin(login);
			obj.setClave(clave);
			//invocar al m�todo iniciarSesion
			Usuario bean=servicioUsuario.iniciarSesion(obj);
			//validar el objeto "bean"
			if(bean==null) {
				session.put("MENSAJE", "Usuario y/o clave incorrectos...");
				return "error";
			}
			else {
				//traer los enlances seg�n el c�digo del usuario
				List<Enlace> listaEnlaces=servicioUsuario.traerEnlancesPorUsuario(bean.getCodigoUsuario());
				//crear atributo
				session.put("ENLACES", listaEnlaces);
				session.put("USUARIO",bean);
				return "ok";
			}
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
}