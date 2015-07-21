package org.hellscrum.bean;

public class equipo {


	
	public equipo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public equipo(Integer idequipo, String nombre, String mykey) {
		super();
		this.idequipo = idequipo;
		this.nombre = nombre;
		this.mykey = mykey;
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
	public String getMykey() {
		return mykey;
	}
	public void setMykey(String mykey) {
		this.mykey = mykey;
	}
	public Integer idequipo;
	public String nombre;
	public String mykey;
}
