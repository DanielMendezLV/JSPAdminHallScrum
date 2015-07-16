package org.hellscrum.bean;

public class equipo {

	public equipo(Integer idequipo, String nombre) {
		super();
		this.idequipo = idequipo;
		this.nombre = nombre;
	}
	public equipo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdequipo() {
		return idequipo;
	}
	public void setIdequipo(Integer idequipo) {
		this.idequipo = idequipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer idequipo;
	public String nombre;
}
