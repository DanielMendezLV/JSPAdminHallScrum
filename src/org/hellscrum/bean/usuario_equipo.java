package org.hellscrum.bean;

public class usuario_equipo {
	
	
	public usuario_equipo(Integer idusuario, Integer idequipo, Integer idrol) {
		super();
		this.idusuario = idusuario;
		this.idequipo = idequipo;
		this.idrol = idrol;
	}
	public usuario_equipo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	public Integer getIdequipo() {
		return idequipo;
	}
	public void setIdequipo(Integer idequipo) {
		this.idequipo = idequipo;
	}
	public Integer getIdrol() {
		return idrol;
	}
	public void setIdrol(Integer idrol) {
		this.idrol = idrol;
	}
	
	public Integer idusuario;
	public Integer idequipo;
	public Integer idrol;
	
}
