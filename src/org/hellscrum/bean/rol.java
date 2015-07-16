package org.hellscrum.bean;

public class rol {
	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public rol(Integer idRol, String nombre) {
		super();
		this.idRol = idRol;
		this.nombre = nombre;
	}
	public rol() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer idRol;
	public String nombre;
}
