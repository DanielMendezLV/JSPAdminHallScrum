package org.hellscrum.detalle;

public class detalleEquipo {


	public detalleEquipo(String usuario, String rol) {
		super();
		this.Usuario = usuario;
		this.Rol = rol;
	}
	public detalleEquipo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getRol() {
		return Rol;
	}
	public void setRol(String rol) {
		Rol = rol;
	}
	public Integer idEquipo;
	public String Equipo;
	public String Usuario;
	public String Rol;
	
}
